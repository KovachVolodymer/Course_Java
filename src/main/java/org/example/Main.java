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

       withJava17();
       end=System.nanoTime();
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

    public static void withJava6()throws FileNotFoundException, IOException{
        ArrayList<Integer> numbers=new ArrayList<>();
        BufferedReader br=null;
        try {
            br=new BufferedReader(new FileReader("E:\\Навчання\\10n.txt"));
            String file;
            while ((file = br.readLine())!= null)
            {
                numbers.add(Integer.valueOf(file));
            }
        } finally {
            if (br!=null) {
                br.close();
            }
        }
        System.out.println(numbers.size());
    }

    public static void withScanner()throws FileNotFoundException, IOException{
        ArrayList<Integer> numbers=new ArrayList<>();
        Scanner sc=null;
        try {
            sc=new Scanner(new FileReader("E:\\Навчання\\10n.txt"));
            while (sc.hasNextInt()) {
                numbers.add(sc.nextInt());
            }
        } finally {
            if (sc!=null) {
                sc.close();
            }
        }
        System.out.println(numbers.size());
    }

    public static void withJava17()throws FileNotFoundException, IOException{
        ArrayList<Integer> numbers=new ArrayList<>();
        try (var br=new BufferedReader(new FileReader("E:\\Навчання\\10n.txt")) ) {
            String file;
            while ((file = br.readLine())!= null)
            {
                numbers.add(Integer.valueOf(file));
            }
        }
        System.out.println(numbers.size());
    }







}