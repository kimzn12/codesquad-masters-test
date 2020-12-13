package src;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Pusher {
    private final Deque<Block[]> blockDeque = new ArrayDeque<>();

//    public Pusher(Block[] blocks, int num, String direction) {
//        insertBlock(blocks);
//        pushBlock(num,direction);
//        printBlocks();
//    }

    //블록들 덱에 집어 넣기
    public void insertBlock(Block[] blocks) {
        Block[] blocksClone = blocks.clone();
        blockDeque.add(blocksClone);
    }

    //리턴
    public Deque<Block[]> getBlockDeque() {
        return blockDeque;
    }

    public void pushBlock(int num, String direction) {
        if(direction.equalsIgnoreCase("L")){
            moveLeft(num);
        }
        else if(direction.equalsIgnoreCase("R")){
            moveRight(num);
        } else{
            System.out.println("방향을 다시 입력하세요.");
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
