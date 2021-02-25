package leetcode.leetcode.editor.cn;
// ToDo-Lee

//leetcode submit region begin(Prohibit modification and deletion)
class _973_KClosestPointsToOrigin {
    public static void main(String[] args) {
        _973_KClosestPointsToOrigin kClosestPointsToOrigin = new _973_KClosestPointsToOrigin();
//        int[][] array = {{1, 3}, {-2, 2}};
        String s = "[[-95,76],[17,7],[-55,-58],[53,20],[-69,-8],[-57,87],[-2,-42],[-10,-87],[-36,-57],[97,-39],[97,49]]".replace("[", "{").replace("]", "}");
        System.out.println(s);
//        int[][] array = {{6, 10}, {-3, 3}, {-2, 5}, {0, 2}};
        int[][] array = {{-95, 76}, {17, 7}, {-55, -58}, {53, 20}, {-69, -8}, {-57, 87}, {-2, -42}, {-10, -87}, {-36, -57}, {97, -39}, {97, 49}};
        int[][] ints = kClosestPointsToOrigin.kClosest(array, 5);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i][0] + " " + ints[i][1] + " " + kClosestPointsToOrigin.getLength(ints, i));
        }
        System.out.println(1);
    }

    public int[][] kClosest(int[][] points, int K) {
        int[][] minHeap = createMinHeap(points);
//        for (int i = 0; i < minHeap.length; i++) {
//            System.out.println(i+":"+minHeap[i][0]+" "+minHeap[i][1]+" "+getLength(minHeap,i));
//        }
        System.out.println("========");
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] ints = deleteMinHeapNode(minHeap, minHeap.length - 1 - i);
            ans[i] = ints;
        }
        return ans;
    }


    int[][] createMinHeap(int[][] points) {
        int[][] temp = new int[points.length + 1][2];
        for (int i = 0; i < points.length; i++) {
            temp[i + 1] = points[i];
            int tempIndex = i + 1;
            while (tempIndex > 1) {
                int parentIndex = tempIndex / 2;
                int[] current = temp[tempIndex];
                int[] parent = temp[parentIndex];
                int currentLength = current[0] * current[0] + current[1] * current[1];
                int parentLength = parent[0] * parent[0] + parent[1] * parent[1];
                if (currentLength < parentLength) {
                    swap(temp, tempIndex, parentIndex);
                    tempIndex = parentIndex;
                } else {
                    break;
                }
            }
        }
        return temp;
    }

    int[] deleteMinHeapNode(int[][] heap, int lastIndex) {
        for (int i = 1; i < heap.length; i++) {
            System.out.println(i + ":" + heap[i][0] + " " + heap[i][1] + " " + getLength(heap, i));
        }
        int[] ans = heap[1];
        heap[1] = heap[lastIndex];
        int tempIndex = 1;
        while (tempIndex * 2 <= lastIndex) {
            int tempLength = getLength(heap, tempIndex);
            int childIndex = tempIndex * 2;
            int childLength = getLength(heap, childIndex);
            if (tempIndex * 2 + 1 <= lastIndex) {
                int childLength2 = getLength(heap, tempIndex * 2 + 1);
                if (childLength > childLength2) {
                    childIndex = childIndex + 1;
                    childLength = childLength2;
                }
            }
            if (childLength < tempLength) {
                swap(heap, childIndex, tempIndex);
                tempIndex = childIndex;
            } else {
                break;
            }
        }


        return ans;
    }

    int getLength(int[][] array, int index) {
        return array[index][0] * array[index][0] + array[index][1] * array[index][1];
    }

    void swap(int[][] array, int index1, int index2) {
        int[] temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。 
//
// （这里，平面上两点之间的距离是欧几里德距离。） 
//
// 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// Related Topics 堆 排序 分治算法 
// 👍 108 👎 0

