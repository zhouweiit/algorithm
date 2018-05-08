package org.zhouwei.algorithm.sort;

/**
 *
 * 归并排序算法实现
 *
 * Created by zhouwei on 2018/5/8.
 */
public class Merge {

    public int[] number = new int[]{50,10,70,20,55,13,71,99,123,31,45,91,82,50,20,61,78,93};

    /**
     * 比较两个数组，排序后合并成大数组，合并后，返回的数据都是有效的
     * @param left
     * @param right
     * @return
     */
    public int[] merge(int[] left,int[] right) {
        int[] result = new int[left.length + right.length];

        int l = 0;
        int r = 0;
        int i = 0;
        while (true) {
            if (l > left.length - 1 || r > right.length - 1) {//如果任何一个数组超过了，这中断循环
                break;
            }
            if (left[l] <= right[r]) {//如果左边小于等于右边，则将左边的数组元素加入result
                result[i] = left[l];
                l++;
            } else {//如果左边大于右边，则将左边的数组元素加入result
                result[i] = right[r];
                r++;
            }
            i++;
        }

        if (l <= left.length - 1) {//如果左边的数据没有加载完，则剩下的都是最大的，按顺序将剩下的全部装在进入数据，因为归并都是有序的
            for (; l <= left.length - 1; l++) {
                result[i++] = left[l];
            }
        } else {//否则就是右边的没有加载完，则剩下的都是最大的，则将剩下的全部装在进入数据，因为归并都是有序的
            for (; r <= right.length - 1; r++) {
                result[i++] = right[r];
            }
        }

        return result;
    }

    /**
     * 递归排序
     * @param arr
     * @return
     */
    public int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int a = 0;
        int b = arr.length - 1;
        int mid = (a + b) / 2;
        int[] left = sort(getNewArr(arr,a,mid));
        int[] right = sort(getNewArr(arr,mid+1,b));
        return merge(left,right);
    }

    /**
     * 生成拆分归并排序所需要的一个个小数组
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public int[] getNewArr(int[] arr, int start, int end) {
        int[] newArr = new int[end - start + 1];
        for (int i = start, j = 0; i <= end; i++, j++) {
            newArr[j] = arr[i];
        }
        return newArr;
    }

    public static void main(String args[]) {
        Merge merge = new Merge();
        int[] result = merge.sort(merge.number);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(",");
        }
        System.out.println(sb.toString());
    }
}
