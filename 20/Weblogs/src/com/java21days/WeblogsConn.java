package com.java21days;

import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class WeblogsConn {
    XmlRpcClient client;

    public WeblogsConn() {
        this("http://localhost:7667/");
    }

    public WeblogsConn(String serverUrl) {
        try {
            XmlRpcClientConfigImpl conf = new XmlRpcClientConfigImpl();
            URL server = new URL(serverUrl);
            conf.setServerURL(server);
            client = new XmlRpcClient();
            client.setConfig(conf);
        } catch (MalformedURLException exception) {
            System.out.println("Zły format adresu URL: " + serverUrl);
        }
    }

    public HashMap ping(String siteName, String siteUrl) throws IOException, XmlRpcException {
        ArrayList<String> params = new ArrayList<>();
        params.add(siteName);
        params.add(siteUrl);
        Object result = client.execute("weblogUpdates.ping", params);
        
        if (result instanceof XmlRpcException) {
            throw (XmlRpcException) result;
        }
        return (HashMap) result;
    }

    public static void main(String[] args) {
        try {
            PingClient ping1 = new PingClient();
            HashMap response = ping1.ping(args[0], args[1]);
            System.out.println(response.get("message"));
        } catch (IOException | XmlRpcException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
}
