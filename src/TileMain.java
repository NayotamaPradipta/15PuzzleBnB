public class TileMain {
    // Buat testing Tile Class beserta EmptyTile & OccupiedTile
    public static void main(String[] args) {
        int k = 1;
        Tile[][] grid = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j == 3){
                    grid[i][j] = new EmptyTile();
                } else {
                    grid[i][j] = new OccupiedTile(k);
                    k++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j].getNum());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
