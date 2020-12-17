package com.company;

import java.util.List;

public class Day06 {
    public static void Day06Run() {
        try {
            String pathname = "//Users//jeanie.conner//code//adventofcode2020//AdventOfCode2020/Data//input06.txt";
            List<String> inputs = DataHelpers.returnListOfStrings(pathname);
            int[] totals = new int[26];
            int[] groupCount = new int[26];
            int groupPeeps = 0;
            int finalTotal = 0;
            for(int i=0; i<=inputs.size(); i++){
                if(i==inputs.size() || inputs.get(i).equals("")) {
                    for(int x=0; x<=25; x++){
                        if(groupCount[x] == groupPeeps) finalTotal++;
                    }
                    groupCount = new int[26];
                    groupPeeps = 0;
                }
                else{
                    String input = inputs.get(i);
                    for(char c : input.toCharArray()) groupCount[c-'a']++;
                    groupPeeps++;
                }
            }
            System.out.println("Total: " + finalTotal);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
