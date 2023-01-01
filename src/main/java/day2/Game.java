package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    List<Integer> resultats = new ArrayList<>();

    //Return 6, 3 o 0 if Hand e win, draw or loose
    public int round(Hand o, Hand e) {
        int sum = 0;
        if(e.getValue() == o.getValue()) sum =  3;
        else if(e.equals(Hand.ROCK) && o.equals(Hand.SCISSORS)) sum = 6;
        else if(e.equals(Hand.ROCK) && o.equals(Hand.PAPER)) sum = 0;
        else if(e.equals(Hand.PAPER) && o.equals(Hand.ROCK)) sum =  6;
        else if(e.equals(Hand.PAPER) && o.equals(Hand.SCISSORS)) sum =  0;
        else if(e.equals(Hand.SCISSORS) && o.equals(Hand.ROCK)) sum = 0;
        else if(e.equals(Hand.SCISSORS) && o.equals(Hand.PAPER)) sum = 6;
        return sum + e.getValue();
    }

    public int resultatRondes() {
        return resultats.stream().mapToInt(p->p).sum();
    }

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
        Game game = new Game();
        int sum = 0;
        while (sc.hasNextLine()) {
            round = sc.nextLine();
            Hand o = getHand(String.valueOf(round.charAt(0)));
            Hand e = getHand(String.valueOf(round.charAt(2)));
            game.resultats.add(game.round(o,e));
            System.out.printf("%s%s ", o.getCode(), e.getCode2());
        }
        System.out.printf("%n");
        System.out.printf("Total : " + game.resultatRondes());
    }

    public static Hand getHand(String s) {
        Hand res =  switch (s) {
            case "A","X" -> Hand.ROCK;
            case "B","Y" -> Hand.PAPER;
            case "C","Z" -> Hand.SCISSORS;
            default -> throw new RuntimeException();
        };
        return res;
    }
}
