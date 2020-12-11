package com.company;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("//Users//jeanie.conner//code//adventofcode2020//Day01//input.txt");
            //two sum problem:
            //only reading in as needed
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            HashSet<Integer> h = new HashSet<Integer>();
            while ((st = br.readLine()) != null) {
                Integer i = Integer.parseInt(st);
                if(h.contains(2020-i)){
                    System.out.println("Numbers are: " + i + " and " + (2020-i));
                    System.out.println(i*(2020-i));
                    break;
                }
                else{
                    h.add(i);
                }
            }

            //three sum problem
            //have to read in the whole thing first
            BufferedReader br2 = new BufferedReader(new FileReader(file));
            String st2;
            List<Integer> nums = new ArrayList<Integer>();
            while ((st2 = br2.readLine()) != null) {
                nums.add(Integer.parseInt(st2));
            }
            Collections.sort(nums);
            //now use pointer method
            Set<List<Integer>> res = new HashSet<List<Integer>>();
            for(int i=0; i<nums.size()-2; i++){
                int j=i+1;
                int k=nums.size()-1;
                while(j<k){
                    int sum = nums.get(i) + nums.get(j) + nums.get(k);
                    if(sum == 2020){
                        System.out.println("Found three nums: " + nums.get(i) + " " + nums.get(j) + " " + nums.get(k));
                        System.out.print(nums.get(i)*nums.get(j)*nums.get(k));
                        break;
                    }
                    else if(sum > 2020) k--;
                    else if(sum < 2020) j++;
                }
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
