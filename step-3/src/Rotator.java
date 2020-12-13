package src;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rotator {
    Pusher pusher = new Pusher();
    //cmd: u
    public void turnTopSide(String cmd, Side side1, Side side2, Side side3, Side side4) {
        pusher.insertBlock(side1.getTopLine());
        pusher.insertBlock(side2.getTopLine());
        pusher.insertBlock(side3.getTopLine());
        pusher.insertBlock(side4.getTopLine());

        pusher.pushBlock(1,cmd);

        side1.setTopLine(pusher.getBlockDeque().remove());
        side2.setTopLine(pusher.getBlockDeque().remove());
        side3.setTopLine(pusher.getBlockDeque().remove());
        side4.setTopLine(pusher.getBlockDeque().remove());
    }

    //cmd: D
    //direction,leftside,frontside,rightside,backside
    public void turnBottomSide(String cmd, Side side1, Side side2, Side side3, Side side4) {
        pusher.insertBlock2(side1.getBottomLine(),side2.getBottomLine(),
                side3.getBottomLine(),side4.getBottomLine());

        pusher.pushBlock(1,cmd);

        side1.setBottomLine(pusher.getBlocks());
        side2.setBottomLine(pusher.getBlocks());
        side3.setBottomLine(pusher.getBlocks());
        side4.setBottomLine(pusher.getBlocks());

    }

    //cmd: F
    //direction,topside,rightside,bottomside,leftside
    public void turnFrontSide(String cmd, Side side1, Side side2, Side side3, Side side4) {
        pusher.insertBlock2(side1.getBottomLine(),reverse(side2.getLeftLine()),
                side3.getTopLine(),reverse(side4.getRightLine()));

        pusher.pushBlock(1,cmd);

        side1.setBottomLine(pusher.getBlockDeque().remove());
        side2.setLeftLine(pusher.getBlockDeque().remove());
        side3.setTopLine(pusher.getBlockDeque().remove());
        side4.setRightLine(pusher.getBlockDeque().remove());

    }

    //cmd: B
    //direction,topside,rightside,bottomside,leftside
    public void turnBackSide(String cmd, Side side1, Side side2, Side side3, Side side4) {
        pusher.insertBlock(reverse(side1.getTopLine()));
        pusher.insertBlock(side2.getRightLine());
        pusher.insertBlock(reverse(side3.getBottomLine()));
        pusher.insertBlock(side4.getLeftLine());

        pusher.pushBlock(1,cmd);

        side1.setTopLine(pusher.getBlockDeque().remove());
        side2.setRightLine(pusher.getBlockDeque().remove());
        side3.setBottomLine(pusher.getBlockDeque().remove());
        side4.setLeftLine(pusher.getBlockDeque().remove());
    }

    //cmd: R
    //direction,topside,backside,bottomside,frontside
    public void turnRightSide(String cmd, Side side1, Side side2, Side side3, Side side4) {
        pusher.insertBlock(reverse(side1.getRightLine()));
        pusher.insertBlock(reverse(side2.getLeftLine()));
        pusher.insertBlock(side3.getRightLine());
        pusher.insertBlock(side4.getRightLine());

        pusher.pushBlock(1,cmd);

        side1.setRightLine(pusher.getBlockDeque().remove());
        side2.setLeftLine(pusher.getBlockDeque().remove());
        side3.setRightLine(pusher.getBlockDeque().remove());
        side4.setRightLine(pusher.getBlockDeque().remove());
    }

    //cmd: L
    //direction,toptside,backside,bottomside,frontside
    public void turnLeftSide(String cmd, Side side1, Side side2, Side side3, Side side4) {
        pusher.insertBlock(side1.getLeftLine());
        pusher.insertBlock(reverse(side2.getRightLine()));
        pusher.insertBlock(reverse(side3.getLeftLine()));
        pusher.insertBlock(side4.getLeftLine());

        pusher.pushBlock(1,cmd);

        side1.setLeftLine(pusher.getBlockDeque().remove());
        side2.setRightLine(pusher.getBlockDeque().remove());
        side3.setLeftLine(pusher.getBlockDeque().remove());
        side4.setLeftLine(pusher.getBlockDeque().remove());
    }

    //해당 면 돌리기
    public void turnBaseSide(String cmd,Side side){ //right(f,r,u,b,l,d)
        pusher.insertBlock2(side.getTopLine(),reverse(side.getRightLine()),
                side.getBottomLine(),reverse(side.getLeftLine()));

        pusher.pushBlock(1,cmd);

        side.setTopLine(pusher.getBlocks());
        side.setRightLine(pusher.getBlocks());
        side.setBottomLine(pusher.getBlocks());
        side.setLeftLine(pusher.getBlocks());

    }

    //배열 뒤집기
    private Block[] reverse(Block[] blocks){
        List<Block> blockList = Arrays.asList(blocks);
        Collections.reverse(blockList);
        Block[] result = blockList.toArray(new Block[0]);

        return result;

    }


}
