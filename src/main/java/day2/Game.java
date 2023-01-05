package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    List<Integer> resultats = new ArrayList<>();
    private int estrategia;


    public int getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(int estrategia) {
        this.estrategia = estrategia;
    }

    public int round(int estrategia, Hand o, Hand e) {
        Hand temp;

        if(estrategia == 1) return jugada(o,e) + e.getValue();
        else {
            //Calcular el nou valor del Elf
            temp = triarJugada(o,e);
            return jugada(o,temp) + temp.getValue();
        }
    }

    public Hand triarJugada(Hand o, Hand e) {
        Hand ret = null;

        switch (e) {
            case SCISSORS:
                if(o.equals(Hand.ROCK)) ret = Hand.PAPER;
                else if(o.equals(Hand.PAPER)) ret = Hand.SCISSORS;
                else if(o.equals(Hand.SCISSORS)) ret = Hand.ROCK;
                break;
            case ROCK:
                if(o.equals(Hand.ROCK)) ret = Hand.SCISSORS;
                else if(o.equals(Hand.PAPER)) ret = Hand.ROCK;
                else if(o.equals(Hand.SCISSORS)) ret = Hand.PAPER;
                break;
            case PAPER: ret = o;

        }
        return ret;

    }

    public Hand getHand(String s) {
        Hand res =  switch (s) {
            case "A","X" -> Hand.ROCK;
            case "B","Y" -> Hand.PAPER;
            case "C","Z" -> Hand.SCISSORS;
            default -> throw new RuntimeException();
        };
        return res;
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
        game.setEstrategia(2);

        while (sc.hasNextLine()) {
            round = sc.nextLine();
            Hand o = game.getHand(String.valueOf(round.charAt(0)));
            Hand e = game.getHand(String.valueOf(round.charAt(2)));
            game.resultats.add(game.round(2,o,e));
            System.out.printf("%s%s ", o.getCode(), e.getCode());
        }
        System.out.printf("%n");
        System.out.printf("Total : " + game.resultatRondes());
    }



    public int jugada(Hand o, Hand e) {
        int sum = 0;
        if(e.getValue() == o.getValue()) sum =  3;
        else if(e.equals(Hand.ROCK) && o.equals(Hand.SCISSORS)) sum = 6;
        else if(e.equals(Hand.ROCK) && o.equals(Hand.PAPER)) sum = 0;
        else if(e.equals(Hand.PAPER) && o.equals(Hand.ROCK)) sum =  6;
        else if(e.equals(Hand.PAPER) && o.equals(Hand.SCISSORS)) sum =  0;
        else if(e.equals(Hand.SCISSORS) && o.equals(Hand.ROCK)) sum = 0;
        else if(e.equals(Hand.SCISSORS) && o.equals(Hand.PAPER)) sum = 6;
        return sum;
    }
}
