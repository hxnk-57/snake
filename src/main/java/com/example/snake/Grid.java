package com.example.snake;

public class Grid {

    private static final Integer SIZE = 11;
    private Entities[][] grid;
    private int player_row = SIZE/2;
    private int player_column = SIZE/2;
    
    public Grid() {

        this.grid = new Entities[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {   
			for (int column = 0; column < SIZE; column++) {
                this.grid[row][column] = Entities.EMPTY;
			}
		}
        this.grid[player_row][player_column] = Entities.PLAYER;
    }

    public void display() {
        for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				System.out.print(grid[row][column] + " ");
			}
			System.out.println();
		}
    }

    public void move(Moves move) {
        switch(move) {
            case UP:
              if (validMove(player_row - 1)) {
                this.grid[player_row][player_column] = Entities.EMPTY;
                this.player_row = this.player_row - 1;
                this.grid[player_row][player_column] = Entities.PLAYER;  
              }
              break;

            case DOWN:
              if (validMove(player_row + 1)) {
                this.grid[player_row][player_column] = Entities.EMPTY;
                this.player_row = this.player_row + 1;
                this.grid[player_row][player_column] = Entities.PLAYER;  
              }
              break;

            case RIGHT:
              if (validMove(player_column + 1)) {
                this.grid[player_row][player_column] = Entities.EMPTY;
                this.player_column = this.player_column + 1;
                this.grid[player_row][player_column] = Entities.PLAYER;  
              }            
              break;

            case LEFT:
              if (validMove(player_column - 1)) {
                this.grid[player_row][player_column] = Entities.EMPTY;
                this.player_column = this.player_column - 1;
                this.grid[player_row][player_column] = Entities.PLAYER;  
              }            
              break;

            default:
              break;
          }
    }

    private boolean validMove(int x) {
        return (x >= 0 && x < SIZE);
    }

}