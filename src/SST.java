import java.util.List;
import java.util.ArrayList;
public class SST {
    public Puzzle root;
    public SST parent;
    public String move;
    public int depth;
    public SST(Puzzle root){
        this.root = root;
        this.move = "";
        this.depth = 0;
    }
    public SST(Puzzle root, SST parent, String move, int depth){
        this.root = root;
        this.parent = parent;
        this.move = move;
        this.depth = depth;
    }
    public SST(SST x){
        this.root = x.root;
        this.parent = x.parent;
        this.move = x.move;
        this.depth = x.depth;

    }
    public boolean isRepetitive(String dir){
        if (this.move.equals("up")){
            return (dir.equals("down"));
        } else if (this.move.equals("down")){
            return (dir.equals("up"));
        } else if (this.move.equals("right")){
            return (dir.equals("left"));
        } else if (this.move.equals("left")){
            return (dir.equals("right"));
        } else {
            return false;
        }
    }
    public List<SST> getPath(){
        List<SST> solution = new ArrayList<SST>();
        SST parent = this.parent;
        SST child = this;
        while (parent != null){
            solution.add(0, child);
            child = parent;
            parent = parent.parent;
        }
        return solution;
    }
    public int getCost(){
        return (BranchAndBound.misplaced(this.root) + this.depth);
    }
}
