/**
 * Copyright (c) 2017 Evolveum
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.evolveum.playground.psclient;

import java.io.StringWriter;
import java.nio.charset.Charset;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cloudsoft.winrm4j.client.Command;
import io.cloudsoft.winrm4j.client.WinRmClient;

/**
 * @author semancik
 *
 */
public class PowerHell {
	
	private static final Logger LOG = LoggerFactory.getLogger(PowerHell.class);
	public static final String PROMPT = ":::P0w3Rh3llPr0mPt:::";
	
	// Configuration
	private String endpointUrl;
	private String authenticationScheme;
	private String domainName;
	private String userName;
	private String password;
	private boolean disableCertificateChecks;
	private String initScriptlet;
	private String prompt = PROMPT;
	
	// State
	private WinRmClient client;
	private Command command;
	
	public String getEndpointUrl() {
		return endpointUrl;
	}

	public void setEndpointUrl(String endpointUrl) {
		this.endpointUrl = endpointUrl;
	}

	public String getAuthenticationScheme() {
		return authenticationScheme;
	}

	public void setAuthenticationScheme(String authenticationScheme) {
		this.authenticationScheme = authenticationScheme;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDisableCertificateChecks() {
		return disableCertificateChecks;
	}

	public void setDisableCertificateChecks(boolean disableCertificateChecks) {
		this.disableCertificateChecks = disableCertificateChecks;
	}

	public String getInitScriptlet() {
		return initScriptlet;
	}

	public void setInitScriptlet(String initScriptlet) {
		this.initScriptlet = initScriptlet;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public void connect() throws PowerHellExecutionException {
		WinRmClient.Builder builder = WinRmClient.builder(endpointUrl, authenticationScheme);
		builder.credentials(domainName, userName, password);
		builder.disableCertificateChecks(disableCertificateChecks);
		client = builder.build();
		
		String psScript = createScript(initScriptlet);
		System.out.println("MAIN LOOP:");
		System.out.println(psScript);
		LOG.trace("Executing powershell. Script: {}", psScript);
		
		long tsStart = System.currentTimeMillis();
		
		command = client.commandAsync("powershell -EncodedCommand "+encodeCommand(psScript));
		
		long tsAfterInit = System.currentTimeMillis();
		LOG.trace("Powershell running. init time: {} ms", tsAfterInit-tsStart);
		
		while (true) {
			Integer exitCode = command.receive();
			
			String out = command.getLastOut();
    		String err = command.getLastErr();
    		logData("O<", out);
    		logData("E<", err);
    		
    		if (out != null && out.contains(prompt)) {
    			LOG.trace("First prompt detected");
    			break;
    		}
    		
    		if (exitCode != null) {
    			LOG.error("Exit code received before first prompt: {}", exitCode);
    			client.disconnect();
    			PowerHellExecutionException e = new PowerHellExecutionException("Exit code received before first prompt", exitCode);
    			e.setStdout(out);
    			e.setStderr(err);
    			throw e;
    		}
    	}
		
	}

	public String runCommand(String outCommandLine) throws PowerHellExecutionException {
		
		long tsCommStart = System.currentTimeMillis();
		
		StringWriter writerStdOut = new StringWriter();
		StringWriter writerStdErr = new StringWriter();
		String promptMessage = null;
		
		String tx = outCommandLine + "\r\n" + prompt + "\r\n";
		logData("I>", tx);
		
		command.send(tx);
		
		while (true) {
			Integer exitCode = command.receive();
			
			String out = command.getLastOut();
    		String err = command.getLastErr();
    		logData("O<", out);
    		logData("E<", err);

    		if (err != null) {
    			writerStdErr.write(err);
    		}
    		
    		if (out != null) {
    			int indexOfPrompt = out.indexOf(prompt);
    			if (indexOfPrompt >=0 ) {
    				writerStdOut.write(out.substring(0,indexOfPrompt));
    				int indexOfEol = out.indexOf("\n", indexOfPrompt);
    				promptMessage = out.substring(indexOfPrompt+prompt.length(), indexOfEol);
    				LOG.trace("Prompt detected, msg: >>{}<<", promptMessage);
    				if (promptMessage != null && !promptMessage.matches("\\s*")) {
    					PowerHellExecutionException e = new PowerHellExecutionException(promptMessage, exitCode);
    	    			e.setStdout(writerStdOut.toString());
    	    			e.setStderr(writerStdErr.toString());
    	    			e.setPromptMessage(promptMessage);
    	    			throw e;
    				}
    				break;
    			} else {
    				writerStdOut.write(out);
    			}
    		}
    		
    		if (exitCode != null) {
    			LOG.error("Exit code received during command execution: {}", exitCode);
    			client.disconnect();
    			PowerHellExecutionException e = new PowerHellExecutionException("Exit code received during command execution", exitCode);
    			e.setStdout(writerStdOut.toString());
    			e.setStderr(writerStdErr.toString());
    			e.setPromptMessage(promptMessage);
    			throw e;
    		}
		}		
		
		long tsCommStop = System.currentTimeMillis();
		
		LOG.trace("Command {} run time: {} ms", outCommandLine, tsCommStop-tsCommStart);
		
		return writerStdOut.toString();
	}
	
	public int disconnect() {
		LOG.trace("Disconnecting, sending exit command");
		
		String tx = prompt + " exit\r\n";
		logData("I>", tx);
		
		command.send(tx);
	
		Integer exitCode = null;
		while (true) {
			exitCode = command.receive();
			
			String out = command.getLastOut();
    		String err = command.getLastErr();
    		logData("O<", out);
    		logData("E<", err);

    		if (exitCode != null) {    			
    			LOG.trace("Powershell exit code: {}", exitCode);
    			break;
    		}
		}
		
		command.release();
		client.disconnect();
		
		return exitCode;
	}
	
	private String createScript(String initScriptlet) {
		StringBuilder sb = new StringBuilder();
		if (initScriptlet != null) {
			sb.append(initScriptlet);
			sb.append("\n");
		}
		sb.append("write-host '").append(prompt).append("'\r\n");
		sb.append("while($true) {\r\n");
		sb.append("  $powerhellCommand = ''\r\n");
		sb.append("  while($powerhellLine = [Console]::In.ReadLine()) {\r\n");
		sb.append("    if($powerhellLine -eq \"").append(prompt).append(" exit\") { exit }\r\n");
		sb.append("    if($powerhellLine -eq \"").append(prompt).append("\") { break }\r\n");
		sb.append("    $powerhellCommand = $powerhellCommand + $powerhellLine + \"`n\"\r\n");
		sb.append("  }\r\n");
		sb.append("  Invoke-Expression -ErrorVariable powerhellError $powerhellCommand\r\n");
		sb.append("  write-host '").append(prompt).append("'$powerhellError\r\n");
		sb.append("  $powerhellError = \"\"\r\n");
		sb.append("}\r\n");
		return sb.toString();
	}
	
	private String encodeCommand(String command) {
		byte[] bytes = command.getBytes(Charset.forName("UTF-16LE"));
        return DatatypeConverter.printBase64Binary(bytes);
	}
	
	private void logData(String prefix, String data) {
		if (LOG.isTraceEnabled()) {
			if (data != null && !data.isEmpty()) {
				LOG.trace("{} {}", prefix, data);
			}
		}
	}

}
