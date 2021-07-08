package com.java21days;

import java.io.*;
import nu.xom.*;

public class BookFinder {
    public void readXML() {
        try {
            Builder builder1 = new Builder();
            File xmlFile = new File("books.xml");
            Document doc = builder1.build(xmlFile);
            Element root = doc.getRootElement();
            Elements books = root.getChildElements("book");

            for (int i = 0; i < books.size(); i++) {
                Element book = books.get(i);
                Element authorName = book.getFirstChildElement("author");

                if (authorName != null) {
                    Text authorNameText = (Text) authorName.getChild(0);
                    String authorNameValue = authorNameText.getValue();

                    if (authorNameValue.equals("George R.R. Martin")) {
                        System.out.println("Autor: " + authorName);
                        Element title = book.getFirstChildElement("title");
                        showData("Tytuł", title);
                        Element dateOfPublishing = book.getFirstChildElement("dateOfPublishing");
                        showData("Data publikacji", dateOfPublishing);
                        Element publisher = book.getFirstChildElement("publisher");
                        showData("Wydawnictwo", publisher);
                        Element genre = book.getFirstChildElement("genre");
                        showData("Gatunek", genre);
                        Element pagesNumber = book.getFirstChildElement("pagesNumber");
                        showData("Liczba stron", pagesNumber);
                    }
                }
            }
        } catch (ParsingException | IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    void showData(String label, Element element) {
        if (element != null) {
            Text elementText = (Text) element.getChild(0);
            String elementString = elementText.getValue();
            System.out.println(label + ": " + elementString);
        }
    }

    public static void main(String[] args) {
        BookFinder bf1 = new BookFinder();
        bf1.readXML();
    }
}
