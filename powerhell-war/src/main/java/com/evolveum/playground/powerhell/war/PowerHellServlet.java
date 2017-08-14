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
package com.evolveum.playground.powerhell.war;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngine;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.BusFactory;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.impl.auth.SSLEngineFactory;

import com.evolveum.powerhell.PowerHell;
import com.evolveum.powerhell.PowerHellCommunicationException;
import com.evolveum.powerhell.PowerHellExecutionException;
import com.evolveum.powerhell.PowerHellSecurityException;

import org.apache.tomcat.util.net.SSLContext;
import org.apache.tomcat.util.net.SSLHostConfig;
import org.apache.tomcat.util.net.SSLHostConfigCertificate;
import org.apache.tomcat.util.net.SSLHostConfigCertificate.Type;
import org.apache.tomcat.util.net.SSLImplementation;
import org.apache.tomcat.util.net.SSLUtil;

/**
 * @author semancik
 *
 */
public class PowerHellServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			doIt(response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("ERROR: "+e.getMessage());
		}
		
	}
	
	private void doIt(PrintWriter out) throws PowerHellExecutionException, PowerHellSecurityException, PowerHellCommunicationException {
		String endpointUrl = "https://medusa.lab.evolveum.com:5986/wsman";
		
		out.println("PowerHell");
		out.println("Endpoint: "+endpointUrl);
		
		PowerHell powerHell = new PowerHell();
		powerHell.setEndpointUrl(endpointUrl);
		powerHell.setDisableCertificateChecks(true);
		powerHell.setSslEngineFactory(createSslEngineFactory());

		powerHell.setAuthenticationScheme(AuthSchemes.CREDSSP);
		powerHell.setDomainName("win");
		powerHell.setUserName("idmadmin");
		powerHell.setPassword("Secret.123");
		
		System.out.println("Connecting PowerHell ...");
		powerHell.connect();
		System.out.println("... connected");

		run(powerHell, out, "hostname");
		
		System.out.println("Disconnecting powerhell ...");
        powerHell.disconnect();
        System.out.println("... disconnected");
	}
	
	private SSLEngineFactory createSslEngineFactory() {
		List<String> protocols = new ArrayList<>();
		protocols.add("org.apache.coyote.http11.Http11NioProtocol");
		
		final SSLContext sslContext;
		try {

			SSLImplementation sslImplementation = SSLImplementation.getInstance("org.apache.tomcat.util.net.openssl.OpenSSLImplementation");
			System.out.println("Got OpenSSL implementation: "+sslImplementation);
			SSLHostConfig sslHostConfig = new SSLHostConfig();
//			sslHostConfig.setProtocols("org.apache.coyote.http11.Http11NioProtocol");
			SSLHostConfigCertificate hostCertificateConfig = new SSLHostConfigCertificate(sslHostConfig, Type.UNDEFINED);
			SSLUtil sslUtil = sslImplementation.getSSLUtil(hostCertificateConfig);
			System.out.println("Got sslUtil: "+sslUtil);
			sslContext = sslUtil.createSSLContext(protocols);
			System.out.println("Got sslContext: "+sslContext);
		
		} catch (UnsatisfiedLinkError e) {
			System.out.println("Cannot instantiate OpenSSL implementation, probably not available");
			e.printStackTrace();
			return null;
			
		} catch (Throwable e) {
			System.out.println("Cannot instantiate OpenSSL implementation");
			e.printStackTrace();
			return null;
		}
		
		return new SSLEngineFactory() {

			@Override
			public SSLEngine createSslEngine() {
				return sslContext.createSSLEngine();
			}
			
			
		}; 
	}

	private static void run(PowerHell powerHell, PrintWriter out, String command) throws PowerHellExecutionException, PowerHellSecurityException, PowerHellCommunicationException {
		System.out.println("#### Running: "+command);
		long tsStart = System.currentTimeMillis();
		
		String output = powerHell.runCommand(command);
		
		long tsEnd = System.currentTimeMillis();
		System.out.println("Finished: "+command+" run time: "+(tsEnd-tsStart)+"ms");
		System.out.println("-----");
		System.out.println(output);
		System.out.println("-----");
		
		out.println("\n" + command + " -->\n" + output + "\n\n");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopping");
		BusFactory.getDefaultBus().shutdown(true);
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}
