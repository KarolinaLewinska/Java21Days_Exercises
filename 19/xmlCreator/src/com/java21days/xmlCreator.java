package com.java21days;

import java.io.*;
import java.sql.*;
import nu.xom.*;

public class xmlCreator {

    public static void main(String[] args) {
        String db = "jdbc:derby://localhost:1527/sample";
        try (
                Connection conn = DriverManager.getConnection(
                        db, "app", "APP");
                Statement statement = conn.createStatement()) {

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            Element root = new Element("products");

            ResultSet query = statement.executeQuery(
                    "select PRODUCT_ID, PRODUCT_CODE, PURCHASE_COST " +
                            "from APP.PRODUCT " +
                            "order by PRODUCT_ID");
            while (query.next()) {
                Element product = new Element("product");

                Element id = new Element("product_id");

                id.appendChild(query.getString(1));

                product.appendChild(id);

                Element productCode = new Element("productCode");
                productCode.appendChild(query.getString(3));
                product.appendChild(productCode);
                Element purchaseCost = new Element("purchaseCost");
                purchaseCost.appendChild(query.getString(4));
                product.appendChild(purchaseCost);
                root.appendChild(product);
            }
            statement.close();

            Document doc = new Document(root);
            doc.setRootElement(root);
            File xml = new File("product-report.xml");
            FileOutputStream xmlFile = new FileOutputStream(xml);
            Serializer output = new Serializer(xmlFile);
            output.setIndent(2);
            output.write(doc);
            xmlFile.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
