package flips;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlipperTests {

    /* TASK 1 */

    private void flipsMatchesTester(String src, String dest, List<Swap> flips, boolean expected) {
        List<Swap> flipsCopy = new ArrayList<Swap>(flips);
        assertEquals(expected, Flipper.flipsMatches(src, dest, flips));
        assertEquals(flipsCopy, flips); // test for no mutations
    }

    @Test
    public void testFlipsMatches4() {
        flipsMatchesTester("bot", "bto", Arrays.asList(new Swap(2, 1)), true);
        flipsMatchesTester("bot", "bto", Arrays.asList(new Swap(0, 1)), false);
    }

    @Test
    public void testFlipsMatches5() {
        flipsMatchesTester("rule", "lure", Arrays.asList(new Swap(0, 2)), false);
    }

    @Test
    public void testFlipsMatches9() {
        flipsMatchesTester("omega", "eomag", Arrays.asList(new Swap(1, 2),
                new Swap(4, 3),
                new Swap(1, 0)), true);
    }

    /* TASK 2 */

    private void flipsSequenceTester(String src, String dest) throws NoFlipListException {
        assertTrue(Flipper.flipsMatches(src, dest, Flipper.flipsSequence(src, dest)));
    }

    @Test
    public void testFlipsSequence0() throws NoFlipListException {
        flipsSequenceTester("", "");
    }

    @Test
    public void testFlipsSequence1() throws NoFlipListException {
        flipsSequenceTester("1010", "0101");
    }

    @Test
    public void testFlipsSequence2() throws NoFlipListException {
        flipsSequenceTester("0101", "1010");
    }

    @Test
    public void testFlipsSequence3() throws NoFlipListException {
        flipsSequenceTester("alex", "lexa");
        flipsSequenceTester("james", "semaj");
    }

    @Test (expected = NoFlipListException.class)
    public void testFlipsSequence4() throws NoFlipListException {
        flipsSequenceTester("oof", "ooo");
    }

    /* TASK 3 */

    private void similarPairsCountTester(String s, int maxDist, int expected) {
        assertEquals(expected, Flipper.similarPairsCount(s, maxDist));
    }

    @Test
    public void testSimilarPairsCount2() {
        similarPairsCountTester("k", 1, 0);
        similarPairsCountTester("k", 0, 0);
    }

    @Test
    public void testSimilarPairsCount7() {
        similarPairsCountTester("kafka", 0, 0);
        similarPairsCountTester("kafka", 1, 0);
        similarPairsCountTester("kafka", 2, 3);
        similarPairsCountTester("kafka", 10, 3);
        similarPairsCountTester("kafka!!", 10, 3);
    }

    @Test
    public void testSimilarPairsCount8() {
        similarPairsCountTester("10101", 0, 0);
        similarPairsCountTester("10101", 1, 1);
        similarPairsCountTester("10101", 2, 2); //1010 and 0101 should pass
        similarPairsCountTester("10101", 10, 2);
    }

    @Test
    public void testSimilarPairsCountMaxInt() {
        similarPairsCountTester("hello", Integer.MAX_VALUE, 0);
    }

}
