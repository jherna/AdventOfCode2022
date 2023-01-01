package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class MainDay7 {

    public static void main(String[] args) {
        URL input = MainDay7.class.getResource("input.txt");
        System.out.println(input);
        File file = new File(input.getFile());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        TreeNode<String> root = null;
        //String line = null;
        String[] line;
        while(sc.hasNextLine()) {
            line = sc.nextLine().split(" ");
            if(line[0].equals("$")) {
                if(line[1].equals("cd")) {
                    if(line[2].equals("/")) {
                        root = new TreeNode<>("/",null);
                        System.out.println(root);
                    } else if(line[2].equals("..")) {

                    } else {
                        root.addChild(line[2],null);

                    }

                    //System.out.println(new String(line[0] + line[1]));

                }
            }
        }

    }
}
