package com.company;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Labb5 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vilket ord ska jag söka på?");
        String word = sc.nextLine();

        File file = new File("testData");
        searchAllFiles(file, word);
        printPathIfWordIsInFile(file, word);

    }


    public static void searchAllFiles(File file, String word) throws IOException {
        if (file.isFile() && file.equals(word)) {
            System.out.println(file.getCanonicalPath());
        } else if (file.isDirectory()) {
            try {

                File[] folderContents = file.listFiles();
                for (int i = 0; i < folderContents.length; i++) {
                    File f = folderContents[i];
                    searchAllFiles(file, word);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Oops");
        }
    }

        public static void printPathIfWordIsInFile(File file, String word){
            try {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()){
                    System.out.println(file.getCanonicalPath());
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

}
