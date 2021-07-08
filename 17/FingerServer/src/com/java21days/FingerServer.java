package com.java21days;

import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.util.*;

public class FingerServer {
    public FingerServer() {
        try (ServerSocketChannel sock = ServerSocketChannel.open(); 
                ServerSocket socket = sock.socket();) {
            
            sock.configureBlocking(false);
            InetSocketAddress server = new InetSocketAddress("localhost", 79);
            socket.bind(server);
            
            Selector selector = Selector.open();
            sock.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();

                Set keys = selector.selectedKeys();
                Iterator it = keys.iterator();

                while (it.hasNext()) {
                    SelectionKey sKey = (SelectionKey) it.next();

                    it.remove();
                    if (sKey.isAcceptable()) {
                        ServerSocketChannel selChannel = (ServerSocketChannel) sKey.channel();
                        ServerSocket sSock = selChannel.socket();
                        try (Socket connection = sSock.accept()) {
                            handleRequest(connection);
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void handleRequest(Socket connection) throws IOException {
        InputStreamReader isr = new InputStreamReader(connection.getInputStream());
        BufferedReader is = new BufferedReader(isr);
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()), false);

        pw.println("Serwer Finger");
        pw.flush();

        String outLine = null;
        String inLine = is.readLine();

        if (inLine.length() > 0) 
            outLine = inLine;
        
        readPlan(outLine, pw);

        pw.flush();
        pw.close();
        is.close();
    }

    private void readPlan(String userName, PrintWriter pw) {
        try (FileReader file = new FileReader(userName + ".plan");
            BufferedReader buff = new BufferedReader(file);) {
            boolean eof = false;

            pw.println("\nNazwa użytkownika: " + userName + "\n");

            while (!eof) {
                String line = buff.readLine();

                if (line == null) 
                    eof = true;
                else 
                    pw.println(line);
            }

            buff.close();
            
        } catch (IOException e) {
            pw.println("Nie znaleziono użytkownika " + userName + ".");
        }
    }

    public static void main(String[] args) {
        FingerServer nio = new FingerServer();
    }
}
