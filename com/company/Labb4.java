package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Labb4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ange ett sök ord: " );
        String ord = sc.nextLine();
        try {
            File startingFolder = new File("C://path//to//Testdata");

            System.out.println("Starting Path: " + startingFolder.getCanonicalPath());
            System.out.println("Contains: " + Arrays.toString(startingFolder.list()));
            System.out.println("-------");
            System.out.println();
            System.out.println("Filen " + ord + " textsträngen finns i filen!");
            System.out.println("Filen " + ord + " textsträngen finns inte i filen!");


            printInfo(startingFolder);
        } catch (Exception e) {
            System.out.println("Oops");
        }
    }

    public static void printInfo(File file) {
        // Om det är en vanlig fil: Skriv ut namnet på filen
        // Om det är en mapp: Skriv ut sökvägen på mappen, och gå in i mappen

        if (file.isFile()) {
            System.out.println("Fil: " + file.getName());
        } else if (file.isDirectory()) {
            try {
                System.out.println("Mapp: " + file.getCanonicalPath());


                File[] folderContents = file.listFiles();
                for (int i = 0; i < folderContents.length; i++) {
                    File f = folderContents[i];
                    printInfo(f);
                }

            } catch (Exception e) {
                System.out.println("Oops");
            }
        }
    }
}