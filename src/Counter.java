
// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called Counter that uses for counting.
 */
public class Counter {
    private int value;

    /**
     * This is constructor that initialize the counter.
     *
     * @param value
     */
    public Counter(int value) {
        this.value = value;
    }

    /**
     * This method add the number to our value.
     *
     * @param number
     */
    public void increase(int number) {
        this.value += number;
    }

    /**
     * This method subtract the number from our value.
     *
     * @param number
     */

    public void decrease(int number) {
        this.value -= number;
    }

    /**
     * This method get the value.
     *
     * @return int
     */
    public int getValue() {
        return this.value;
    }
}
