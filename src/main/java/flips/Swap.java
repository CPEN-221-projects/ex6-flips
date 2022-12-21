/*
 * DO NOT MODIFY THIS FILE
 */

package flips;

/**
 * Swap represents a swapping operation, where the characters in a String
 * whose indices correspond to the left and right values of the Swap are to
 * be swapped.
 *
 * In the documentation, we denote a Swap as a pair (l, r). Then if (l, r)
 * represents a Swap s, then s represents an instruction that swaps the
 * characters of str[l] and str[r] when applied to a String str.
 *
 * Swap is immutable.
 */
public class Swap {

    private int left;
    private int right;

    /**
     * Creates a new Swap (left, right).
     * @param left -- the left index of swapping, must be nonnegative
     * @param right -- the right index of swapping, must be nonnegative
     */
    public Swap(int left, int right) {
        this.left = left;
        this.right = right;
    }

    /**
     * @return l, where this Swap is (l, r)
     */
    public int getLeft() {
        return this.left;
    }

    /**
     * @return r, where this Swap is (l, r)
     */
    public int getRight() {
        return this.right;
    }

    /**
     * Abstraction function equality.
     * @param obj
     * @return true iff obj is a Swap and the Swap it represents is the
     *     same swapping operation as this Swap.
     */
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Swap)) {
            return false;
        }

        Swap other = (Swap) obj;

        return (this.left == other.left && this.right == other.right) ||
                (this.left == other.right && this.right == other.left);

    }

    @Override
    public int hashCode() {
        return this.left + this.right;
    }

}
