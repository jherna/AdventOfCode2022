package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainDay3_2 {

    public static void main(String[] args) {
        URL input = MainDay3_2.class.getResource("input.txt");
        System.out.println(input);
        File file = new File(input.getFile());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line[] = new String[3];
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int numLines = 0;
        int t = 0;
        while(sc.hasNextLine()) {
            line[numLines++] = sc.nextLine();
            if(numLines % 3 == 0) { //multiple de 3
                numLines = 0;
                String l = line[0];
               Stream<String> stringStream = l.codePoints().mapToObj(c -> String.valueOf((char)c));
               t += stringStream.filter(s -> {
                       if(line[1].contains(s) && line[2].contains(s)) return true;
                       else return false;
               }).distinct()
                 .mapToInt(v -> letters.indexOf(v)+1)
                 .sum();
            }
        }
        System.out.println(t);
    }
}
