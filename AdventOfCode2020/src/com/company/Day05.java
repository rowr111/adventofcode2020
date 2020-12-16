package com.company;
import java.util.*;


public class Day05 {
    public static void Day05Run(){
        try {
            String pathname = "//Users//jeanie.conner//code//adventofcode2020//AdventOfCode2020/Data//input05.txt";
            List<String> inputs = DataHelpers.returnListOfStrings(pathname);
            int highest = 0;
            int lowest = Integer.MAX_VALUE;
            int total = 0;
            for(String input: inputs){
                int row = binarySearch(input.substring(0,7), 0, 127, 0);
                int col =  binarySearch(input.substring(7), 0, 7, 0);
                int id = (row*8) + col;
                total += id;
                highest = id > highest ? id : highest;
                lowest = id < lowest ? id : lowest;
            }
            System.out.println("highest: " + highest);
            System.out.println("lowest: " + lowest);
            for(int i=lowest; i<= highest; i++) total -= i;
            System.out.println("my seat: " + total * -1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static int binarySearch(String searchme, int l, int r, int x)
    {
        if( x >= searchme.length()) return l;
        int mid = l + (r - l) / 2;
        if (searchme.charAt(x)  == 'L' || searchme.charAt(x) == 'F')
            return binarySearch(searchme, l, mid - 1, x+1);
        return binarySearch(searchme, mid + 1, r, x+1);
    }
}
