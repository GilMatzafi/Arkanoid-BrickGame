import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called WideEasy that represnt the second level in our game.
 */

public class WideEasy implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            velocityList.add(Velocity.fromAngleAndSpeed((i * -6) + 30, 5));
        }
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.white);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.lightGray);
                d.fillRectangle(0, 0, 800, 40);
                d.setColor(Color.black);
                d.drawText(500, 30, "level name: " + levelName(), 20);
                d.setColor(new Color(239, 231, 176));
                d.fillCircle(150, 150, 60);
                for (int i = 10; i < 790; i += 10) {
                    d.drawLine(150, 150, i, 250);
                }
                d.setColor(Color.orange);
                d.fillCircle(150, 150, 50);
                d.setColor(Color.yellow);
                d.fillCircle(150, 150, 40);
            }

            @Override
            public void timePassed() {

            }
        };
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Color blockColor = Color.RED;
        for (int i = 0; i < 15; i++) {
            if (i < 2) {
                blockColor = Color.RED;
            } else if (i < 4) {
                blockColor = Color.orange;
            } else if (i < 6) {
                blockColor = Color.yellow;
            } else if (i < 9) {
                blockColor = Color.green;
            } else if (i < 11) {
                blockColor = Color.blue;
            } else if (i < 13) {
                blockColor = Color.pink;
            } else {
                blockColor = Color.CYAN;
            }
            Block block = new Block(new Rectangle(
                    new Point(20 + (50.7 * i), 250), 50.7, 25), blockColor);
            blockList.add(block);
        }
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 10;
    }
}
