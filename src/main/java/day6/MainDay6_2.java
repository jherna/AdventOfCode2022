package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainDay6_2 {

    public static void main(String[] args) {
        URL input = MainDay6_2.class.getResource("input.txt");
        System.out.println(input);
        File file = new File(input.getFile());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line = "";
        List<Character> letters = new ArrayList<>();
        if(sc.hasNext()) line = sc.nextLine();
        for (int i = 0; i < line.length()-14; i++) {
            for (int j = 0; j < 14; j++) letters.add(line.charAt(i+j));
            if(letters.stream().distinct().collect(Collectors.toList()).size() == 14) {
                System.out.println(i+14);
                break;
            } else letters.clear();
        }

    }
}
