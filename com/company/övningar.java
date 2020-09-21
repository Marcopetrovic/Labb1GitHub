package com.company;

import java.io.File;
import java.util.Scanner;

public class övningar {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Directory to crawl? ");
        String directoryName = console.nextLine();

        File f = new File(directoryName);
        crawl(f);
    }

    // Prints the given file/directory and any files/directories inside it,
    // starting with zero indentation.
    // Precondition: f != null and f exists
    public static void crawl(File file) {
        crawl(file, "");
    }

    // This recursive "helper" method prints the given file/directory and any
    // files/directories inside it at the given level of indentation.
    // Precondition: f != null and f exists
    private static void crawl(File file, String indent) {
        System.out.println(indent + file.getName());
        if (file.isDirectory()) {
            // recursive case: directory
            // print everything in the directory
            File[] subFiles = file.listFiles();
            indent += "    ";
            for (int i = 0; i < subFiles.length; i++) {
                crawl(subFiles[i], indent);
            }
        }
    }
}