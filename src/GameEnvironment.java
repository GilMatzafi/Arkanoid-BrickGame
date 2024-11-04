import java.util.ArrayList;
import java.util.List;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called GameEnvironment that represented points in the world by two dimensions.
 */

public class GameEnvironment {

    private List<Collidable> collidableList;

    /**
     * This is a constructor that initialize the class.
     */

    public GameEnvironment() {
        this.collidableList = new ArrayList<Collidable>();
    }

    /**
     * This is a method that return a list of collidable objects.
     *
     * @return list of collidable objects.
     */

    public List<Collidable> getCollidableList() {
        return this.collidableList;
    }

    /**
     * This is a method that add the given collidable to the environment.
     *
     * @param c
     */

    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }


    /**
     * This is a method that removes the given collidable to the environment.
     *
     * @param c
     */

    public void removeCollidable(Collidable c) {
        this.collidableList.remove(c);
    }

    /**
     * This is a method that return the information.
     * about the closest collision that is going to occur
     *
     * @param trajectory
     * @return CollisonInfo object.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        List<CollisionInfo> collisionInfoList = new ArrayList<>();


        for (int i = 0; i < this.collidableList.size(); i++) {
            if (trajectory.
                    closestIntersectionToStartOfLine(this.collidableList.get(i).getCollisionRectangle()) != null) {
                Point point = trajectory.
                        closestIntersectionToStartOfLine(this.collidableList.get(i).getCollisionRectangle());
                Collidable collidable = this.collidableList.get(i);
                CollisionInfo collisionInfo = new CollisionInfo(point, collidable);
                collisionInfoList.add(collisionInfo);
            }
        }
        if (collisionInfoList.size() == 0) {
            return null;
        }
        double minDistance = trajectory.start().distance(collisionInfoList.get(0).collisionPoint());
        CollisionInfo minCollisionInfo = new CollisionInfo(collisionInfoList.get(0).
                collisionPoint(), collisionInfoList.get(0).collisionObject());
        for (int i = 1; i < collisionInfoList.size(); i++) { //find minimum algoritm
            if (trajectory.start().distance(collisionInfoList.get(i).collisionPoint()) < minDistance) {
                minDistance = trajectory.start().distance(collisionInfoList.get(i).collisionPoint());
                minCollisionInfo = new CollisionInfo(collisionInfoList.get(i).
                        collisionPoint(), collisionInfoList.get(i).collisionObject());
            }
        }
        return minCollisionInfo;
    }
}
