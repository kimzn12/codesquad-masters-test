package src;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pusher {
    private final Deque<Block[]> blockDeque = new ArrayDeque<>();

    //블록들 덱에 집어 넣기
    public void insertBlock(Block[] blocks1,Block[] blocks2,Block[] blocks3,Block[] blocks4) {
        blockDeque.add(blocks1.clone());
        blockDeque.add(blocks2.clone());
        blockDeque.add(blocks3.clone());
        blockDeque.add(blocks4.clone());
    }

    public Block[] getBlocks(){
        return blockDeque.remove();
    }

    public void pushBlock(int num, Direction direction) {
        switch (direction){
            case LEFT:
                moveLeft(num);
                break;
            case RIGHT:
                moveRight(num);
                break;
        }
    }

    //왼쪽 이동 함수
    private void moveLeft(int num) {
        for (int i = 0; i < num; i++) {
            Block[] blocks = blockDeque.removeFirst();
            blockDeque.addLast(blocks);
        }
    }

    //오른쪽 이동 함수
    private void moveRight(int num) {
        for (int i = 0; i < num; i++) {
            Block[] blocks = blockDeque.removeLast();
            blockDeque.addFirst(blocks);
        }
    }

}
