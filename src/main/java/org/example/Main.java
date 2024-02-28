package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       long start=System.nanoTime();
        withJava7();
       long end=System.nanoTime();
       System.out.println((end-start)/1_000_000_000.0);
    }

    public static void withJava7()throws FileNotFoundException, IOException{
        ArrayList<Integer> numbers=new ArrayList<>();
        try (BufferedReader br=new BufferedReader(new FileReader("E:\\Навчання\\10n.txt")) ) {
            String file;
            while ((file = br.readLine())!= null)
            {
                numbers.add(Integer.valueOf(file));
            }
        }
        System.out.println(numbers.size());
    }



}