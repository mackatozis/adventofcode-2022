package com.github.mackatozis.day04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.stream.Stream;

public class SolutionDay04 {

    public static void main(String[] args) throws Exception {
        File file = new File("src/main/resources/day04_input.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String assignmentPair;
            String[] ranges;
            int[] elf1Assignment;
            int[] elf2Assignment;

            int part1Sum = 0;
            int part2Sum = 0;

            while ((assignmentPair = reader.readLine()) != null) {
                ranges = assignmentPair.split(",");
                elf1Assignment = Stream.of(ranges[0].split("-")).mapToInt(Integer::parseInt).toArray();
                elf2Assignment = Stream.of(ranges[1].split("-")).mapToInt(Integer::parseInt).toArray();

                if (fullyContains(elf1Assignment, elf2Assignment)) {
                    part1Sum++;
                }

                if (hasOverlap(elf1Assignment, elf2Assignment)) {
                    part2Sum++;
                }
            }

            System.out.println("part1:" + part1Sum);
            System.out.println("part2:" + part2Sum);
        }
    }

    private static boolean fullyContains(int[] elf1Assignment, int[] elf2Assignment) {
        return elf1Assignment[0] >= elf2Assignment[0] && elf1Assignment[1] <= elf2Assignment[1]
            || elf2Assignment[0] >= elf1Assignment[0] && elf2Assignment[1] <= elf1Assignment[1];
    }

    private static boolean hasOverlap(int[] elf1Assignment, int[] elf2Assignment) {
        return elf1Assignment[0] >= elf2Assignment[0] && elf1Assignment[0] <= elf2Assignment[1]
            || elf2Assignment[0] >= elf1Assignment[0] && elf2Assignment[0] <= elf1Assignment[1];
    }

}
