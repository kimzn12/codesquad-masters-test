package src;


import java.util.Arrays;

public class Side {
    private final Block[][] side;
    private final int size;
    private final String color;

    public Block[] topLine;
    private Block[] leftLine;
    private Block[] bottomLine;
    private Block[] rightLine;

    public Side(int size, String color){
        this.side = new Block[size][size];
        this.size = size;
        this.color = color;

        this.topLine = side[0];

        initSide();
    }

    //같은 색의 블록으로 채우기
    private void initSide(){
        for(Block[] line: side){
            Arrays.fill(line,new Block(color));
        }
    }

    public Block[] getTopLine(){
        return this.topLine;
    }

    public Block[] getBottomLine(){
        this.bottomLine = side[size-1];
        return bottomLine;
    }

    public Block[] getRightLine(){
        this.rightLine = new Block[size];
        for(int i = 0; i < size; i++){
            this.rightLine[i] = side[i][size-1];
        }

        return this.rightLine;
    }

    public Block[] getLeftLine(){
        this.leftLine = new Block[size];
        for(int i = 0; i < size; i++){
            this.leftLine[i] = side[i][0];
        }

        return this.leftLine;
    }

    public void setTopLine(Block[] blocks){
        for(Block block: blocks){
            Arrays.fill(this.topLine,block);
        }
    }

    public void setBottomLine(Block[] blocks){
        for(Block block: blocks){
            Arrays.fill(this.bottomLine,block);
        }
    }

    public void setRightLine(Block[] blocks){
        for(Block block: blocks){
            Arrays.fill(this.rightLine,block);
        }
    }

    public void setLeftLine(Block[] blocks){
        for(Block block: blocks){
            Arrays.fill(this.leftLine,block);
        }
    }

    //큐브 한 면 출력
    public  void printSide(){
        for (Block[] line : side) {
            for (Block block: line) {
                System.out.print(block.getColor() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //루빅스큐브출력
    //큐브 위 아랫면 출력
    public void printToporBottom(){
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
