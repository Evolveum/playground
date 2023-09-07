package com.mycompany;

import org.apache.wicket.util.time.Duration;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.resource.PathResource;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Start {
    public static void main(String[] args) throws Exception {
        int timeout = (int) Duration.ONE_HOUR.getMilliseconds();

        Server server = new Server();

        HttpConfiguration httpConfiguration = new HttpConfiguration();
        httpConfiguration.setSecureScheme("https");
        httpConfiguration.setSecurePort(8443);
        httpConfiguration.setOutputBufferSize(32768);

        ServerConnector http = new ServerConnector(server, new HttpConnectionFactory(httpConfiguration));
        http.setPort(8080);
        http.setIdleTimeout(timeout);


//        SocketConnector connector = new SocketConnector();
//
//        // Set some timeout options to make debugging easier.
//        connector.setMaxIdleTime(timeout);
//        connector.setSoLingerTime(-1);
//        connector.setPort(8080);
        server.addConnector(http);
        Path resourcePath = Paths.get("/keystore");
        Resource keystore = new PathResource(resourcePath);

        if (keystore != null && keystore.exists()) {
            // if a keystore for a SSL certificate is available, start a SSL
            // connector on port 8443.
            // By default, the quickstart comes with a Apache Wicket Quickstart
            // Certificate that expires about half way september 2021. Do not
            // use this certificate anywhere important as the passwords are
            // available in the source.

            SslContextFactory factory = new SslContextFactory.Server();
            factory.setKeyStoreResource(keystore);
            factory.setKeyStorePassword("wicket");
            factory.setTrustStoreResource(keystore);
            factory.setKeyManagerPassword("wicket");
//            SslSocketConnector sslConnector = new SslSocketConnector(factory);
//            sslConnector.setMaxIdleTime(timeout);
//            sslConnector.setPort(8443);
//            sslConnector.setAcceptors(4);
//            server.addConnector(sslConnector);

            System.out.println("SSL access to the quickstart has been enabled on port 8443");
            System.out.println("You can access the application using SSL on https://localhost:8443");
            System.out.println();
        }

        WebAppContext bb = new WebAppContext();
        bb.setServer(server);
        bb.setContextPath("/");
        bb.setWar("src/main/webapp");

        // START JMX SERVER
        // MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        // MBeanContainer mBeanContainer = new MBeanContainer(mBeanServer);
        // server.getContainer().addEventListener(mBeanContainer);
        // mBeanContainer.start();

        server.setHandler(bb);

        try {
            System.out.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
            server.start();
            System.in.read();
            System.out.println(">>> STOPPING EMBEDDED JETTY SERVER");
            server.stop();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
