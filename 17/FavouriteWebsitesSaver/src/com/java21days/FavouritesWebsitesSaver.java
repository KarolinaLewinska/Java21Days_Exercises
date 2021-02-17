package com.java21days;

import java.net.*;
import java.io.*;

public class FavouritesWebsitesSaver {
    URL websiteAddress;

    public FavouritesWebsitesSaver(String address) throws MalformedURLException {
        websiteAddress = new URL(address);
    }

    void saveWebsite() {
        String nameOfFile = websiteAddress.getHost() + "_" + websiteAddress.getFile() + "_file.html";
        File file = new File(nameOfFile);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            HttpURLConnection connection = (HttpURLConnection)
                    websiteAddress.openConnection();
            connection.connect();
            InputStreamReader isr = new InputStreamReader(
                    (InputStream) connection.getContent());
            BufferedReader br = new BufferedReader(isr);
            String lineOfFile;
            do {
                lineOfFile = br.readLine();
                if (lineOfFile != null) {
                    out.write(lineOfFile, 0, lineOfFile.length());
                }
            } while (lineOfFile != null);
            out.flush();
            out.close();
            System.out.println("Zapisano plik" + file.getName());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            FavouritesWebsitesSaver app = new FavouritesWebsitesSaver(args[0]);
            app.saveWebsite();
        } catch (MalformedURLException mue) {
            System.out.println(mue.getMessage());
        }
    }
}
