package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class MainDay3 {

    public static void main(String[] args) {
        URL input = MainDay3.class.getResource("input.txt");
        System.out.println(input);
        File file = new File(input.getFile());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int sum = 0;
        boolean trobat = false;
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            int mid = line.length()/2;
            for (int i = 0; i < mid; i++) {
                for (int j = mid; j < line.length() ; j++) {
                    if(line.charAt(i) == line.charAt(j) && !trobat) {
                        trobat = true;
                        sum += letters.indexOf(line.charAt(i))+1;
                    }
                }
            }
            trobat = false;
        }

        System.out.println(sum);
    }

}
