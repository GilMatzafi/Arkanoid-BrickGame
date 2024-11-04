// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This interface called HitNotifier.
 * The HitNotifier interface indicate that objects that implement it send notifications when they are being hit.
 */

public interface HitNotifier {
    /**
     * This method Add hl as a listener to hit events.
     *
     * @param hl
     */
    void addHitListener(HitListener hl);

    /**
     * This method remove hl from the list of listeners to hit events.
     *
     * @param hl
     */
    void removeHitListener(HitListener hl);
}