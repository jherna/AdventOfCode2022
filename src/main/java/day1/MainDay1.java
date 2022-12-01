package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class MainDay1 {

    public static void main(String[] args) {
        URL input = MainDay1.class.getResource("input.txt");
        System.out.println(input);
        File file = new File(input.getFile());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int sum = 0;
        List<Integer> sumOfCalories = new ArrayList<>();
        while(sc.hasNextLine()) {
            String num = sc.nextLine();
            if(num != "") {
                sum += Integer.parseInt(num);
            } else {
                sumOfCalories.add(sum);
                sum = 0;
            }
        }
        OptionalInt max = sumOfCalories.stream().mapToInt(i -> i).max();
        System.out.println(max.getAsInt());

        int maxInt = sumOfCalories.stream()
                .sorted(Collections.reverseOrder())
                .mapToInt(value -> value)
                .limit(3)
                .sum();
        System.out.println(maxInt);

    }
}
