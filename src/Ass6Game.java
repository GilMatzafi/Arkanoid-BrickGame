
// 318597879 Gil Matzafi

import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gil Matzafi
 * This class called Ass6Game that create the game.
 */

public class Ass6Game {

    /**
     * This is the main method that activate the game.
     *
     * @param args
     */

    public static void main(String[] args) {

        GUI gui = new GUI("Arkanoid", 800, 600);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        AnimationRunner runner = new AnimationRunner(gui, 60);
        GameFlow gameFlow = new GameFlow(runner, keyboard, gui);
        List<LevelInformation> levels = new ArrayList<>();

        if (args.length > 0) {
            for (String arg : args) {
                if (arg.equals("1")) {
                    levels.add(new DirectHit());
                } else if (arg.equals("2")) {
                    levels.add(new WideEasy());
                } else if (arg.equals("3")) {
                    levels.add(new Green3());
                } else if (arg.equals("4")) {
                    levels.add(new FinalFour());
                }
            }
        }
        if (levels.size() == 0) {
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Green3());
            levels.add(new FinalFour());
        }
        gameFlow.runLevels(levels);
        gui.close();
    }
}

