package com.github.mackatozis.day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class SolutionDay03 {

    public static void main(String[] args) throws Exception {
        File file = new File("src/main/resources/day03_input.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> lines = reader.lines().toList();

            System.out.println("part1:" + resolvePart1(lines));
            System.out.println("part2:" + resolvePart2(lines));
        }
    }

    private static int resolvePart1(List<String> lines) {
        String line;
        int middle;
        String compartment1;
        String compartment2;
        int sum = 0;

        for (int i = 0; i < lines.size(); i++) {
            line = lines.get(i);
            middle = line.length() / 2;
            compartment1 = line.substring(0, middle);
            compartment2 = line.substring(middle);

            for (int j = 0; j < compartment1.length(); j++) {
                if (isOmnipresent(compartment1, compartment2, j)) {
                    sum += resolvePriority(compartment1.charAt(j));
                    break;
                }
            }
        }
        return sum;
    }

    private static boolean isOmnipresent(String compartment1, String compartment2, int i) {
        return compartment2.contains(Character.toString(compartment1.charAt(i)));
    }

    private static int resolvePriority(char c) {
        int priority = c;

        if (Character.isUpperCase(c)) {
            priority -= 38;
        } else {
            priority -= 96;
        }
        return priority;
    }

    private static int resolvePart2(List<String> lines) {
        String rucksack1;
        String rucksack2;
        String rucksack3;
        int sum = 0;

        for (int i = 0; i < lines.size(); i += 3) {
            rucksack1 = lines.get(i);
            rucksack2 = lines.get(i + 1);
            rucksack3 = lines.get(i + 2);

            for (int j = 0; j < rucksack1.length(); j++) {
                if (isOmnipresent(rucksack1, rucksack2, rucksack3, j)) {
                    sum += resolvePriority(rucksack1.charAt(j));
                    break;
                }
            }
        }
        return sum;
    }

    private static boolean isOmnipresent(String rucksack1, String rucksack2, String rucksack3, int j) {
        return rucksack2.contains(Character.toString(rucksack1.charAt(j))) && rucksack3.contains(Character.toString(rucksack1.charAt(j)));
    }

}
