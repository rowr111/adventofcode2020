package com.company;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class DataHelpers {

    //assumes each row is the same length, doesn't have to be square
    public static char[][] create2DCharArrayFromFile(String filename) throws Exception {

        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);

        ArrayList<char[]> intermediate = new ArrayList<>();
        int xLength = 0;
        while(in.hasNextLine()){
            char[] oneLine = in.nextLine().trim().toCharArray();
            xLength = oneLine.length;
            intermediate.add(oneLine);
        }
        in.close();

        char[][] matrix = new char[intermediate.size()][xLength];
        for(int y = 0; y<intermediate.size(); y++){
            for(int x = 0; x<xLength; x++){
                char[] tempArray = intermediate.get(y);
                matrix[y][x] = tempArray[x];
            }
        }

        return matrix;
    }

    public static List<HashMap<String, String>> getPassport(String filename) throws Exception{
        List<HashMap<String, String>> passports = new ArrayList<>();
        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);
        HashMap<String, String> passport = new HashMap<>();
        while(in.hasNextLine()){
            String nextLine = in.nextLine().trim();
            if(nextLine == ""){ //we're done with this passport, move along!
                passports.add(passport);
                passport = new HashMap<>();
            }
            else{
                String[] parts = nextLine.split(" ");
                for(String part : parts){
                    String[] addMe = part.split(":");
                    passport.put(addMe[0], addMe[1]);
                }
            }
        }
        in.close();
        passports.add(passport); //add the last passport
        System.out.println(("Passport count: " + passports.size()));
        return passports;
    }
}
