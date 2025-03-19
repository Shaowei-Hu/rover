package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarsRoverApplication {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("The program will be run with this command line: java -jar rover.jar input.txt");
            return;
        }

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            int maxX = scanner.nextInt();
            int maxY = scanner.nextInt();
            Plateau plateau = new Plateau(maxX, maxY);

            List<String> results = new ArrayList<>();

            while (scanner.hasNext()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Direction direction = Direction.valueOf(scanner.next());
                Rover rover = new Rover(x, y, direction, plateau);

                if (scanner.hasNext()) {
                    String commands = scanner.next();
                    rover.processCommands(commands);
                    results.add(rover.reportPosition());
                }
            }

            results.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + args[0]);
        } catch (Exception e) {
            System.err.println("Error processing input: " + e.getMessage());
        }
    }
}
