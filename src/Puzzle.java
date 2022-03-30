import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle {
    private Tile[][] tile;
    private int BlankPosition;
    public Puzzle(String filename) {
        readFileToPuzzle(filename);
        int i;
        int j;
        for (i = 0; i < 4; i++){
            for (j = 0; j < 4; j++){
                if (tile[i][j].getNum() == 16){
                    BlankPosition = getTilePosition(i, j);
                }
            }
        }
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
    public int getTilePosition(int i, int j){
        return ((4*i) + j + 1);
    }
    public int getRow(int position){
        if (position < 5){
            return 0;
        } else if (position < 9){
            return 1;
        } else if (position < 13){
            return 2;
        } else {
            return 3;
        }
    }
    public int getCol(int position){
        if (position % 4 == 0){
            return 3;
        } else {
            return (position % 4) - 1;
        }

    }
    public int getBlankPosition(){
        return this.BlankPosition;
    }
}
