import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[][] grid = new int[10][10];
        int[] ships = {5, 4, 3, 3, 2};
        String[] letters =  {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        //Crear cuadricula
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                grid[i][j] = -1;
            }
        }

        //Mostrar cuadrícula
        System.out.print("   ");
        for (int i = 1; i <= 10; i++){
            if (i == 9){
                System.out.print(i + " ");
            } else {
                System.out.print(i + "  ");
            }

        }
        System.out.println();
        for (int i = 0; i < grid.length; i++){
            System.out.print(letters[i] + "  ");
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == -1){
                    System.out.print("·" + "  ");
                }
            }
            System.out.println();
        }
        //Programar que el usuario pueda elegir una posicion?

    }
}