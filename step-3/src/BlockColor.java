package src;

enum BlockColor {

    RED("\u001B[31mR\u001B[31m\u001B[0m"),
    GREEN("\u001B[36mG\u001B[36m\u001B[0m"),
    YELLOW("\u001B[33mY\u001B[33m\u001B[0m"),
    BLUE("\u001B[34mB\u001B[34m\u001B[0m"),
    PURPLE("\u001B[35mP\u001B[35m\u001B[0m"),
    WHITE("W");

//    private static final String ANSI_RED = "\u001B[31m";
//    private static final String ANSI_GREEN = "\u001B[36m";
//    private static final String ANSI_YELLOW = "\u001B[33m";
//    private static final String ANSI_BLUE = "\u001B[34m";
//    private static final String ANSI_RESET = "\u001B[0m";
//    private static final String ANSI_PURPLE = "\u001B[35m";

    public String color;

    BlockColor(String color){
        this.color = color;
    }

}
