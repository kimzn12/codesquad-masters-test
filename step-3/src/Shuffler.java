package src;

import java.util.Random;

public class Shuffler {
    public static void shuffle(Block[][][] cube,int num){
        Random rd = new Random();
        int count = 0;

        while(count <= num){
            int x = rd.nextInt(cube.length);
            int y = rd.nextInt(cube[0].length);
            int z = rd.nextInt(cube[0][0].length);

            int i = rd.nextInt(cube.length);
            int j = rd.nextInt(cube[0].length);
            int k = rd.nextInt(cube[0][0].length);

            if((y == 1 && z == 1) || (j == 1 && k == 1)){
                continue;
            }

            Block temp = cube[x][y][z];
            cube[x][y][z] = cube[i][j][k];
            cube[i][j][k] = temp;

            count++;
        }

    }
}
