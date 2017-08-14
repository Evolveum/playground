/*
 * Copyright (c) 2017 Evolveum
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.evolveum.playground.psclient;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.LogManager;

import org.apache.cxf.BusFactory;
import org.apache.http.client.config.AuthSchemes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.evolveum.powerhell.AbstractPowerHellWinRmImpl;
import com.evolveum.powerhell.PowerHell;
import com.evolveum.powerhell.PowerHellCommunicationException;
import com.evolveum.powerhell.PowerHellExecutionException;
import com.evolveum.powerhell.PowerHellLocalExecImpl;
import com.evolveum.powerhell.PowerHellSecurityException;
import com.evolveum.powerhell.PowerHellWinRmExecPowerShellImpl;
import com.evolveum.powerhell.PowerHellWinRmLoopImpl;

// Run with:
// mvn clean install exec:java

public class Main {
	
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	
	private static void setNetConfig(AbstractPowerHellWinRmImpl powerHell) {
		
//		String endpointUrl = "https://chimera.lab.evolveum.com:5986/wsman";
		String endpointUrl = "https://medusa.lab.evolveum.com:5986/wsman";
		
		System.out.println("Endpoint: "+endpointUrl);
		
		powerHell.setEndpointUrl(endpointUrl);
		powerHell.setDisableCertificateChecks(true);

		powerHell.setAuthenticationScheme(AuthSchemes.CREDSSP);
		powerHell.setDomainName("win");
		powerHell.setUserName("idmadmin");
		powerHell.setPassword("Secret.123");

//		powerHell.setAuthenticationScheme(AuthSchemes.CREDSSP);
//		powerHell.setDomainName("ad");
//		powerHell.setUserName("midpoint");
//		powerHell.setPassword("qwe.123");
		
	}
	
	private static PowerHell createPowerHell() {
		return createPowerHellExecLocal();
	}
	
	private static PowerHell createPowerHellLoop() {
		PowerHellWinRmLoopImpl powerHell = new PowerHellWinRmLoopImpl();
		setNetConfig(powerHell);
		powerHell.setInitScriptlet("write-host INITHELLO; $foo = 'bar'");
		return powerHell;
	}
	
	private static PowerHell createPowerHellExecPowerShell() {
		PowerHellWinRmExecPowerShellImpl powerHell = new PowerHellWinRmExecPowerShellImpl();
		setNetConfig(powerHell);
		return powerHell;
	}
	
	private static PowerHell createPowerHellExecLocal() {
		PowerHellLocalExecImpl powerHell = new PowerHellLocalExecImpl();
		return powerHell;
	}
	
//	private static PowerHell createPowerHellExecLocal() {
//		PowerHellLocalExecImpl powerHell = new PowerHellLocalExecImpl();
//		return powerHell;
//	}

	public static void main(String[] args) {
		
		Thread.currentThread().setName("main");
		try {
			LogManager logManager = LogManager.getLogManager();
			logManager.reset();
			InputStream logis = new FileInputStream("src/main/resources/logging.properties");
			logManager.readConfiguration(logis);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		PowerHell powerHell = createPowerHell();
		
        try {

    		System.out.println("Connecting PowerHell "+powerHell.getClass().getSimpleName());

    		powerHell.connect();
    		
    		System.out.println("PowerHell connected");
    		
//    		runPowerShell(powerHell);
    		runExec(powerHell);
    		    		
        } catch (Throwable e) {
        	System.err.println("EXCEPTION: "+e.getClass().getSimpleName()+": "+e.getMessage());
        	e.printStackTrace();
            
        } finally {
            System.out.println("Shutting down ...");
            powerHell.disconnect();
			BusFactory.getDefaultBus().shutdown(true);
        }
	}

	private static void runPowerShell(PowerHell powerHell) throws PowerHellExecutionException, PowerHellSecurityException, PowerHellCommunicationException {
		run(powerHell, "hostname");
		
		run(powerHell, "ipconfig");
		
		try {
			run(powerHell, "ajksfhjkfdsgh");
		} catch (PowerHellExecutionException e) {
			// expected
			System.out.println("ERROR(expected): "+e.getMessage());
		}
		
		run(powerHell, "hostname");
		
		run(powerHell, "write-host $foo");
		
		run(powerHell, "    write-host 'START'\n   $x = 'XXX'\n        write-host $x\nwrite-host 'END'");
		
		run(powerHell, "hostname");
		
		try {
			
			run(powerHell, "blabla\nblabol");
			
			System.out.println("ERROR: expected exception haven't happened");
		} catch (PowerHellExecutionException e) {
			System.out.println("Expected exception:\n"+e.getMessage());
		}
		
		run(powerHell, "hostname");
		
		run(powerHell, "write-host 'S'\n$powerhellCommand = 'SSS';$powerhellLine='LLL';$e='EEE'\n    write-host '11' + $powerhellCommand +  $powerhellLine + $e + '22'\nwrite-host 'E'");
		
		run(powerHell, "hostname");
		
		run(powerHell, "write-host 'wait...';Start-Sleep -s 3; write-host 'ideme'");
		
		run(powerHell, "\n\n");
		
		run(powerHell, "hostname");
		
		LOG.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA start");
		run(powerHell, "write-host 'seppuku'; exit");
		LOG.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA end");
		
		run(powerHell, "hostname");
	}

	private static void runExec(PowerHell powerHell) throws PowerHellExecutionException, PowerHellSecurityException, PowerHellCommunicationException {
		run(powerHell, "hostname");
		
		run(powerHell, "ipconfig");
		
		try {
			run(powerHell, "ajksfhjkfdsgh");
		} catch (PowerHellExecutionException e) {
			// expected
			System.out.println("ERROR(expected): "+e.getMessage());
		}
		
		run(powerHell, "hostname");
				
		try {
			
			run(powerHell, "blabla\nblabol");
			
			System.out.println("ERROR: expected exception haven't happened");
		} catch (PowerHellExecutionException e) {
			System.out.println("Expected exception:\n"+e.getMessage());
		}
				
		run(powerHell, "hostname");
		
		run(powerHell, "ipconfig /all");
		
		run(powerHell, "hostname");
	}

	private static void run(PowerHell powerHell, String command) throws PowerHellExecutionException, PowerHellSecurityException, PowerHellCommunicationException {
		System.out.println("#### Running: "+command);
		long tsStart = System.currentTimeMillis();
		
		String out = powerHell.runCommand(command);
		
		long tsEnd = System.currentTimeMillis();
		System.out.println("Finished: "+command+" run time: "+(tsEnd-tsStart)+"ms");
		System.out.println("-----");
		System.out.println(out);
		System.out.println("-----");
	}
}
