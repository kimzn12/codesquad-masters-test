package src;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rotator {
    private final int size = 3;
    Pusher pusher = new Pusher();

    //cmd: u
    public void turnTopSide(String cmd, Block[][] side1, Block[][] side2, Block[][] side3, Block[][] side4) {

        pusher.insertBlock(getTopLine(side1),getTopLine(side2),getTopLine(side3),getTopLine(side4));
        pusher.pushBlock(1,cmd);

        setTopLine(pusher.getBlockDeque().remove(),side1);
        setTopLine(pusher.getBlockDeque().remove(),side2);
        setTopLine(pusher.getBlockDeque().remove(),side3);
        setTopLine(pusher.getBlockDeque().remove(),side4);

    }

    //cmd: D
    //direction,leftside,frontside,rightside,backside
    public void turnBottomSide(String cmd, Block[][] side1, Block[][] side2, Block[][] side3, Block[][] side4) {

        pusher.insertBlock(getBottomLine(side1),getBottomLine(side2),getBottomLine(side3),getBottomLine(side4));
        pusher.pushBlock(1,cmd);

        setBottomLine(pusher.getBlocks(),side1);
        setBottomLine(pusher.getBlocks(),side2);
        setBottomLine(pusher.getBlocks(),side3);
        setBottomLine(pusher.getBlocks(),side4);

    }

    //cmd: F
    //direction,topside,rightside,bottomside,leftside
    public void turnFrontSide(String cmd, Block[][] side1, Block[][] side2, Block[][] side3, Block[][] side4) {
        if(cmd.equalsIgnoreCase("R")){
            pusher.insertBlock(getBottomLine(side1),reverse(getLeftLine(side2)),
                    getTopLine(side3),reverse(getRightLine(side4)));

        } else if(cmd.equalsIgnoreCase("L")){
            pusher.insertBlock(reverse(getBottomLine(side1)),getLeftLine(side2),
                    reverse(getTopLine(side3)),getRightLine(side4));
        }


        pusher.pushBlock(1,cmd);

        setBottomLine(pusher.getBlockDeque().remove(),side1);
        setLeftLine(pusher.getBlockDeque().remove(),side2);
        setTopLine(pusher.getBlockDeque().remove(),side3);
        setRightLine(pusher.getBlockDeque().remove(),side4);

    }

    //cmd: B
    //direction,topside,rightside,bottomside,leftside
    public void turnBackSide(String cmd, Block[][] side1, Block[][] side2, Block[][] side3, Block[][] side4) {
        if(cmd.equalsIgnoreCase("R")){
            pusher.insertBlock(getTopLine(side1),reverse(getRightLine(side2)),
                    getBottomLine(side3),reverse(getLeftLine(side4)));
        } else if(cmd.equalsIgnoreCase("L")){
            pusher.insertBlock(reverse(getTopLine(side1)),getRightLine(side2),
                    reverse(getBottomLine(side3)),getLeftLine(side4));
        }

        pusher.pushBlock(1,cmd);

        setTopLine(pusher.getBlockDeque().remove(),side1);
        setRightLine(pusher.getBlockDeque().remove(),side2);
        setBottomLine(pusher.getBlockDeque().remove(),side3);
        setLeftLine(pusher.getBlockDeque().remove(),side4);
    }

    //cmd: R
    //direction,toptside,backside,bottomside,frontside
    public void turnRightSide(String cmd, Block[][] side1, Block[][] side2, Block[][] side3, Block[][] side4) {
        if(cmd.equalsIgnoreCase("R")){
            pusher.insertBlock(reverse(getRightLine(side1)),reverse(getLeftLine(side2)),
                    getRightLine(side3),getRightLine(side4));

        } else if(cmd.equalsIgnoreCase("L")){
            pusher.insertBlock(getRightLine(side1),reverse(getLeftLine(side2)),
                    reverse(getRightLine(side3)),getRightLine(side4));
        }

        pusher.pushBlock(1,cmd);

        setRightLine(pusher.getBlockDeque().remove(),side1);
        setLeftLine(pusher.getBlockDeque().remove(),side2);
        setRightLine(pusher.getBlockDeque().remove(),side3);
        setRightLine(pusher.getBlockDeque().remove(),side4);
    }

    //cmd: L
    //direction,toptside,backside,bottomside,frontside
    public void turnLeftSide(String cmd, Block[][] side1, Block[][] side2, Block[][] side3, Block[][] side4) {
        if(cmd.equalsIgnoreCase("R")){ //l'
            pusher.insertBlock(reverse(getLeftLine(side1)),reverse(getRightLine(side2)),
                    getLeftLine(side3),getLeftLine(side4));


        } else if(cmd.equalsIgnoreCase("L")){
            pusher.insertBlock(getLeftLine(side1),reverse(getRightLine(side2)),
                    reverse(getLeftLine(side3)),getLeftLine(side4));
        }

        pusher.pushBlock(1,cmd);

        setLeftLine(pusher.getBlockDeque().remove(),side1);
        setRightLine(pusher.getBlockDeque().remove(),side2);
        setLeftLine(pusher.getBlockDeque().remove(),side3);
        setLeftLine(pusher.getBlockDeque().remove(),side4);
    }


    //해당 면 돌리기
    public void turnBaseSide(String cmd,Block[][] side){
        if(cmd.equalsIgnoreCase("R")){
            pusher.insertBlock(getTopLine(side),reverse(getRightLine(side)),
                    getBottomLine(side),reverse(getLeftLine(side)));
        } else if(cmd.equalsIgnoreCase("L")){
            pusher.insertBlock(reverse(getTopLine(side)),getRightLine(side),
                    reverse(getBottomLine(side)),getLeftLine(side));
        }


        pusher.pushBlock(1,cmd);

        setTopLine(pusher.getBlocks(),side);
        setRightLine(pusher.getBlocks(),side);
        setBottomLine(pusher.getBlocks(),side);
        setLeftLine(pusher.getBlocks(),side);

    }

    //배열 뒤집기
    private Block[] reverse(Block[] blocks){
        List<Block> blockList = Arrays.asList(blocks);
        Collections.reverse(blockList);

        return blockList.toArray(new Block[0]);

    }

    ///////////////////////////////////////////////////



    public int getSize(){
        return this.size;
    }

    public Block[] getTopLine(Block[][] side){
        Block[] topLine = new Block[size];
        System.arraycopy(side[0], 0, topLine, 0, size);
        return topLine;
    }

    public Block[] getBottomLine(Block[][] side){
        Block[] bottomLine = new Block[size];
        System.arraycopy(side[2], 0, bottomLine, 0, size);
        return bottomLine;
    }

    public Block[] getRightLine(Block[][] side){
        Block[] rightLine = new Block[size];
        for(int i = 0; i < size; i++){
            rightLine[i] = side[i][size-1];
        }

        return rightLine;
    }

    public Block[] getLeftLine(Block[][] side){
        Block[] leftLine = new Block[size];
        for(int i = 0; i < size; i++){
            leftLine[i] = side[i][0];
        }

        return leftLine;
    }

    public void setTopLine(Block[] blocks,Block[][] side){
        System.arraycopy(blocks, 0, side[0], 0, size);
    }

    public void setBottomLine(Block[] blocks,Block[][] side){
        System.arraycopy(blocks, 0, side[2], 0, size);
    }

    public void setRightLine(Block[] blocks,Block[][] side){
        for(int i = 0; i < size; i++){
            side[i][size-1] = blocks[i];
        }

    }

    public void setLeftLine(Block[] blocks,Block[][] side){
        for(int i = 0; i < size; i++){
            side[i][0] = blocks[i];
        }

    }


}
