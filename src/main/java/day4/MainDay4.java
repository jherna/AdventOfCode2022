package day4;

import day3.MainDay3_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class MainDay4 {

    public static void main(String[] args) {
        URL input = MainDay4.class.getResource("input.txt");
        System.out.println(input);
        File file = new File(input.getFile());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            sc.useDelimiter("-|,|\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        int e1,e2,e3,e4,total=0;
        while(sc.hasNext()) {
            e1 = Integer.parseInt(sc.next());
            e2 = Integer.parseInt(sc.next());
            e3 = Integer.parseInt(sc.next());
            e4 = Integer.parseInt(sc.next());
            if((e1 >= e3 && e2 <= e4) || (e1 <= e3 && e2 >= e4 )){
                total++;
            }
            //System.out.printf("%d-%d %d-%d %d%n",e1,e2,e3,e4,total);
        }
        System.out.println(total);
    }
}
