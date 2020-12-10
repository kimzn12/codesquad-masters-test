import com.sun.xml.internal.stream.Entity;

import java.util.Scanner;

public class PlaneCube {
    public PlaneCube(String cube[][]){
        printCube(cube);
        run(cube);
    }

    private  String inputLine(){
        //라인 입력받기
        System.out.print("cube> ");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        return line;
    }

    private  void run(String cube[][]){
        while(true){
            //실행
            String line = inputLine();
            switch (line){
                case "U": case "u":
                    StringBuilder word = new StringBuilder();
                    for(int i = 0; i < cube[0].length; i++){
                        word.append(cube[0][i]);

                    }
                    String word2 = word.toString();
                    new PushingWord(word2,1,"L");
                    printCube(cube);

                    break;
                case "R": case "r":
                    StringBuilder wordR = new StringBuilder();
                    for(int i = 0; i < cube.length; i++){
                        wordR.append(cube[i][2]);

                    }
                    String wordR2 = wordR.toString();
                    new PushingWord(wordR2,1,"L");
                    break;
                case "L": case "l":
                    StringBuilder wordL = new StringBuilder();
                    for(int i = 0; i < cube.length; i++){
                        wordL.append(cube[i][0]);

                    }
                    String wordL2= wordL.toString();
                    new PushingWord(wordL2,1,"R");
                    break;
                case "B": case "b":
                    StringBuilder wordB = new StringBuilder();
                    for(int i = 0; i < cube[2].length; i++){
                        wordB.append(cube[2][i]);
                    }
                    String wordB2 = wordB.toString();
                    new PushingWord(wordB2,1,"L");
                    break;
                case "Q": case "q":
                    System.out.println("Bye~~!");
                    System.exit(0);

            }
        }
    }
    private  void printCube(String cube[][]){
        //배열 출력
        for(int i = 0; i < cube.length; i++){
            for(int j =0; j < cube[i].length; j++){
                System.out.print(cube[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args){
        String cube[][] = {{"R","R","W"},{"G","C","W"},{"G","B","B"}};

        new PlaneCube(cube);
    }
}
