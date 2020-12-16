package src;

public class Terminator {
    public static boolean checkFinish(Block[][][] cube) {
        for (Block[][] blocks : cube) {
            for (int j = 0; j < cube[0].length; j++) {
                for (int k = 0; k < cube[0][0].length; k++) {
                    if (!(blocks[j][k].getColor().equals(blocks[1][1].getColor()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
