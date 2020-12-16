package src;

import java.util.Arrays;

public class RubiksCube {
    private Block[][][] cube;

    private static final int CUBE_SIZE = 3;
    private static final int NUMBER_OF_SIDE = 6;

    private final Rotator rotator;

    private Block[][] frontSide;
    private Block[][] backSide;
    private Block[][] rightSide;
    private Block[][] leftSide;
    private Block[][] topSide;
    private Block[][] bottomSide;

    public RubiksCube(){
        rotator = new Rotator();

        initCube();
        initSides();
    }

    public void shuffle(int num){
        Shuffler.shuffle(cube,num);
    }

    public void print(){
        Printer.printRubiksCube(cube);
    }

    public Boolean finish(){
       return Terminator.checkFinish(cube);
    }

    private void initCube() {
        cube = new Block[NUMBER_OF_SIDE][CUBE_SIZE][CUBE_SIZE];
    }

    private void initSides() {
        topSide = cube[0];
        leftSide = cube[1];
        frontSide = cube[2];
        rightSide = cube[3];
        backSide = cube[4];
        bottomSide = cube[5];

        fillColor(topSide, BlockColor.WHITE.color);
        fillColor(leftSide,BlockColor.PURPLE.color);
        fillColor(frontSide,BlockColor.GREEN.color);
        fillColor(rightSide,BlockColor.RED.color);
        fillColor(backSide,BlockColor.BLUE.color);
        fillColor(bottomSide,BlockColor.YELLOW.color);
    }

    //한 면을 같은 색의 블록으로 채우기
    private void fillColor(Block[][] side,String color){
        for(Block[] line: side){
            Arrays.fill(line,new Block(color));
        }
    }

    public void rubiksCubeProcess(Command command) {
        switch (command){
            case UP:
                rotator.turnBaseSide(Direction.RIGHT,topSide);
                rotator.turnTopSide(Direction.LEFT,leftSide,frontSide,rightSide,backSide);
                break;
            case DOWN:
                rotator.turnBaseSide(Direction.RIGHT,bottomSide);
                rotator.turnBottomSide(Direction.RIGHT,leftSide,frontSide,rightSide,backSide);
                break;
            case RIGHT:
                rotator.turnBaseSide(Direction.RIGHT,rightSide);
                rotator.turnRightSide(Direction.RIGHT,topSide,backSide,bottomSide,frontSide);
                break;
            case LEFT:
                rotator.turnBaseSide(Direction.RIGHT,leftSide);
                rotator.turnLeftSide(Direction.LEFT,topSide,backSide,bottomSide,frontSide);
                break;
            case FRONT:
                rotator.turnBaseSide(Direction.RIGHT,frontSide);
                rotator.turnFrontSide(Direction.RIGHT,topSide,rightSide,bottomSide,leftSide);
                break;
            case BACK:
                rotator.turnBaseSide(Direction.RIGHT,backSide);
                rotator.turnBackSide(Direction.LEFT,topSide,rightSide,bottomSide,leftSide);
                break;

            //반대로 돌기
            case UP_REVERSE:
                rotator.turnBaseSide(Direction.LEFT,topSide);
                rotator.turnTopSide(Direction.RIGHT,leftSide,frontSide,rightSide,backSide);
                break;
            case DOWN_REVERSE:
                rotator.turnBaseSide(Direction.LEFT,bottomSide);
                rotator.turnBottomSide(Direction.LEFT,leftSide,frontSide,rightSide,backSide);
                break;
            case RIGHT_REVERSE:
                rotator.turnBaseSide(Direction.LEFT,rightSide);
                rotator.turnRightSide(Direction.LEFT,topSide,backSide,bottomSide,frontSide);
                break;
            case LEFT_REVERSE:
                rotator.turnBaseSide(Direction.LEFT,leftSide);
                rotator.turnLeftSide(Direction.RIGHT,topSide,backSide,bottomSide,frontSide);
                break;
            case FRONT_REVERSE:
                rotator.turnBaseSide(Direction.LEFT,frontSide);
                rotator.turnFrontSide(Direction.LEFT,topSide,rightSide,bottomSide,leftSide);
                break;
            case BACK_REVERSE:
                rotator.turnBaseSide(Direction.LEFT,backSide);
                rotator.turnBackSide(Direction.RIGHT,topSide,rightSide,bottomSide,leftSide);
        }

    }

}
