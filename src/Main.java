import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Read input 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name (with .txt): ");
        String filename = sc.nextLine();
        sc.close();
        // Create Puzzle
        Puzzle x = new Puzzle(filename);
        // Output Starting position
        System.out.println("Starting Tiles: ");
        x.printTiles();
        
        // Initialize branch and bound 
        BranchAndBound bnb = new BranchAndBound(x);
        // Solve
        bnb.solve(x);
    }
}
