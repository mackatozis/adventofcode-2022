package com.github.mackatozis.day01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionDay01 {

    public static void main(String[] args) throws Exception {
        File file = new File("src/main/resources/day01_input.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String calories;
            int totalCalories = 0;
            List<Integer> elvesCalories = new ArrayList<>();

            while ((calories = reader.readLine()) != null) {
                if (calories.isEmpty()) {
                    elvesCalories.add(totalCalories);
                    totalCalories = 0;
                } else {
                    totalCalories += Integer.parseInt(calories);
                }
            }

            System.out.println("part1:" + Collections.max(elvesCalories));
            System.out.println("part2:" + elvesCalories.stream()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .reduce(0, Integer::sum));
        }
    }

}
