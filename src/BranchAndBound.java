public class BranchAndBound {
    private boolean reachable;
    private int X;
    private int condition;
    public BranchAndBound(Puzzle puzzle){
        // Pertama cek apakah goal dapat dicapai menggunakan Teorema pada pdf
        // Ambil nilai X
        if ((puzzle.getRow(puzzle.getBlankPosition()) + puzzle.getCol(puzzle.getBlankPosition())) % 2 == 1){
            X = 1;
        } else {
            X = 0;
        }
        // Hitung total Kurang(i)
        int k = 1;
        while (k <= 16){
            int x = puzzle.getRow(k);
            int y = puzzle.getCol(k);
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    if ((puzzle.getTile(i, j).getNum() > puzzle.getTile(x, y).getNum()) && (puzzle.getTilePosition(i, j) < puzzle.getTilePosition(x, y))){
                        this.condition += 1;
                    }
                }
            }
            k += 1;
        }
        this.condition += this.X;
        if (this.condition % 2 == 0){
            reachable = true;
        } else {
            reachable = false;
        }
    }
    public boolean isReachable(){
        return this.reachable;
    }
    public int getX(){
        return this.X;
    }
    public int getCondition(){
        return this.condition;
    }

}
