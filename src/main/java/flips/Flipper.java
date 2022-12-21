package flips;

import java.util.*;

public class Flipper {

    /**
     * Checks whether or not a list of flips will bring src to dest.
     * Returns false if there is some swap that is an invalid flip.
     *
     * A swap is said to be a flip iff its swapping indices are adjacent
     *     i.e. they differ by one.
     * A swap (and by extension a flip) is said to be valid on a string s
     *     iff its swapping indices are within bounds for s.
     *
     * @param src -- the string to start from
     * @param dest -- the target string
     * @param flips -- a sequence of swaps to be performed on src
     * @return true iff flips is a sequence of valid flips that when applied
     *     to src results in dest
     */
    public static boolean flipsMatches(String src, String dest, List<Swap> flips) {
        char[] charArray = src.toCharArray();
        if (flips.size() != flips.stream().filter(Flipper::validFlip).count()) {
            return false;
        }
        flips.forEach(x -> {
            char temp = charArray[x.getLeft()];
            charArray[x.getLeft()] = charArray[x.getRight()];
            charArray[x.getRight()] = temp;
        });

        return new String(charArray).equals(dest);
    }
    private static boolean validFlip(Swap flip) {
        return Math.abs(flip.getLeft() - flip.getRight()) == 1;
    }

    /**
     * Finds a list of valid flips on src that when applied to src gives dest.
     * Throws a NoFlipListException if no such list of flips exists.
     *
     * @param src
     * @param dest
     * @return A list of flips, if any exist, that results in dest when applied
     *     to src
     * @throws NoFlipListException if there does not exist a sequence of flips
     *     that results in dest when applied to src
     */
    public static List<Swap> flipsSequence(String src, String dest) throws NoFlipListException {
        char[] srcArray = src.toCharArray();
        char[] destArray = dest.toCharArray();
        List<Swap> swapList = new ArrayList<>();

        if (!isAnagram(srcArray, destArray)) {
            throw new NoFlipListException();
        }

        for (int destIndex = 0; destIndex < srcArray.length; destIndex++) {
            char destLetter = destArray[destIndex];
            int srcIndex = findNextIndex(srcArray, destLetter, destIndex);

            while (srcIndex != destIndex) {
                char temp = srcArray[srcIndex];
                srcArray[srcIndex] = srcArray[srcIndex - 1];
                srcArray[srcIndex - 1] = temp;

                swapList.add(new Swap(srcIndex - 1, srcIndex));
                srcIndex--;
            }

        }

        return swapList;
    }
    private static boolean isAnagram(char[] arr1, char[] arr2) {
        char[] c1 = arr1.clone();
        char[] c2 = arr2.clone();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    private static int findNextIndex(char[] destArray, char srcLetter, int srcIndex) {
        for (int i = srcIndex; i < destArray.length; i++) {
            if (srcLetter == destArray[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Determines the number of pairs of distinct substrings of s that are
     *     a distance of maxDist or less.
     * The distance of a pair of strings is defined to be the distance between
     *     its two constituent strings.
     * The distance between two strings is defined to be the length of the
     *     shortest list of (valid on either string) flips that brings one
     *     string to the other. If no such list exists, the distance is
     *     taken to be infinite.
     *
     * Note that the distance between two strings as we have defined is
     *     a metric.
     *
     * Further note that a substring may appear multiple times in a string.
     *
     * @param s
     * @param maxDist -- is nonnegative
     * @return the number of pairs of substrings of s whose distance is at
     *     most maxDist.
     */
    public static int similarPairsCount(String s, int maxDist) {
        int allPairsCount = 0;

        //won't ever get anything of length 1 dumbo
        for (int i = 2; i < s.length(); i++) {
            allPairsCount += similarSubstrings(s, maxDist, i);
        }

        return allPairsCount;
    }
    public static int similarSubstrings(String s, int maxDist, int length) {
        List<String> substrings = new ArrayList<>();

        for (int i = 0; i <= s.length() - length; i++) {
            substrings.add(s.substring(i, i + length));
        }

        List<Set<String>> distPairs = new ArrayList<>();
        for (int i = 0; i < substrings.size() - 1; i++) {
            String curStr = substrings.get(i);
            for (int j = i + 1; j < substrings.size(); j++) {
                String nextStr = substrings.get(j);

                if (curStr.equals(nextStr) || !isAnagram(curStr.toCharArray(), nextStr.toCharArray())) {
                    continue;
                }
                try {
                    if (flipsSequence(curStr, nextStr).size() <= maxDist) {
                        Set<String> thisPair = new HashSet<>();
                        thisPair.add(curStr);
                        thisPair.add(nextStr);
                        if (!distPairs.contains(thisPair)) {
                            distPairs.add(thisPair);
                        }
                    }
                } catch (NoFlipListException ignored) {

                }
            }
        }

        return distPairs.size();
    }

}
