package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainDay6 {

    public static void main(String[] args) {
        URL input = MainDay6.class.getResource("input.txt");
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
        boolean trobat = false;
        if(sc.hasNext()) line = sc.nextLine();
        for (int i = 0; i < line.length()-4; i++) {
            letters.add(line.charAt(i));
            letters.add(line.charAt(i+1));
            letters.add(line.charAt(i+2));
            letters.add(line.charAt(i+3));
            if(letters.stream().distinct().toList().size() == 4) {
                System.out.println(i+4);
                break;
            } else letters.clear();
        }

    }
}
