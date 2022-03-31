import java.io.FileNotFoundException;

public class Test {
    // Buat testing Tile Class beserta EmptyTile & OccupiedTile
    public static void main(String[] args) throws FileNotFoundException {
        Puzzle x = new Puzzle("Unreachable1.txt");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x.getTile(i, j).getNum() != 16) {
                    System.out.print(x.getTile(i, j).getNum());
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
        BranchAndBound bab = new BranchAndBound(x);
        System.out.println(bab.getCondition());
        System.out.println(x.getBlankPosition());
        System.out.println(x.getTile(0, 0).getNum());
        x.up();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x.getTile(i, j).getNum() != 16) {
                    System.out.print(x.getTile(i, j).getNum());
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
        x.down();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x.getTile(i, j).getNum() != 16) {
                    System.out.print(x.getTile(i, j).getNum());
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
        x.down();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x.getTile(i, j).getNum() != 16) {
                    System.out.print(x.getTile(i, j).getNum());
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
        System.out.println();
        x.right();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x.getTile(i, j).getNum() != 16) {
                    System.out.print(x.getTile(i, j).getNum());
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
        System.out.println();
        x.right();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x.getTile(i, j).getNum() != 16) {
                    System.out.print(x.getTile(i, j).getNum());
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
        System.out.println();
        x.right();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x.getTile(i, j).getNum() != 16) {
                    System.out.print(x.getTile(i, j).getNum());
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
        System.out.println();
        x.right();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x.getTile(i, j).getNum() != 16) {
                    System.out.print(x.getTile(i, j).getNum());
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
        System.out.println();
        x.left();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x.getTile(i, j).getNum() != 16) {
                    System.out.print(x.getTile(i, j).getNum());
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
        System.out.println();
        x.left();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x.getTile(i, j).getNum() != 16) {
                    System.out.print(x.getTile(i, j).getNum());
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
        System.out.println();
        x.left();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x.getTile(i, j).getNum() != 16) {
                    System.out.print(x.getTile(i, j).getNum());
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
    }
}
