package src;

import java.util.Arrays;

public class Side {
    private final Block[][] side;
    private final int size;
    private final String color;

    public Side(int size, String color){
        this.side = new Block[size][size];
        this.size = size;
        this.color = color;

        initSide();
    }

    //같은 색의 블록으로 채우기
    private void initSide(){
        for(Block[] line: side){
            Arrays.fill(line,new Block(color));
        }

    }

    public Block[] getTopLine(){
        Block[] topLine = new Block[size];
        for(int i = 0; i < size; i++) {
            topLine[i] = side[0][i];
        }
        return topLine;
    }

    public Block[] getBottomLine(){
        Block[] bottomLine = new Block[size];
        for(int i = 0; i < size; i++) {
            bottomLine[i] = side[2][i];
        }
        return bottomLine;
    }

    public Block[] getRightLine(){
        Block[] rightLine = new Block[size];
        for(int i = 0; i < size; i++){
            rightLine[i] = side[i][size-1];
        }

        return rightLine;
    }

    public Block[] getLeftLine(){
        Block[] leftLine = new Block[size];
        for(int i = 0; i < size; i++){
            leftLine[i] = side[i][0];
        }

        return leftLine;
    }

    public void setTopLine(Block[] blocks){
        if (size >= 0) {
            System.arraycopy(blocks, 0, side[0], 0, size);
        }
    }

    public void setBottomLine(Block[] blocks){
        if (size >= 0) {
            System.arraycopy(blocks, 0, side[2], 0, size);
        }
    }

    public void setRightLine(Block[] blocks){
        for(int i = 0; i < size; i++){
            side[i][size-1] = blocks[i];
        }

    }

    public void setLeftLine(Block[] blocks){
        for(int i = 0; i < size; i++){
            side[i][0] = blocks[i];
        }

    }

    //루빅스큐브출력
    //큐브 위 아랫면 출력
    public void printTopOrBottom(){
        for(Block[] line:side){
            System.out.print("\t\t\t");
            for(Block block:line){
                System.out.print(block.getColor() + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    // 큐브 한 면의 라인 출력
    public void printLine(int index) {
        for(int i = 0; i < this.size; i++){
            System.out.printf("%s ", side[index][i].getColor());
        }
        System.out.print("\t");
    }
}
