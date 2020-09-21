package com.company;

import java.io.File;
import java.util.Scanner;
// Jag började med att lägga till testData mappen från Andreas gitrep, den innehåller massa saker.

public class Labb2 {

    public static void main(String[] args){
    // här har ni main funktionen som kallar på vilket ord vi ska söka efter och var mapträdet börjar
        File startingFolder = new File("C:\\GitHub\\Labb arbete1\\testData");

        Scanner sc = new Scanner(System.in);
        System.out.println("Vilket ord ska vi söka på?");
        String word = sc.next();

        findFiles(startingFolder, word);
//här kallar jag på funktionen att gå igenom alla filer
    }

    public static void findFiles(File file, String word){
        //i denna funktion delar den upp om det är en fil eller map.
        if(file.isFile()){

            printPath(file, word);
// här kallar jag på en funktion som ska print path om filen har ett ord i sig
        } else if(file.isDirectory()){
            try {
                File[] folderContents = file.listFiles();
                for(File f : folderContents){

                    findFiles(f, word);
                }
            }catch (Exception e){
                System.out.println("Oops");
            }
        }
    }

// här e sista funktionen som printar path om ordet finns i filen.
    public static void printPath(File file, String word){
        try{
            Scanner sc = new Scanner(file);

            String fileName;
            while (sc.hasNext()){

                fileName = (sc.next());
// för använder man contains istället för equals så fungerar det bara med bokstäver. behöver inte ha fulla ord

                if(fileName.contains(word)) {
                    System.out.println(file.getAbsolutePath());

                }
            }
            sc.close();
        }catch (Exception e){
            System.out.println("Oops");
        }
    }

}
