import biuoop.DrawSurface;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called DirectHit that represnt the first level in our game.
 */

public class DirectHit implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(new Velocity(0.0001, -3));
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 9;
    }

    @Override
    public int paddleWidth() {
        return 90;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {

        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.black);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.lightGray);
                d.fillRectangle(0, 0, 800, 40);
                d.setColor(Color.black);
                d.drawText(500, 30, "level name: " + levelName(), 20);
                d.setColor(Color.blue);
                d.drawCircle(400, 165, 120);
                d.drawCircle(400, 165, 90);
                d.drawCircle(400, 165, 60);
                d.drawLine(280, 165, 380, 165);
                d.drawLine(420, 165, 520, 165);
                d.drawLine(400, 40, 400, 165);
                d.drawLine(400, 165, 400, 280);
            }

            @Override
            public void timePassed() {
                return;
            }
        };

    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(new Point(385, 150), 30, 30), Color.RED.darker()));
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
