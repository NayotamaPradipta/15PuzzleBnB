import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
public class BranchAndBound {
    private boolean reachable;
    private int X;
    private int condition;
    private SST solution;
    private String[] posmove;
    private int node;
    private List<SST> path;
    public BranchAndBound(Puzzle puzzle){
        posmove = new String[]{"up", "down", "right", "left"};
        // Pertama cek apakah goal dapat dicapai menggunakan Teorema pada pdf
        // Ambil nilai X
        if ((puzzle.getRow(puzzle.getBlankPosition()) + puzzle.getCol(puzzle.getBlankPosition())) % 2 == 1){
            X = 1;
        } else {
            X = 0;
        }
        // Hitung total Kurang(i)
        int k = 1;
        this.condition = 0;
        int ctr[] = new int[16];
        while (k <= 16){
            int x = puzzle.getRow(k);
            int y = puzzle.getCol(k);
            int temp = 0;
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    if ((puzzle.getTile(i, j).getNum() < puzzle.getTile(x, y).getNum()) && (puzzle.getTilePosition(i, j) > puzzle.getTilePosition(x, y))){
                        this.condition += 1;
                        temp +=1;
                    }
                    
                }
            }
            ctr[puzzle.getTile(puzzle.getRow(k), puzzle.getCol(k)).getNum() - 1] = temp;
            
            k += 1;
        }
        for (int i = 0; i < 16; i++){
            System.out.println("Kurang[" + (i+1) + "] : " + ctr[i]);
        }
        System.out.println("Total Kurang[i] : " + this.condition);
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


    public static int misplaced(Puzzle puzzle){
        int ctr = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (puzzle.getTile(i, j).getNum() != puzzle.getTilePosition(i, j) && puzzle.getTile(i, j).getNum() != 16){
                    ctr += 1;
                }
            }
        }
        return ctr;
    }
    // Buat Priority Queue

    public void solve(Puzzle puzzle){
        long startTime = System.nanoTime();
        if (reachable){ 
            // Algoritma Branch & Bound
            SST root = new SST(puzzle);
            PriorityQueue<SST> pqbnb = new PriorityQueue<SST>((m,n) -> m.getCost() - n.getCost());
            
            pqbnb.add(root);
            this.node = 1;
            while (!pqbnb.isEmpty()){
                SST curr = pqbnb.poll();
                if (curr.root.isFinalState()){
                    this.solution = curr;
                    break;
                } else {
                    for (int i = 0; i < 4; i++){
                        if (!curr.isRepetitive(posmove[i])){
                            Puzzle temp = new Puzzle(curr.root);
                            SST child = new SST(temp.moveByString(this.posmove[i]), curr, this.posmove[i], curr.depth + 1);
                            if (child.root.getBlankPosition() != curr.root.getBlankPosition() && child.root != null){
                                this.node += 1;
                                pqbnb.add(child);
                            }
                            
                        }
                    }
                }
            }
            
            this.path = this.solution.getPath();
            System.out.println("Steps taken: " + this.path.size());
        } else {
            System.out.println("Goal Unreachable!");
        }
        long stopTime = System.nanoTime();
        if (reachable){
            showPath();
        }
        System.out.print("Nilai fungsi Sigma Kurang[i] + X: ");
        System.out.println(getCondition());
        System.out.print("Nodes generated: ");
        System.out.println(this.node);
        System.out.println("Execution time: " + ((stopTime - startTime) / 1000000) + " ms");

        
    }
    public void showPath(){
        for (int i = 0; i < this.path.size();i++){
            System.out.println("Step " + (i+1) + ": " + this.path.get(i).move);
            this.path.get(i).root.printTiles();
        }
    }
}
