package com.company;
import java.io.*;
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
}
