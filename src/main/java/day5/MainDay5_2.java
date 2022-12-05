package day5;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class MainDay5_2 {

    public static void main(String[] args) {
        List<Stack<String>> crates = new ArrayList<>(9);
        List<String> col1 = new ArrayList<>(Arrays.asList("D", "T", "W", "F", "J", "S", "H", "N"));
        List<String> col2 = new ArrayList<>(Arrays.asList("H", "R", "P", "Q", "T", "N", "B", "G"));
        List<String> col3 = new ArrayList<>(Arrays.asList("L", "Q", "V"));
        List<String> col4 = new ArrayList<>(Arrays.asList("N", "B", "S", "W", "R", "Q"));
        List<String> col5 = new ArrayList<>(Arrays.asList("N", "D", "F", "T", "V", "M", "B"));
        List<String> col6 = new ArrayList<>(Arrays.asList("M", "D", "B", "V", "H", "T", "R"));
        List<String> col7 = new ArrayList<>(Arrays.asList("D", "B", "Q", "J"));
        List<String> col8 = new ArrayList<>(Arrays.asList("D", "N", "J", "V", "R", "Z", "H", "Q"));
        List<String> col9 = new ArrayList<>(Arrays.asList("B", "N", "H", "M", "S"));
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        Stack<String> stack3 = new Stack<>();
        Stack<String> stack4 = new Stack<>();
        Stack<String> stack5 = new Stack<>();
        Stack<String> stack6 = new Stack<>();
        Stack<String> stack7 = new Stack<>();
        Stack<String> stack8 = new Stack<>();
        Stack<String> stack9 = new Stack<>();
        stack1.addAll(col1);
        stack2.addAll(col2);
        stack3.addAll(col3);
        stack4.addAll(col4);
        stack5.addAll(col5);
        stack6.addAll(col6);
        stack7.addAll(col7);
        stack8.addAll(col8);
        stack9.addAll(col9);
        crates.add(stack1);
        crates.add(stack2);
        crates.add(stack3);
        crates.add(stack4);
        crates.add(stack5);
        crates.add(stack6);
        crates.add(stack7);
        crates.add(stack8);
        crates.add(stack9);

        URL input = MainDay5_2.class.getResource("input.txt");
        System.out.println(input);
        File file = new File(input.getFile());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            sc.useDelimiter("move\\s|\\sfrom\\s|\\sto\\s|\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            sc.nextLine();
        }
        String line;
        //move 3 from 1 to 2
        int q,s,d;
        while(sc.hasNext()) {
            q = sc.nextInt();
            s = sc.nextInt();
            d = sc.nextInt();
            if(sc.hasNext()) sc.next();
            System.out.printf("%d %d %d%n", q,s,d);
            Stack<String> temp = new Stack<>();
            for (int i = 0; i < q; i++) {
                temp.push(crates.get(s-1).pop());
            }
            for (int i = 0; i < q; i++) {
                crates.get(d-1).push(temp.pop());
            }
            temp.clear();
        }

        /**
         * [N] [G]                     [Q]
         * [H] [B]         [B] [R]     [H]
         * [S] [N]     [Q] [M] [T]     [Z]
         * [J] [T]     [R] [V] [H]     [R] [S]
         * [F] [Q]     [W] [T] [V] [J] [V] [M]
         * [W] [P] [V] [S] [F] [B] [Q] [J] [H]
         * [T] [R] [Q] [B] [D] [D] [B] [N] [N]
         * [D] [H] [L] [N] [N] [M] [D] [D] [B]
         *  1   2   3   4   5   6   7   8   9
         */



        crates.forEach(stack -> System.out.printf("%s",stack.peek()));

    }
}
