package org.zhouwei.algorithm.sort;

/**
 *
 * 冒泡排序
 *
 * 时间复杂度：O(n平方)
 *
 * Created by zhouwei on 2018/5/7.
 */
public class MaoPao {

    public int[] number = new int[]{50,10,70,20,55,13,71,99,123,31,45,91,82,50,20,61,78,93};

    public int[] sort() {
        for (int i = 0; i < number.length; i++){
            for (int j = 0; j < number.length - 1 - i; j++) { //这里可以减去i，因为每一次排序交换位置后，最大的都已经在最后了
                if (number[j] > number[j + 1]) {
                    Integer tmp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = tmp;
                }
            }
        }
        return number;
    }

    public static void main(String args[]) {
        MaoPao maoPao = new MaoPao();
        maoPao.sort();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maoPao.number.length; i++) {
            sb.append(maoPao.number[i]).append(",");
        }
        System.out.println(sb.toString());
    }

}
