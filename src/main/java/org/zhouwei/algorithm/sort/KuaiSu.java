package org.zhouwei.algorithm.sort;

/**
 * 快速排序
 *
 * 遍历从两边开始，找一个大于基数与小于基数的数字，然后交换
 *
 * 真他妈太难写了，写到半夜3点才搞定，足足4个小时，太他妈难调试了
 *
 */
public class KuaiSu {

    public int[] number = new int[]{50,10,70,20,55,13,71,99,123,31,45,91,82,50,20,61,78,93};

    public void sort(int a,int b, int value) {
        int i = a, j = b;
        while(true) {
            if (i == j) {
                if (number[j] >= value) {//大于等于交换
                    number[a] = number[j - 1];
                    number[j - 1] = value;
                } else if (number[j] < value) {//等于
                    number[a] = number[j];
                    number[j] = value;
                }
                break;
            }
            if (number[i] <= value && i < j) {//如果比value小，并且 i < j,则左边数字++
                i++;
            }
            if (number[j] >= value && j > i) {//如果比value大，并且 j > i,则右边数字--
                j--;
            }
            if (number[i] > value && number[j] < value) {//如果同时左边比右边大，右边比左边小，则交换
                int tmp = number[i];
                number[i] = number[j];
                number[j] = tmp;
            }
        }

        if (a < j - 1) {
            sort(a, j, number[a]);
        }

        if (j + 1 < b) {
            sort(j, b, number[j]);
        }
    }

    public static void main(String args[]) {
        KuaiSu kuaiSu = new KuaiSu();
        kuaiSu.sort(0,kuaiSu.number.length - 1,kuaiSu.number[0]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < kuaiSu.number.length; i++) {
            sb.append(kuaiSu.number[i]).append(",");
        }
        System.out.println(sb.toString());
    }
}
