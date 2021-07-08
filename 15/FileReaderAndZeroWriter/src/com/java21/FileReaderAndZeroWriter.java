package com.java21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReaderAndZeroWriter {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("file.txt");
            boolean isTrue = true;
            int sizeOfFile = 0;
            
            while (isTrue) {
                int input = file.read();
                if (input == -1) {
                    isTrue = false;
                } else {
                    sizeOfFile++;
                }
            }
            
            file.close();

            FileOutputStream file2 = new FileOutputStream("file.txt");
            for (int i = 0; i < sizeOfFile; i++) {
                file2.write((byte) 0);
            }
            
            file2.close();
        } catch (IOException e) {
            System.out.println("Błąd " + e.getMessage());
        }
    }
}

