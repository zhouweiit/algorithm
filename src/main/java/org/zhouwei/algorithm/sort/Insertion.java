package org.zhouwei.algorithm.sort;

/**
 *
 * 插入排序
 *
 * 时间复杂度O(n平方)
 *
 * Created by zhouwei on 2018/5/8.
 */
public class Insertion {

    public int[] number = new int[]{50,10,70,20,55,13,71,99,123,31,45,91,82,50,20,61,78,93};

    public void sort() {
        for (int i = 1; i < number.length; i++) {//第一层循环是处理数据中的每一个数字
            int tmp = number[i];
            for (int j = i - 1; j >= 0; j--){//第二层循环是插入的时候，移动位置
                if (tmp < number[j]) {
                    number[j + 1] = number[j];
                    number[j] = tmp;
                }
            }
        }
    }

    public static void main(String args[]) {
        Insertion insertion = new Insertion();
        insertion.sort();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < insertion.number.length; i++) {
            sb.append(insertion.number[i]).append(",");
        }
        System.out.println(sb.toString());
    }

}
