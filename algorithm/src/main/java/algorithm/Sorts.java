package algorithm;

/**
 * 排序方式总结
 *
 * @author Leexiaobu
 * @date 2020-09-03 10:40:51
 */
public class Sorts {

  public static void main(String[] args) {
    int[] array = {1, 5, 2, 3, 8, 8, 0, 0, 2, 15, 13, 24, 12, 32};
    int[] ans = new Sorts().topK(array);
    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + " ");
    }
    System.out.println();
    ans = new Sorts().heapSort(array);
    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + " ");
    }
  }

  /**
   * @description 冒泡排序 依次比较 当前数和下一个数 大的交换，执行n次
   * @author Leexiaobu 2020/09/03 10:58:39
   * @version 1.0
   */
  int[] bubbleSort(int[] array) {
    int temp = 0;
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          swapArray(array, j, j + 1);
//                    temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
        }
      }
    }
    return array;
  }

  /**
   * @description 选择排序 选出最小的放在最左边
   * @author Leexiaobu 2020/09/03 10:51:11
   * @version 1.0
   */
  int[] selectSort(int[] array) {
    int temp = 0;
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] > array[j]) {
          swapArray(array, i, j);
//                    temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
        }
      }
    }
    return array;
  }

  /**
   * @description 插入排序 拿出当前值，比较值一直向后换，直到排序
   * @author Leexiaobu 2020/09/03 11:02:06
   * @version 1.0
   */
  int[] insertSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int j = i;
      int temp = array[i];
      while (j > 0 && temp < array[j - 1]) {
        array[j] = array[j - 1];
        j--;
      }
      array[j] = temp;
    }
    return array;
  }

  /**
   * @description 希尔排序 分成n个分组进行插入排序 执行length/n 次
   * @author Leexiaobu  11:25:44
   * @version 1.0
   */
  int[] shellSort(int[] array) {
    for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
      for (int i = gap; i < array.length; i++) {
        int temp = array[i];
        int j = i;
        while (j - gap >= 0 && temp < array[j - gap]) {
          array[j] = array[j - gap];
          j = j - gap;
        }
        array[j] = temp;
      }
    }
    return array;
  }

  /**
   * @description 快速排序 拿最左为基准 右找一个  左找一个 交换
   * @author Leexiaobu 2020/09/03 16:21:36
   * @version 1.0
   */
  int[] quickSort(int[] array) {
    quickSortHelper(array, 0, array.length - 1);
    return array;
  }

  void quickSortHelper(int[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    int temp = array[start];
    int left = start;
    int right = end;
    while (left < right) {
      while (array[right] > temp && right > left) {
        right--;
      }
      if (right == left) {
        break;
      }
      while (array[left] <= temp && left < right) {
        left++;
      }
      if (right == left) {
        break;
      }
      swapArray(array, left, right);
//            int temp1 = array[left];
//            array[left] = array[right];
//            array[right] = temp1;
    }
    array[start] = array[left];
    array[left] = temp;
    quickSortHelper(array, start, left - 1);
    quickSortHelper(array, left + 1, end);
  }

  /**
   * @description 计数排序
   * @author Leexiaobu 2020/09/03 19:45:34
   * @version 1.0
   */
  int[] countSort(int[] array) {
    int k = 10;
    int[] ints = new int[k];
    for (int i = 0; i < array.length; i++) {
      ints[array[i]] += 1;
    }
    for (int i = 0, j = 0; i < ints.length && j <= array.length - 1; ) {
      if (ints[i] > 0) {
        ints[i] = ints[i] - 1;
        array[j] = i;
        j++;
      } else {
        i++;
      }
    }
    return array;
  }

  /**
   * @description 归并排序
   * @author Leexiaobu 2020/09/03 19:46:31
   * @version 1.0
   */
  int[] mergeSort(int[] array) {
    mergeSortHelper(array, 0, array.length - 1, new int[array.length]);
    return array;
  }

  /**
   * @description 先分在合
   * @author Leexiaobu 2020/09/04 12:43:23
   * @version 1.0
   */
  void mergeSortHelper(int[] array, int left, int right, int[] temp) {
    if (left >= right) {
      return;
    }
    int mid = (left + right) / 2;
    mergeSortHelper(array, left, mid, temp);
    mergeSortHelper(array, mid + 1, right, temp);
    mergeArrays(array, left, mid, right, temp);
  }

  void mergeArrays(int[] array, int start, int mid, int end, int[] temp) {
    int left = start;
    int right = mid + 1;
    int i = 0;
    for (; left <= mid && right <= end; i++) {
      if (array[left] < array[right]) {
        temp[start + i] = array[left];
        left++;
      } else {
        temp[start + i] = array[right];
        right++;
      }
    }
    for (; left <= mid; i++) {
      temp[start + i] = array[left];
      left++;
    }
    for (; right <= end; i++) {
      temp[start + i] = array[right];
      right++;
    }
    for (int j = start; j <= end; j++) {
      array[j] = temp[j];
    }
  }


  /**
   * @description 堆排序 创建最小堆 拿到最小数
   * @author Leexiaobu 2020/09/03 19:47:46
   * @version 1.0
   */
  int[] heapSort(int[] array) {
    int[] minHeap = createMinHeap(array);
    for (int i = 0; i < array.length; i++) {
      array[i] = heapPop(minHeap, minHeap.length - 1 - i);
    }
    return array;
  }

  int[] topK(int[] array) {
    int size = 10;
    int[] heap = createMaxHeapK(array, size);
    //遍历数组
    for (int i = size; i < array.length; i++) {
      if (array[i] < heap[0]) {
        heap[0] = array[i];
        heapify(heap, heap.length, 0);
      }
    }
    int[] sort = sortHeap(heap);
    return sort;
  }

  int[] createMaxHeapK(int[] array, int k) {
    int[] ans = new int[k];
    //维护一个k大小的大顶堆
    for (int i = 0; i < k; i++) {
      ans[i] = array[i];
    }
    for (int i = ans.length - 1; i > 0; i--) {
      heapify(ans, ans.length , (i-1)/2);
    }
    return ans;
  }

  public void heapify(int[] heap, int length, int parentIndex) {
    if (parentIndex >= length) {
      return;
    }
    int child1 = 2 * parentIndex + 1;
    int child2 = 2 * parentIndex + 2;
    int max = parentIndex;
    if (child1 < length && heap[child1] > heap[max]) {
      max = child1;
    }
    if (child2 < length && heap[child2] > heap[max]) {
      max = child2;
    }
    if (max != parentIndex) {
      swapArray(heap, max, parentIndex);
      heapify(heap, length, max);
    }
  }

  public int[] sortHeap(int[] array) {
    int[] ans = new int[array.length];
    for (int i = array.length - 1; i > 0; i--) {
      swapArray(array, i, 0);
      heapify(array, i, 0);
      ans[i] = array[i];
    }
    return ans;
  }


  /**
   * @description 创建最小堆 从 index【1】插入，新插入的index【n】和index【n/2】对比,在看是否交换
   * @author Leexiaobu 2020/09/04 11:20:38
   * @version 1.0
   */
  int[] createMinHeap(int[] array) {
    int[] ans = new int[array.length + 1];
    for (int i = 0; i < array.length; i++) {
      int current = array[i];
      ans[i + 1] = current;
      int index = i + 1;
      while (index > 1 && ans[index] < ans[index / 2]) {
        swapArray(ans, index, index / 2);
        index = index / 2;
      }
    }
    return ans;
  }


  /**
   * @description 拿到最小数 获取index【1】,然后将末尾的数放到index【1】,在和子节点比较，看是否要交换
   * @author Leexiaobu 2020/09/04 11:22:44
   * @version 1.0
   */
  int heapPop(int[] array, int lastIndex) {
    int result = array[1];
    array[1] = array[lastIndex];
    int temp = 1;
    while (temp * 2 <= lastIndex) {
      int childIndex = 2 * temp;
      if (temp * 2 + 1 <= lastIndex) {
        childIndex = array[2 * temp] < array[2 * temp + 1] ? 2 * temp : 2 * temp + 1;
      }
      if (array[temp] > array[childIndex]) {
        swapArray(array, temp, childIndex);
        temp = childIndex;
      } else {
        break;
      }
    }
    return result;
  }


  /**
   * @description 桶排序
   * @author Leexiaobu 2020/09/03 19:47:58
   * @version 1.0
   */
  int[] bucketSort(int[] array) {
    // ToDo-Lee:2020/09/03
    return array;
  }

  /**
   * @description 基数排序
   * @author Leexiaobu 2020/09/03 19:49:18
   * @version 1.0
   */
  int[] radixSort(int[] array) {
    // ToDo-Lee:2020/09/03
    return array;
  }


  void swapArray(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
