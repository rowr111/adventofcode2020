package com.company;
import java.io.*;
import java.util.*;
import java.util.List;

public class Day02 {
    public static void Day02Run(){
        try{
            File file = new File("//Users//jeanie.conner//code//adventofcode2020//AdventOfCode2020/Data//input02.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int goodPwds1 = 0;
            int goodPwds2 = 0;
            while((st = br.readLine()) != null){
                //figure out all the particulars from the line, this is a bit fiddly but whatever.
                String[] splitPassword = st.split(":");
                String password = splitPassword[1].trim();
                String[] splitLetter = splitPassword[0].split(" ");
                String letter = splitLetter[1];
                String[] range = splitLetter[0].split("-");
                //part 1
                int[] abc = new int[26]; // array for counting letters
                for(int i=0; i<password.length(); i++) abc[password.charAt(i) - 'a']++;
                int letterCount = abc[letter.charAt(0) - 'a'];
                if(letterCount >= Integer.parseInt(range[0]) && letterCount <= Integer.parseInt(range[1])) goodPwds1++;
                //part 2
                boolean left = password.charAt(Integer.parseInt(range[0])-1) == letter.charAt(0) ? true : false;
                boolean right = password.charAt(Integer.parseInt(range[1])-1) == letter.charAt(0) ? true : false;
                if(right != left) goodPwds2++;
            }
            System.out.println("Good passwords found, part 1: " + goodPwds1);
            System.out.println("Good passwords found, part 2: " + goodPwds2);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
