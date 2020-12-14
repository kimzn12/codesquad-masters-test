package src;

enum BlockColor {

    RED("\u001B[31mR\u001B[31m\u001B[0m"),
    GREEN("\u001B[36mG\u001B[36m\u001B[0m"),
    YELLOW("\u001B[33mY\u001B[33m\u001B[0m"),
    BLUE("\u001B[34mB\u001B[34m\u001B[0m"),
    PURPLE("\u001B[35mP\u001B[35m\u001B[0m"),
    WHITE("W");

    public String color;

    BlockColor(String color){
        this.color = color;
    }

}
