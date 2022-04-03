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
    public void setTile(Object t, int position){
        if (t instanceof Tile){
            this.tile[getRow(position)][getCol(position)] = (Tile) t;
        }
    }

    public boolean isValidMove(String dir){
        if (dir.equals("up")){
            return (getBlankPosition() > 4);
        } else if (dir.equals("down")){
            return (getBlankPosition() < 13);
        } else if (dir.equals("right")){
            return (getBlankPosition() % 4 != 0);
        } else {
            return (getBlankPosition() % 4 != 1);
        }
    }

    public void up(){
        // Temp menyimpan nilai puzzle diatasnya
        if (isValidMove("up")){
            int temp = getTile(getRow(getBlankPosition()) - 1, getCol(getBlankPosition())).getNum();
            OccupiedTile ot = new OccupiedTile(temp);
            EmptyTile et = new EmptyTile();
            setTile(ot, getBlankPosition());
            setTile(et, getBlankPosition() - 4);
            this.BlankPosition = getBlankPosition() - 4;
        }   

    }

    public void down(){
        if (isValidMove("down")){
            int temp = getTile(getRow(getBlankPosition()) + 1, getCol(getBlankPosition())).getNum();
            OccupiedTile ot = new OccupiedTile(temp);
            EmptyTile et = new EmptyTile();
            setTile(ot, getBlankPosition());
            setTile(et, getBlankPosition() + 4);
            this.BlankPosition = getBlankPosition() + 4;
        }

    }
    public void right(){
        if (isValidMove("right")){
            int temp = getTile(getRow(getBlankPosition()), getCol(getBlankPosition() + 1)).getNum();
            OccupiedTile ot = new OccupiedTile(temp);
            EmptyTile et = new EmptyTile();
            setTile(ot, getBlankPosition());
            setTile(et, getBlankPosition() + 1);
            this.BlankPosition = getBlankPosition() + 1;
        }

    }
    public void left(){
        if (isValidMove("left")){
            int temp = getTile(getRow(getBlankPosition()), getCol(getBlankPosition() - 1)).getNum();
            OccupiedTile ot = new OccupiedTile(temp);
            EmptyTile et = new EmptyTile();
            setTile(ot, getBlankPosition());
            setTile(et, getBlankPosition() - 1);
            this.BlankPosition = getBlankPosition() - 1;
        }

    }

    public void printTiles(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (this.tile[i][j].getNum() < 10){
                    System.out.print(this.tile[i][j].getNum() + "  ");
                } else {
                    if (this.tile[i][j].getNum() != 16){
                        System.out.print(this.tile[i][j].getNum() + " ");
                    } else {
                        System.out.print("X  ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
