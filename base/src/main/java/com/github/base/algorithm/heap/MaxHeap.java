package com.github.base.algorithm.heap;

/**
 * Created By Seven.wk
 * Description: 最大堆
 * Created At 2019/01/20
 */
public class MaxHeap<Item extends Comparable> {

    private Item[] data;

    private int count;

    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
    }

    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MaxHeap(Item arr[]) {

        int n = arr.length;

        data = (Item[]) new Comparable[n + 1];

        for (int i = 0; i < n; i++)
            data[i + 1] = arr[i];
        count = n;

        for (int i = count / 2; i >= 1; i--)
            shiftDown(i);
    }

    /**
     * 返回堆中元素个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 判断堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 向堆中插入一个元素
     *
     * @param item
     */
    public void insert(Item item) {
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    /**
     * 移除堆顶元素（堆中最大元素）
     *
     * @return
     */
    public Item extractMax() {
        Item ret = data[1];
        swap(1, count--);
        shiftDown(1);
        return ret;
    }

    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            // 找到两个子节点中值最大的那个子节点
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }

            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    /**
     * 交换函数
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++)
            maxHeap.insert((int) (Math.random() * M));

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
