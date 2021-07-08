package com.java21days;

import java.io.*;
import nu.xom.*;

public class xmlReader {
     try {
        Builder builder1 = new Builder();
        File xml = new File("product-report.xml");
        Document doc = builder.build(xml);
        Element root = doc.getRootElement();
        Elements products = root.getChildElements("product");
        
          for (int i = 0; i < products.size(); i++) {
            Element product = products.get(i);
            Element productID = product.getFirstChildElement("productID");
            Element productCode = product.getFirstChildElement("productCode");
            Element purchaseCost = product.getFirstChildElement("purchaseCost");
            System.out.println("ID: " + productID.getValue());
            System.out.println("Kod produktu: " + productCode.getValue());
            System.out.println("Koszt zakupu: " + purchaseCost.getValue());
            System.out.println();
        }
    } catch (ParsingException | IOException e) {
        System.out.println("Błąd: " + e.getMessage());
        e.printStackTrace();
    }

    public static void main(String[] args) {
        xmlReader reader1 = new xmlReader();
    }
}
