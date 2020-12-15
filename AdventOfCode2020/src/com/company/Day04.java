package com.company;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04 {
    public static void Day04Run() {
        try {
            String pathname = "//Users//jeanie.conner//code//adventofcode2020//AdventOfCode2020/Data//input04.txt";
            //I'm suspicious so let's dump each passport's data into a hashset
            List<HashMap<String, String>> passports = DataHelpers.getPassport(pathname);
            //check if valid:
            /*
            byr (Birth Year)
            iyr (Issue Year)
            eyr (Expiration Year)
            hgt (Height)
            hcl (Hair Color)
            ecl (Eye Color)
            pid (Passport ID)
            cid (Country ID)
            */
            int validPassports = 0;
            for(HashMap<String, String> passport: passports){
                if(!passport.containsKey("byr") || !passport.containsKey("iyr")||
                        !passport.containsKey("eyr")|| !passport.containsKey("hgt")||
                        !passport.containsKey("hcl")|| !passport.containsKey("ecl")||
                        !passport.containsKey("pid")) continue;
                validPassports++;
            }
            System.out.println("Valid Passports, Criteria 1: " + validPassports);

            //after much effort I feel like this should have been one really long regex or something,
            // I really went about this the wrong way, but whatever..
            validPassports = 0;
            for(HashMap<String, String> passport: passports) {
                if (!passport.containsKey("byr") || !passport.containsKey("iyr") ||
                        !passport.containsKey("eyr") || !passport.containsKey("hgt") ||
                        !passport.containsKey("hcl") || !passport.containsKey("ecl") ||
                        !passport.containsKey("pid")) continue;
                int byr = Integer.parseInt(passport.get("byr"));
                if (byr < 1920 || byr > 2002) {
                    //System.out.println("byr out of bounds: " + byr);
                    continue;
                } //byr (Birth Year) - four digits; at least 1920 and at most 2002.

                int iyr = Integer.parseInt(passport.get("iyr")); //iyr (Issue Year) - four digits; at least 2010 and at most 2020.
                if (iyr < 2010 || iyr > 2020){
                    //System.out.println("iyr out of bounds: " + iyr);
                    continue;
                }

                int eyr = Integer.parseInt(passport.get("eyr")); //eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
                if (eyr < 2020 || eyr > 2030) {
                    //System.out.println("eyr out of bounds: " + eyr);
                    continue;
                }

                String height = passport.get("hgt");
                String heightType = height.substring(height.length()-2);
                if(!(heightType.equals("in") || heightType.equals("cm"))){
                    //System.out.println("height type wrong: " + heightType);
                    continue; //hgt (Height) - a number followed by either cm or in:
                }
                String heightString = height.substring(0, height.length()-2);
                int heightInt = Integer.parseInt(heightString);
                if(heightType.equals("in") && (heightInt < 59 || heightInt > 76)){
                    //System.out.println("height inches wrong: " + heightInt);
                    continue;
                } //If in, the number must be at least 59 and at most 76.
                else if(heightType.equals("cm") && (heightInt < 150 || heightInt > 193)) {
                    //System.out.println("height cm wrong: " + heightInt);
                    continue;
                } //If cm, the number must be at least 150 and at most 193.
                if((passport.get("hcl").charAt(0) != '#') || (passport.get("hcl").length() != 7)){
                    //System.out.println("bad hair color: " + passport.get("hcl"));
                    continue;
                }
                //hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
                String regex = "[a-f0-9]{6}";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(passport.get("hcl").substring(1));
                if(!matcher.matches()) {
                    //System.out.println("bad hair color: " + passport.get("hcl"));
                    continue;
                }
                //ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
                regex = "amb|blu|brn|gry|grn|hzl|oth";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(passport.get("ecl"));
                if(!matcher.matches()) {
                    //System.out.println("bad eye color: " + passport.get("ecl"));
                    continue;
                }
                //pid (Passport ID) - a nine-digit number, including leading zeroes.
                regex = "[0-9]{9}";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(passport.get("pid"));
                if(!matcher.matches()) {
                    //System.out.println("bad passport id: " + passport.get("pid"));
                    continue;
                }

                validPassports++;
            }
            System.out.println("Valid Passports, Criteria 2: " + validPassports);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
