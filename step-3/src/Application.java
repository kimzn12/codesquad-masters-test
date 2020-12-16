package src;

import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Application application = new Application();
        application.run(sc);

    }

    private void run(Scanner scanner){
        long startTime = System.currentTimeMillis();
        int numberOfOperations = 0;

        RubiksCube rubiksCube = new RubiksCube();
        rubiksCube.print();

        while(true){
            String inputValues = inputCommand(scanner);

            //Q 입력하면 종료
            if(inputValues.equalsIgnoreCase(Command.QUIT.cmd)){
                quit(startTime,numberOfOperations);
            }

            //S 입력하면 셔플
            if(inputValues.equalsIgnoreCase(Command.SHUFFLE.cmd)){
                rubiksCube.shuffle(50);
                rubiksCube.print();
            }

            String[] inputArray = splitInput(inputValues);

            for(String input:inputArray){
                if((getCommand(input) == null)||(getCommand(input) == Command.QUIT)
                        || (getCommand(input) == Command.SHUFFLE)){
                   continue;
                }
                numberOfOperations += 1;
                System.out.println(input.toUpperCase());
                rubiksCube.rubiksCubeProcess(getCommand(input));
                rubiksCube.print();

                if(rubiksCube.finish()){
                    System.out.println("🎉🎉🎉축하합니다. 큐브 완성!🎉🎉🎉");
                    System.out.println();
                    quit(startTime,numberOfOperations);
                }
            }
        }
    }



    private void quit(long startTime,int numberOfOperations) {
        long endTime = System.currentTimeMillis();
        long executionTime = (endTime - startTime)/1000;

        printResult(executionTime,numberOfOperations);
        System.exit(0);
    }

    private Command getCommand(String input) {
        for(Command command: Command.values()){
            if(command.cmd.equalsIgnoreCase(input)){
                return command;
            }
        }
        return null;
    }

    private String[] splitInput(String inputValues){
        String[] inputArray = inputValues.split("");

        for(int i = 0; i < inputArray.length - 1; i++){
            if(inputArray[i+1].equals("'")){
                inputArray[i] += inputArray[i+1];
            }
        }
        return inputArray;
    }

    private String inputCommand(Scanner scanner) {
        System.out.print("CUBE> ");

        return scanner.nextLine();
    }

    private void printResult(long time, int numberOfOperations) {
        System.out.printf("경과 시간: %02d:%02d\n", time / 60, time % 60);
        System.out.println("조작개수: " + numberOfOperations);
        System.out.println("🎈 이용해주셔서 감사합니다. 뚜뚜뚜. 🎈");
    }

}
