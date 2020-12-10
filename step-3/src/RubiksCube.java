package src;

import java.util.Arrays;

public class RubiksCube {
    private static final int CUBE_SIZE = 3;
    String[][] FrontSide;
    String[][] BackSide;
    String[][] RightSide;
    String[][] LeftSide;
    String[][] UpperSide;
    String[][] DownSide;

    public RubiksCube(){
        init();
        printRubiksCube();
    }

    private void init() {
        FrontSide = new String[CUBE_SIZE][CUBE_SIZE];
        BackSide = new String[CUBE_SIZE][CUBE_SIZE];
        RightSide = new String[CUBE_SIZE][CUBE_SIZE];
        LeftSide = new String[CUBE_SIZE][CUBE_SIZE];
        UpperSide = new String[CUBE_SIZE][CUBE_SIZE];
        DownSide = new String[CUBE_SIZE][CUBE_SIZE];

        fillColor(FrontSide,"O"); //Orange
        fillColor(BackSide,"Y"); //Yellow
        fillColor(RightSide,"G"); //Green
        fillColor(LeftSide,"W"); //White
        fillColor(UpperSide,"B"); //Blue
        fillColor(DownSide,"R"); //Red
    }

    private void fillColor(String[][] side, String color) {
        for(String[] s:side) {
            Arrays.fill(s, color);
        }
    }
    private void printUpperOrDown(String[][] side){
        for(String[] s:side){
            System.out.print("     ");
            for(String color:s){
                System.out.print(color + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    private void printSides(){
        for(int i = 0; i < CUBE_SIZE; i++){
            printLine(LeftSide,i);
            printLine(FrontSide,i);
            printLine(RightSide,i);
            printLine(BackSide,i);
            System.out.println();
        }
        System.out.println();
    }

    private void printLine(String[][] side, int index) {
        for(int j = 0; j < CUBE_SIZE; j++){
            System.out.print(side[index][j] + " ");
        }
        System.out.print(" ");
    }

    private void printRubiksCube() {
        printUpperOrDown(UpperSide);
        printSides();
        printUpperOrDown(DownSide);
    }


}
