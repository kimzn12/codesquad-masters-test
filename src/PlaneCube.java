
import java.util.Scanner;

public class PlaneCube {
    private final String[][] cube;

    public PlaneCube(String[][] cube){
        this.cube = cube;
        printCube();
    }

    public void run(){
        while(true){
            //입력받기
            String lines = inputLine();

            //Q 입력하면 종료
            if(lines.equalsIgnoreCase("Q")){
                System.out.println("Bye~~!");
                System.exit(0);
            }

            String[] lineArray = lines.split("");
            for(String line:lineArray){
                cubeProcess(line);
            }

        }
    }

    //라인(U,R,L,B) 입력받기
    private  String inputLine(){
        System.out.print("cube> ");
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

    //U,R,B,L 입력시 큐브 동작
    private void cubeProcess(String line) {
        switch (line){
            case "U": case "u":
                TurnLeft("U");
                printCube();
                break;
            case "R": case "r":
                TurnLeft("R");
                printCube();
                break;
            case "L": case "l":
                TurnRight("L");
                printCube();
                break;
            case "B": case "b":
                TurnRight("B");
                printCube();
                break;
        }
    }

    //왼쪽으로 돌리기
    private void TurnLeft(String line) {
        //라인의 배열 -> 문자열로 합치기: ["R","W,"R"] ->"RWR"
        String word = ArrayToString(line);

        //문자열 회전
        PushingWord pushingWord = new PushingWord(word,1,"L");
        String result = pushingWord.printWord();

        System.out.println(line);
        updateCube(result,line);
    }

    //오른쪽으로 돌리기
    private void TurnRight(String line){
        String word = ArrayToString(line);

        //문자열 회전
        PushingWord pushingWord = new PushingWord(word,1,"R");
        String result = pushingWord.printWord();

        System.out.println(line);
        updateCube(result,line);
    }

    //라인의 배열 -> 문자열로 합치기: ["R","W,"R"] ->"RWR"
    private String ArrayToString(String line) {
        StringBuilder word = new StringBuilder();

        switch (line) {
            case "U":
                for (int i = 0; i < cube[0].length; i++) {
                    word.append(cube[0][i]);
                }
                break;
            case "R":
                for (String[] strings : cube) {
                    word.append(strings[2]);
                }
                break;
            case "B":
                for (int i = 0; i < cube[2].length; i++) {
                    word.append(cube[2][i]);
                }
                break;
            case "L":
                for (String[] strings : cube) {
                    word.append(strings[0]);
                }
                break;
        }

        return word.toString();
    }


    //회전 후, 큐브 업데이트
    private void updateCube(String str,String line) {
        switch (line){
            case "U": //Up
                cube[0] = str.split(""); // ["R","W","R"]
                break;
            case "R": //Right
                for(int i = 0; i < cube.length; i++){
                    cube[i][2] = str.split("")[i];
                }
                break;
            case "B": //Back
                cube[2] = str.split("");
                break;
            case "L": //Left
                for(int i = 0; i < cube.length; i++){
                    cube[i][0] = str.split("")[i];
                }
                break;
        }

    }

    //큐브 출력
    private  void printCube(){
        for (String[] strings : cube) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
