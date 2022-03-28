public abstract class Tile {
    int x;
    int y;

    public Tile() {
    }

    public abstract int getNum();

    public boolean isEqual(Object t) {
        if (t instanceof Tile) {
            Tile temp = (Tile) t;
            if (temp.getNum() == this.getNum()) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
}
