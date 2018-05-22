package org.zhouwei.algorithm.string;

/**
 *
 * 朴素算法与KMP算法，都可以用来实现
 *
 * 朴素算法：时间复杂度O(n * m)
 * KMP：时间复杂度O(n + m)
 *
 * case1:
 * 主串：abcabdca
 * 子串：abdca
 *
 * case2:
 * 主串：ababababc
 * 子串：abababc
 *
 * 如果理解KMP呢，有几个点难以理解：
 * 1. 什么是前缀与后缀，为什么要是最长长度的
 *      解答：这样会提高性能，因为我比较后，拿到最大相同的后缀与字串开始比较，不用朴素比较了，同时也不会遗漏数据
 *
 * 2. 按照普通模式理解，我不用朴素比较，等连续匹配到哪一个不相同，为啥不直接把指针移动过去就好了
 *      解答：这样会遗漏，比如case2，按照我们的理解，我们可能从子串的c的指针处开始重新比较了，但这么就会遗漏。
 *
 * 3. 针对问题1和2，我们一定要开出来，它到底在什么地方降低了时间复杂度
 *      解答：总体是提高了效率并且不会错过
 *
 * Created by zhouwei on 2018/5/22.
 */
public class KMP {

    public String a = "bacbababadababacambabacaddababacasdsd";

    public String b = "ababaca";

    public static void main(String[] args) {
        KMP kmp = new KMP();

    }

}
