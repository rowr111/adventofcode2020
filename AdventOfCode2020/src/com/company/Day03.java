package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day03 {
    public static void Day03Run(int right, int down) {
        try {
            String pathname = "//Users//jeanie.conner//code//adventofcode2020//AdventOfCode2020/Data//input03.txt";
            char[][] matrix = DataHelpers.create2DCharArrayFromFile(pathname);
            //System.out.println("Matrix is " + matrix.length + " by " + matrix[0].length);
            int x = 0;
            int y = 0;
            int treeCount = 0;
            while(x < matrix.length){
                if(matrix[x][y]  == '#') treeCount++;
                x = x + down;
                y = (y + right) % matrix[0].length;
            }
            System.out.println("Trees encountered: " + treeCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
