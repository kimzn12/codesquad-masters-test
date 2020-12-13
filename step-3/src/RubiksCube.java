package src;

import java.util.Scanner;

public class RubiksCube {
    private static final int CUBE_SIZE = 3;
    private int numberOfOperations = 0;

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
        frontSide = new Side(CUBE_SIZE,ANSI_PURPLE + "P" + ANSI_PURPLE + ANSI_RESET); //Purple
        backSide = new Side(CUBE_SIZE,ANSI_YELLOW + "Y" + ANSI_YELLOW + ANSI_RESET); //Yellow
        rightSide = new Side(CUBE_SIZE,ANSI_GREEN + "G" + ANSI_GREEN + ANSI_RESET); //Green
        leftSide = new Side(CUBE_SIZE,"W"); //White
        topSide = new Side(CUBE_SIZE,ANSI_BLUE + "B" + ANSI_BLUE+ ANSI_RESET); //Blue
        bottomSide = new Side(CUBE_SIZE,ANSI_RED + "R"+ ANSI_RED+ ANSI_RESET); //Red

    }

    public void run(){
        long beforeTime = System.currentTimeMillis();

        while(true){
            //입력받기
            String commands = inputLine();

            //Q 입력하면 종료
            if(commands.equalsIgnoreCase("Q")){
                long afterTime = System.currentTimeMillis();
                long executionTime = (afterTime - beforeTime)/1000;

                System.out.println("경과 시간: " + executionTime + "초");
                System.out.println("조작개수: " + numberOfOperations);
                System.out.println("🎈 이용해주셔서 감사합니다. 뚜뚜뚜. 🎈");
                System.exit(0);
            }



            String[] lineArray = commands.split(" ");

            for(String command:lineArray){
                numberOfOperations += 1;
                System.out.println(command); //대문자로 출력하기
                rubiksCubeProcess(command);
                printRubiksCube();
            }


        }
    }

    private void rubiksCubeProcess(String command) {
        switch (command){
            case "U": case "u":
                rotator.turnBaseSide("R",topSide);
                rotator.turnTopSide("L",leftSide,frontSide,rightSide,backSide);
                break;
            case "D": case "d":
                rotator.turnBaseSide("R",bottomSide);
                rotator.turnBottomSide("R",leftSide,frontSide,rightSide,backSide);
                break;
            case "R": case "r":
                rotator.turnBaseSide("R",rightSide);
                rotator.turnRightSide("R",topSide,backSide,bottomSide,frontSide);
                break;
            case "L": case "l":
                rotator.turnBaseSide("R",leftSide);
                rotator.turnLeftSide("L",topSide,backSide,bottomSide,frontSide);
                break;
            case "F": case "f":
                rotator.turnBaseSide("R",frontSide);
                rotator.turnFrontSide("R",topSide,rightSide,bottomSide,leftSide);
                break;
            case "B": case "b":
                rotator.turnBaseSide("R",backSide);
                rotator.turnBackSide("L",topSide,rightSide,bottomSide,leftSide);


                //반대로 돌기
            case "U'": case "u'":
                rotator.turnBaseSide("L",topSide);
                rotator.turnTopSide("R",leftSide,frontSide,rightSide,backSide);
                break;
            case "D'": case "d'":
                rotator.turnBaseSide("L",bottomSide);
                rotator.turnBottomSide("L",leftSide,frontSide,rightSide,backSide);
                break;
            case "R'": case "r'":
                rotator.turnBaseSide("L",rightSide);
                rotator.turnRightSide("L",topSide,backSide,bottomSide,frontSide);
                break;
            case "L'": case "l'":
                rotator.turnBaseSide("L",leftSide);
                rotator.turnLeftSide("R",topSide,backSide,bottomSide,frontSide);
                break;
            case "F'": case "f'":
                rotator.turnBaseSide("L",frontSide);
                rotator.turnFrontSide("L",topSide,rightSide,bottomSide,leftSide);
                break;
            case "B'": case "b'":
                rotator.turnBaseSide("L",backSide);
                rotator.turnBackSide("R",topSide,rightSide,bottomSide,leftSide);
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
