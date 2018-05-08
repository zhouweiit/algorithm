package org.zhouwei.algorithm.sort;

/**
 *
 * 归并排序算法实现
 *
 * Created by zhouwei on 2018/5/8.
 */
public class Merge {

    public int[] number = new int[]{50,10,70,20,55,13,71,99,123,31,45,91,82,50,20,61,78,93};

    public void merge(int low, int mid, int high) {

    }

    public void sort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(low, mid);
            sort(mid + 1, high);
            merge(low,mid,high);
        }
    }

    public static void main(String args[]) {
        Merge merge = new Merge();
        merge.sort(0, merge.number.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < merge.number.length; i++) {
            sb.append(merge.number[i]).append(",");
        }
        System.out.println(sb.toString());
    }
}
