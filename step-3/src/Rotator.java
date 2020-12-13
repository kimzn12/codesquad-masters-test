package src;

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

    //cmd: F
    //direction,topside,rightside,bottomside,leftside
    public void turnFrontSide(String cmd, Side side1, Side side2, Side side3, Side side4) {
        pusher.insertBlock(side1.getBottomLine());
        pusher.insertBlock(side2.getLeftLine());
        pusher.insertBlock(side3.getTopLine());
        pusher.insertBlock(side4.getRightLine());

        pusher.pushBlock(1,cmd);

        side1.setBottomLine(pusher.getBlockDeque().remove());
        side2.setLeftLine(pusher.getBlockDeque().remove());
        side3.setTopLine(pusher.getBlockDeque().remove());
        side4.setRightLine(pusher.getBlockDeque().remove());
    }

    //cmd: R
    //direction,topside,backside,bottomside,frontside
    public void turnRightSide(String cmd, Side side1, Side side2, Side side3, Side side4) {
        pusher.insertBlock(side1.getRightLine());
        pusher.insertBlock(side2.getLeftLine());
        pusher.insertBlock(side3.getRightLine());
        pusher.insertBlock(side4.getRightLine());

        pusher.pushBlock(1,cmd);

        side1.setRightLine(pusher.getBlockDeque().remove());
        side2.setLeftLine(pusher.getBlockDeque().remove());
        side3.setRightLine(pusher.getBlockDeque().remove());
        side4.setRightLine(pusher.getBlockDeque().remove());
    }

    //cmd: B
    //direction,topside,rightside,bottomside,leftside
    public void turnBackSide(String cmd, Side side1, Side side2, Side side3, Side side4) {
        pusher.insertBlock(side1.getTopLine());
        pusher.insertBlock(side2.getRightLine());
        pusher.insertBlock(side3.getBottomLine());
        pusher.insertBlock(side4.getLeftLine());

        pusher.pushBlock(1,cmd);

        side1.setTopLine(pusher.getBlockDeque().remove());
        side2.setRightLine(pusher.getBlockDeque().remove());
        side3.setBottomLine(pusher.getBlockDeque().remove());
        side4.setLeftLine(pusher.getBlockDeque().remove());
    }

    //cmd: L
    //direction,toptside,backside,bottomside,frontside
    public void turnLeftSide(String cmd, Side side1, Side side2, Side side3, Side side4) {
        pusher.insertBlock(side1.getLeftLine());
        pusher.insertBlock(side2.getRightLine());
        pusher.insertBlock(side3.getLeftLine());
        pusher.insertBlock(side4.getLeftLine());

        pusher.pushBlock(1,cmd);

        side1.setLeftLine(pusher.getBlockDeque().remove());
        side2.setRightLine(pusher.getBlockDeque().remove());
        side3.setLeftLine(pusher.getBlockDeque().remove());
        side4.setLeftLine(pusher.getBlockDeque().remove());
    }

    //cmd: D
    //direction,leftside,frontside,rightside,backside
    public void turnBottomSide(String cmd, Side side1, Side side2, Side side3, Side side4) {
        pusher.insertBlock(side1.getBottomLine());
        pusher.insertBlock(side2.getBottomLine());
        pusher.insertBlock(side3.getBottomLine());
        pusher.insertBlock(side4.getBottomLine());

        pusher.pushBlock(1,cmd);

        side1.setBottomLine(pusher.getBlockDeque().remove());
        side2.setBottomLine(pusher.getBlockDeque().remove());
        side3.setBottomLine(pusher.getBlockDeque().remove());
        side4.setBottomLine(pusher.getBlockDeque().remove());
    }



}
