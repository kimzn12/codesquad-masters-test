package src;

import java.util.ArrayDeque;
import java.util.Deque;


public class PushingWord {
    private final Deque<String> wordDeque = new ArrayDeque<>();

    public PushingWord(String word, int num, String direction) {
        stringToDeque(word);
        decideDirection(num, direction);
        //printWord();
    }


    //단어 덱에 집어 넣기
    public void stringToDeque(String str) {
        for (int i = 0; i < str.length(); i++) {
            wordDeque.add(Character.toString(str.charAt(i))); // 한 글자씩 덱에 담기
        }
    }

    //방향 결정하기
    private void decideDirection(int num, String direction) {
        //왼쪽 이동 ( "L"+ 양수, "R" + 음수)
        if ((direction.equalsIgnoreCase("L") && isPositive(num))
                || (direction.equalsIgnoreCase("R") && (!isPositive(num)))) {
            moveLeft(num);
        } else if ((direction.equalsIgnoreCase("R") && isPositive(num))
                || (direction.equalsIgnoreCase("L") && (!isPositive(num)))) { //오른쪽쪽 이동 ( "R"+ 양수, "L" + 음수)
            moveRight(num);
        } else {
            System.out.println("방향을 다시 입력하세요.");
        }
    }


    //양수, 음수 확인
    private boolean isPositive(int num) {
        return (num >= 0);
    }

    //왼쪽 이동 함수
    private void moveLeft(int num) {
        num = Math.abs(num);
        String letter;
        for (int i = 0; i < num; i++) {
            letter = wordDeque.removeFirst();
            wordDeque.addLast(letter);
        }
    }

    //오른쪽 이동 함수
    private void moveRight(int num) {
        num = Math.abs(num);
        String letter;
        for (int i = 0; i < num; i++) {
            letter = wordDeque.removeLast();
            wordDeque.addFirst(letter);
        }
    }


    //정답 리턴
    public String printWord() {
        StringBuilder result = new StringBuilder();
        while (!(wordDeque.isEmpty())) result.append(wordDeque.removeFirst());
        return result.toString();
    }

}
