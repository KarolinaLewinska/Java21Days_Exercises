package com.java21days;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;

public class AdvogatoConn {
    XmlRpcClient client;

    public AdvogatoConn() {
        this("http://www.advogato.org:80/XMLRPC");
    }

    public AdvogatoConn(String serverUrl) {
        try {
            XmlRpcClientConfigImpl conf = new XmlRpcClientConfigImpl();
            URL server = new URL(serverUrl);
            conf.setServerURL(server);
            client = new XmlRpcClient();
            client.setConfig(conf);
        } catch (MalformedURLException exception) {
            System.out.println("Błędny format adresu URL: " + serverUrl);
        }
    }

    public Integer getEntryCount(String username) throws IOException, XmlRpcException {
        ArrayList<Object> params = new ArrayList<>();
        params.add(username);
        Integer result = (Integer) client.execute("dziennik.len", params);
        return result;
    }

    public String getEntry(String username, Integer index) throws IOException, XmlRpcException {
        ArrayList<Object> params = new ArrayList<>();
        params.add(username);
        params.add(index);
        String result = (String) client.execute("dziennik.get", params);
        return result;
    }

    public static void main(String[] args) {
        try {
            AdvogatoConn conn = new AdvogatoConn();
            int entryCount = advo.getEntryCount(args[0]);
            if (entryCount > 10) {
                entryCount = 10;
            }
            for (int i = 0; i < entryCount; i++) {
                String entry = conn.getEntry(args[0], i);
                System.out.println(entry);
            }
            System.out.println("");
        } catch (IOException | XmlRpcException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
}
