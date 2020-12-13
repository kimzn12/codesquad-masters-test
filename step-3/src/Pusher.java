package src;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pusher {
    private final Deque<Block[]> blockDeque = new ArrayDeque<>();

    //블록들 덱에 집어 넣기
    public void insertBlock(Block[] blocks) {
        blockDeque.add(blocks.clone());
    }

    //블록들 덱에 집어 넣기
    public void insertBlock2(Block[] blocks1,Block[] blocks2,Block[] blocks3,Block[] blocks4) {
        blockDeque.add(blocks1.clone());
        blockDeque.add(blocks2.clone());
        blockDeque.add(blocks3.clone());
        blockDeque.add(blocks4.clone());
    }

    public void printDeque(){
        while (!(blockDeque.isEmpty())){
            Block[] b = blockDeque.remove();
            for(Block block:b){
                System.out.print(block.getColor());
            }
            System.out.println();
        }
        System.out.println();
    }

    public Block[] getBlocks(){
        return blockDeque.remove();
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
