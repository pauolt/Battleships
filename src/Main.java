import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int grid_size = 10;
        int[][] grid = new int[grid_size][grid_size];
        int[] ship_sizes = {5, 4, 3, 3, 2};


        //Create grid

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                grid[i][j] = -1;
            }
        }
        //
        //Place ships

        for (int i = 0; i < ship_sizes.length; i++){
            int size = ship_sizes[i];
            boolean isPlaced = false;

            while(!isPlaced) {
                int row = random.nextInt(10);
                int col = random.nextInt(10);
                boolean isHorizontal = random.nextBoolean();
                boolean canPlace = true;

                if (isHorizontal) {
                    if (col + size <= 10){
                        for (int j = 0; j < size; j++){
                            if (grid[row][col+j] != -1){
                                canPlace = false;
                                break;
                            }
                        }
                        if (canPlace){
                            for (int j = 0; j < size; j++){
                                grid[row][col+j] = size;
                            }
                            isPlaced = true;
                        }
                    }
                } else {
                    if (row + size <= 10) {
                        for (int j = 0; j < size; j++){
                            if (grid[row+j][col] != -1){
                                canPlace = false;
                                break;
                            }
                        }
                        if (canPlace){
                            for (int j = 0; j < size; j++){
                                grid[row+j][col] = size;
                            }
                            isPlaced = true;
                        }
                    }
                }
            }
        }
        //


        //Print grid 1st time

        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        System.out.print("   ");
        for (int i = 1; i <= 10; i ++){
            if (i != 9){
                System.out.print(i + "  ");
            } else {
                System.out.print(i + " ");
            }

        }
        System.out.println();
        for (int i = 0; i < grid.length; i++){
            System.out.print(letters[i] + "  ");
            for (int j = 0; j < grid[i].length; j++){
                System.out.print("·" + "  ");
            }
            System.out.println();
        }
        //

        for (int i = 0; i < grid.length; i++){
            System.out.print(letters[i] + "  ");
            for (int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }

        //Game


        boolean win = false;
        while(!win){
          String shoot = scanner.nextLine();

          String letter = Character.toString(shoot.charAt(0)).toUpperCase();
          int number = Character.getNumericValue(shoot.charAt(1));
          int pos_x = 0;

          for (int i = 0; i < letters.length; i++){
              if (letters[i].equals(letter)){
                  pos_x = i;
              }
          }

            System.out.print("   ");
            for (int i = 1; i <= 10; i ++){
                if (i != 9){
                    System.out.print(i + "  ");
                } else {
                    System.out.print(i + " ");
                }

            }
            System.out.println();
            for (int i = 0; i < grid.length; i++){
                System.out.print(letters[i] + "  ");
                for (int j = 0; j < grid[i].length; j++){

                    //FALLO AQUI
                    if (i == pos_x && j == number){
                        if (grid[pos_x][number] != -1){
                            System.out.print(grid[pos_x][number] + "  ");
                            grid[i][j] = grid[pos_x][number];
                        }else {
                            System.out.print("~" + "  ");
                        }
                    }else {
                        System.out.print("·" + "  ");
                    }

                }
                System.out.println();
            }


        }
        //

    }
}