import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle {
    private Tile[][] tile;
    public Puzzle(String filename) {
        readFileToPuzzle(filename);
    }

    public Tile getTile(int i , int j){
        return this.tile[i][j];
    }
    public void readFileToPuzzle(String filename){
        try {
            File file = new File("../test/" + filename);
            Scanner input = new Scanner(file);
            tile = new Tile[4][4];
            while (input.hasNextLine()){
                for (int i = 0; i < 4; i++){                    
                    for (int j = 0; j < 4; j++){
                        if (input.hasNextInt()){
                            if (input.nextInt() != 16){
                                tile[i][j] = new OccupiedTile(input.nextInt()); 
                            } else {
                                tile[i][j] = new EmptyTile();
                            }
                        }
                    }
                }
            }

            input.close();
        } catch (FileNotFoundException e){
            System.out.println("File Not Found!");
        }
    }
}
