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
    //part 2:

    /**
     *  X needs to loose
     *  Y needs to draw
     *  Z needs to win
     **/
    private static int rps2(String oponent, String you) {
        int sum = 0;
        switch (you) {
            case "B": // es necessita empatar
                sum = valor(oponent) + 3;
                break;
            case "C": // guanyar
                if(oponent.equals("A")) sum = valor("B");
                if(oponent.equals("B")) sum = valor("C");
                if(oponent.equals("C")) sum = valor("A");
                sum += 6;
                break;

            case "A": // perdre
                if(oponent.equals("A")) sum = valor("C");
                if(oponent.equals("B")) sum = valor("A");
                if(oponent.equals("C")) sum = valor("B");
                sum += 0;


        }

        return sum;
    }

    public static int valor(String p) {
        int v = 0;
        if(p.equals("A")) v = 1;
        if(p.equals("B")) v =  2;
        if(p.equals("C")) v = 3;
        return v;
    }
}
