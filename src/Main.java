import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Read input 
        System.out.println("Choose Input Format: ");
        System.out.println("1. Randomly Generated Puzzle");
        System.out.println("2. Input from File");
        Scanner sc = new Scanner(System.in);
        Integer z;
        do {
            System.out.print("Input Number: ");
            z = sc.nextInt();
            if (z == 1){
                Puzzle x = new Puzzle();
                // Output Starting position
                System.out.println("Starting Tiles: ");
                x.printTiles();
                // Initialize branch and bound 
                BranchAndBound bnb = new BranchAndBound(x);
                // Solve
                bnb.solve(x);
            } else if (z==2) {
                Scanner s = new Scanner(System.in);
                System.out.print("Enter file name (with .txt): ");
                String filename = s.nextLine();
                s.close();
                // Create Puzzle
                Puzzle x = new Puzzle(filename);
                // Output Starting position
                System.out.println("Starting Tiles: ");
                x.printTiles();
                
                // Initialize branch and bound 
                BranchAndBound bnb = new BranchAndBound(x);
                // Solve
                bnb.solve(x);
            } else {
                System.out.println("Invalid Input");
            }
        } while (z != 1 && z != 2);

    }
}
