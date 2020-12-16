package src;

public class Application {
    public static void main(String[] args) {
        String[][] cube = {{"R", "R", "W"}, {"G", "C", "W"}, {"G", "B", "B"}};

        PlaneCube planeCube = new PlaneCube(cube);
        planeCube.run();
    }

}
