package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;


public class MainDay2 {

    public static void main(String[] args) {
        URL input = MainDay2.class.getResource("input.txt");
        System.out.println(input);
        File file = new File(input.getFile());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String round;
        String oponent, you;
        int sum = 0;
        while (sc.hasNextLine()) {
            round = sc.nextLine();
            oponent = String.valueOf(round.charAt(0));
            you = String.valueOf(((char) (round.charAt(2) - 23)));
            sum += rps2(oponent, you);
            System.out.printf("%s%s ", oponent, you);
        }
        System.out.printf("%n");
        System.out.printf("Total : " + sum);

    }

    //part 1: Ok
    private static int rps(String oponent, String you) {
        if (oponent.equals(you)) {
            if(oponent.equals("A")) return 4;
            if(oponent.equals("B")) return 5;
            if(oponent.equals("C")) return 6;
        }
        else {
            if (you.equals("A") && oponent.equals("B")) return 1;
            if (you.equals("A") && oponent.equals("C")) return 7;
            if (you.equals("B") && oponent.equals("A")) return 8;
            if (you.equals("B") && oponent.equals("C")) return 2;
            if (you.equals("C") && oponent.equals("A")) return 3;
            if (you.equals("C") && oponent.equals("B")) return 9;
        }
        return 0;
    }
    //part 2: I don't understand the problem
    private static int rps2(String oponent, String you) {
        if (you.equals("A") ) return 4;
        if (you.equals("B") ) return 1;
        if (you.equals("C") ) return 7;
        return 0;
    }
}
