package org.zhouwei.algorithm.sort;

/**
 * 堆排序
 *
 *                    1
 *              2           3
 *           4     5     6     7
 *         8  9  10 11 12 13 14 15
 *
 * 1.从上面可以看出，一个数组的index,每个数字表示数组的下标，二不需要构建特殊的数据结构
 * 2.然后开始构建最大顶或者最小定的数据结构
 * 3.父节点[i]的左子节点为[2i]，右节点为[2i + 1]，完全二叉树
 * 4.计算父节点，如果index % 2 = 0，则父节点为i / 2，否则为(i - 1) / 2，如果 i == 1，则为跟节点
 *
 *
 * @author zhouwei
 */
public class Heap {

    public int[] number = new int[]{50,10,70,20,55,13,71,99,123,31,45,91,82,50,20,61,78,93};

    public void compare(int index) {
        if (index == 1) {//当index等于1的时候，为根节点，需要退出
            return;
        }
        for (int i = index; i > 1; i--) {//i需要大于等于1，不到root节点，必须退出
            int indexFather;
            if (i % 2 == 0) {//除尽，父节点为 i / 2
                indexFather = i / 2;
            } else {//除不尽，父节点为 (i - 1)/ 2
                indexFather = (i - 1) / 2;
            }
            if (number[i - 1] > number[indexFather - 1]) {//如果叶子节点大于父节点，则交换
                swap(i, indexFather);
            }
        }
    }

    public void sort() {
        for (int i = number.length; i > 0; i--) {
            compare(i);
            swap(i,1);//每次排序结束后，需要将root交换这个i这个index
        }
    }

    public void swap(int oldi, int newi) {
        int tmp = number[oldi - 1];
        number[oldi - 1] = number[newi - 1];
        number[newi - 1] = tmp;
    }

    public static void main(String args[]) {
        Heap heap = new Heap();
        heap.sort();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < heap.number.length; i++) {
            sb.append(heap.number[i]).append(",");
        }
        System.out.println(sb.toString());
    }
}
