
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called GameFlow that represented the all game.
 */

public class GameFlow {

    private AnimationRunner ar;
    private KeyboardSensor ks;
    private GUI gui;

    private Counter score;


    /**
     * This is a constructor that initialize the GameFlow.
     *
     * @param ar
     * @param ks
     * @param gui
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.ar = ar;
        this.ks = ks;
        this.gui = gui;
    }


    /**
     * This method is run all our levels in the game.
     *
     * @param levels
     */

    public void runLevels(List<LevelInformation> levels) {
        Boolean flag = true;
        this.score = new Counter(0);
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.ks, this.gui, this.ar, this.score);
            level.initialize();
            while (level.getNumOfBalls().getValue() != 0 && level.getNumOfBlocks().getValue() != 0) {
                level.run();
            }
            if (level.getNumOfBalls().getValue() == 0) {
                GameOverScreen gos = new GameOverScreen(this.score.getValue(), this.ks);
                KeyPressStoppableAnimation kps = new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY, gos);
                ar.run(kps);
                flag = false;
                break;
            }
        }
        if (flag) {
            WinGameScreen wgs = new WinGameScreen(this.score.getValue(), this.ks);
            KeyPressStoppableAnimation kps = new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY, wgs);
            ar.run(kps);
        }
    }


}

