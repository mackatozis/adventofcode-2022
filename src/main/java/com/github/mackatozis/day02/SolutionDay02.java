package com.github.mackatozis.day02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SolutionDay02 {

    private static final String O_ROCK = "A";
    private static final String O_PAPER = "B";
    private static final String O_SCISSORS = "C";

    private static final String M_ROCK = "X";
    private static final String M_PAPER = "Y";
    private static final String M_SCISSORS = "Z";

    public static void main(String[] args) throws Exception {
        File file = new File("src/main/resources/day02_input.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String round;
            String me;
            String opponent;
            int scorePart1 = 0;
            int scorePart2 = 0;

            while ((round = reader.readLine()) != null) {
                String[] moves = round.split(" ");
                opponent = moves[0];
                me = moves[1];

                switch (opponent) {
                    case O_ROCK -> {
                        switch (me) {
                            case M_ROCK -> {
                                scorePart1 += 1 + 3;
                                scorePart2 += 3;
                            }
                            case M_PAPER -> {
                                scorePart1 += 2 + 6;
                                scorePart2 += 1 + 3;
                            }
                            case M_SCISSORS -> {
                                scorePart1 += 3;
                                scorePart2 += 2 + 6;
                            }
                            default -> throw new IllegalStateException("Unexpected value: " + me);
                        }
                    }
                    case O_PAPER -> {
                        switch (me) {
                            case M_ROCK -> {
                                scorePart1 += 1;
                                scorePart2 += 1;
                            }
                            case M_PAPER -> {
                                scorePart1 += 2 + 3;
                                scorePart2 += 2 + 3;
                            }
                            case M_SCISSORS -> {
                                scorePart1 += 3 + 6;
                                scorePart2 += 3 + 6;
                            }
                            default -> throw new IllegalStateException("Unexpected value: " + me);
                        }
                    }
                    case O_SCISSORS -> {
                        switch (me) {
                            case M_ROCK -> {
                                scorePart1 += 1 + 6;
                                scorePart2 += 2;
                            }
                            case M_PAPER -> {
                                scorePart1 += 2;
                                scorePart2 += 3 + 3;
                            }
                            case M_SCISSORS -> {
                                scorePart1 += 3 + 3;
                                scorePart2 += 1 + 6;
                            }
                            default -> throw new IllegalStateException("Unexpected value: " + me);
                        }
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + opponent);
                }

            }

            System.out.println("part1:" + scorePart1);
            System.out.println("part2:" + scorePart2);
        }
    }

}
