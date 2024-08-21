package com.example.snake;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Grid grid = new Grid();
		boolean running = true;
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object

		while (running) {
			grid.display();
			System.out.println("Enter direction");
			String input = scanner.nextLine();

			switch (input) {
				case "w":
					grid.move(Moves.UP);
					break;			
				case "a":
					grid.move(Moves.LEFT);
					break;
				case "s":
					grid.move(Moves.DOWN);
					break;
				case "d":
					grid.move(Moves.RIGHT);
					break;
				case "exit":
					running = false;
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
			System.out.print("\033\143");
		}
		scanner.close();
	}
}