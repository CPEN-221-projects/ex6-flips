Flips
===

## Overview
In this question, we deal with **swaps** (swapping element positions in a list) and **flips** (swapping operations for two adjacent elements). Today, we will focus on **flips** being applied to `String`s, but the algorithms can be extended to sequences/lists of any type.

## Background
A string can be thought of as a sequence of characters. Then characters of a string may be swapped.

For example, we can swap the `1`st and `3`rd characters (recall that we zero-index) of `"hello"`. This would give us the string `"hlleo"`.

We may thus represent a **swap** as an *unordered* pair of nonnegative integers `(l, r)`. The swap in the previous example would be represented as `(1, 3)`.

As another example, consider the swap `(4, 5)`. This swap can be applied to the string `"github"` to obtain `"githbu"`. However, `(4, 5)` (the same swap as `(5, 4)`) cannot be applied to `"hello"`, as the indices would be out of bounds. Thus we say that a swap is **valid** on a string when the swapping indices are within bounds.

Notice that the swap in the previous example had the indices differ by exactly one. That is, adjacent characters are to be swapped. Such a swap is called a **flip**. Other examples of flips include `(0, 1)`, `(11, 10)`, and `(3, 4)`.

We may apply a `List` of flips to a string. For example, the list `[(1, 2), (4, 3), (1, 0)]` applied to the string `"omega"` gives `"eomag"`. The flips are applied in order and so `[(1, 0), (1, 0)]` when applied to `"omega"` will produce `"omega"`.

Tasks 1 and 2 deal with how a list of flips can be applied to one string to obtain another.

The provided test cases for Task 2 use `flipsMatches` from Task 1; hence the correctness of these test cases depend on the correctness of your Task 1 implementation (for the purposes of grading, we will use our own implementation of `flipsMatches` to test Task 2).

Thinking about lists of flips, we may define the **flip distance** (or simply distance) between two strings to be the **minimum number of flips** that turns one string into the other. In other words, the distance is equal to the length of the shortest list of flips that turns one string into the other. If no such sequence of flips exists, the distance is infinite (as a side note, this distance function may be classified as a *[metric](https://en.wikipedia.org/wiki/Metric_(mathematics)#Definition)*). The distance of a pair of strings refers to the distance between the pair's two strings.

Task 3 asks for the number of unordered pairs of distinct substrings of a given string that has a distance of at most a certain number. Recall that `t` is a substring of `s` iff `t` occurs as a contiguous sequence in `s` (in more precise terms, iff `t` is equal to `s[i:i+k]` for some `i` and `k`). Then a pair of distinct substrings is a pair of substrings `t1` and `t2` where `t1` is not equal to `t2`. Note that a substring `t` may occur in `s` multiple times.
> **Example 1:** Consider the string `"kafka"`. For a maximum distance of `2`, there are `3` distinct pairs satisfying this distance criterion: `("kaf", "afk")`, `("kaf", "fka")`, and `("afk", "fka")`.
>
> Note that `("ka", "ka")` is not a distinct pair as `"ka"` and `"ka"` are equal strings.

> **Example 2:** Consider the string `"10101"`. For a maximum distance of `2`, there are `2` such distinct unordered pairs: `("10", "01")` and `("1010", "0101")`. In this case, `"10"` and `"01"` both appear twice in the string.

Finally, parameters and returned objects should not be mutated. In the case of parameters, recall that mutating inputs is assumed to be disallowed unless explicitly stated otherwise.

## Tasks

### Task 1
Implement `flipsMatches` in `Flipper.java`.
```java
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
    // Your code here...
}
```

### Task 2
Implement `flipsSequence` in `Flipper.java`.
```java
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
    // Your code here...
}
```

### Task 3
Implement `similarPairsCount` in `Flipper.java`.
```java
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
    // Your code here...
}
```

## Logistics

**Grading**

| Work Accomplished | Grade |
| ----------------- | ----- |
| Task 1 does not pass all hidden tests | F |
| Task 1 passes all hidden tests | C |
| Tasks 1, 2 pass all hidden tests | B |
| Tasks 1, 2 and 3 pass all hidden tests | A |

**Submission Instructions**

+ Submit your work to the Github classroom repository that was created for you.
+ **Do not alter the directory/folder structure. You should retain the structure as in this repository.**
+ Do not wait until the last minute to push your work to Github. It is a good idea to push your work at intermediate points as well. _We would recommend that you get your Git and Github workflow set up at the start._

**What Should You Implement / Guidelines**

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional **standard** Java libraries (in `java.util`) by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.


## Honour Code

By submitting your work to Github you agree to the following:

+ You did not consult with any other person for the purpose of completing this activity.
+ You did not aid any other person in the class in completing their activity.
+ If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
+ You are not aware of any infractions of the honour code for this examination.

## Answers to FAQs

* **Can I consult Java documentation and other Internet-based sources?**

    Yes, you can. The point of this test is not to demonstrate mastery over syntax but that you can solve a problem in a    reasonable amount of time with reasonable resources.

    *If you find useful information online outside the official Java documentation and the course material, you must cite the source. You should do so by adding comments in your source code.*

    Naturally you are expected to adhere to all of the course and UBC policies on academic integrity.

* **Why am I not guaranteed full credit if my implementation passes all the provided tests?**

    It is easy to develop an implementation that passes the provided tests and not much else. A good-faith implementation that passes all the provided tests is very likely to pass other tests too.
