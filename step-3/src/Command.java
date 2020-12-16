package src;

enum Command {
    FRONT("F"),FRONT_REVERSE("F'"),
    BACK("B"),BACK_REVERSE("B'"),
    UP("U"),UP_REVERSE("U'"),
    DOWN("D"),DOWN_REVERSE("D'"),
    RIGHT("R"),RIGHT_REVERSE("R'"),
    LEFT("L"),LEFT_REVERSE("L'"),
    SHUFFLE("S"),QUIT("Q");

    public String cmd;

    Command(String cmd){
        this.cmd = cmd;
    }

}
