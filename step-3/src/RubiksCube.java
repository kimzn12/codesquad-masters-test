package src;

import java.text.Normalizer;
import java.util.Scanner;

public class RubiksCube {
    private static final int CUBE_SIZE = 3;

    Rotator rotator = new Rotator();

    Side frontSide;
    Side backSide;
    Side rightSide;
    Side leftSide;
    Side topSide;
    Side bottomSide;

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[36m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";


    public RubiksCube(){
        initCube();
        printRubiksCube();
    }

    private void initCube() {
        frontSide = new Side(CUBE_SIZE,ANSI_PURPLE + "P" + ANSI_PURPLE + ANSI_RESET); //Orange
        backSide = new Side(CUBE_SIZE,ANSI_YELLOW + "Y" + ANSI_YELLOW + ANSI_RESET); //Yellow
        rightSide = new Side(CUBE_SIZE,ANSI_GREEN + "G" + ANSI_GREEN + ANSI_RESET); //Green
        leftSide = new Side(CUBE_SIZE,"W"); //White
        topSide = new Side(CUBE_SIZE,ANSI_BLUE + "B" + ANSI_BLUE+ ANSI_RESET); //Blue
        bottomSide = new Side(CUBE_SIZE,ANSI_RED + "R"+ ANSI_RED+ ANSI_RESET); //Red

    }

    public void run(){
        while(true){
            //입력받기
            String commands = inputLine();

            //Q 입력하면 종료
            if(commands.equalsIgnoreCase("Q")){
                System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
                System.exit(0);
            }

            String[] lineArray = commands.split("");

            for(String command:lineArray){
                if(command.equalsIgnoreCase("U")){
                    rotator.turnTopSide("L",leftSide,frontSide,rightSide,backSide);
                }
            }
            printRubiksCube();

        }
    }

    //라인(U,R,L,B) 입력받기
    private  String inputLine(){
        System.out.print("CUBE> ");
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

    /*출력*/
    //옆면들 출력
    private void printSides(){
        for(int i = 0; i < CUBE_SIZE; i++){
            leftSide.printLine(i);
            frontSide.printLine(i);
            rightSide.printLine(i);
            backSide.printLine(i);
            System.out.println();
        }
        System.out.println();
    }



    //루빅스 큐브 출력
    public void printRubiksCube() {
        topSide.printTopOrBottom();
        printSides();
        bottomSide.printTopOrBottom();
    }

}
