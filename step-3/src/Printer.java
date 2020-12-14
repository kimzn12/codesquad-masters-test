package src;

public class Printer {
    private static final int TOP_SIDE_INDEX = 0;
    private static final int BOTTOM_SIDE_INDEX = 5;

    //루빅스 큐브 출력
    public static void printRubiksCube(Block[][][] cube) {
        printTopOrBottom(cube[TOP_SIDE_INDEX]);
        printSides(cube);
        printTopOrBottom(cube[5]);
    }

    //큐브 위 아랫면 출력
    private static void printTopOrBottom(Block[][] side){
        for(Block[] line:side){
            System.out.print("\t\t\t");
            for(Block block:line){
                System.out.print(block.getColor() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //4개 옆면 출력
    private static void printSides(Block[][][] cube) {
        for (int i = 0; i < cube[TOP_SIDE_INDEX].length; i++) {
            for(int j = (TOP_SIDE_INDEX + 1); j < BOTTOM_SIDE_INDEX; j++){
                printLine(cube[j], i);
            }
            System.out.println();
        }
        System.out.println();
    }

    // 큐브 한 면의 라인 출력
    private static void printLine(Block[][] side, int index) {
        for(int i = 0; i < side.length; i++){
            System.out.printf("%s ", side[index][i].getColor());
        }
        System.out.print("\t");
    }

}
