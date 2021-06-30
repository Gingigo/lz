package zuochengyun.stackandqueen;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Leexiaobu
 * @date 2021-06-07 13:19
 */
public class GetMin {

  Stack<Integer> stack;
  Stack<Integer> minStack;

  public GetMin() {
    this.stack = new Stack<>();
    this.minStack = new Stack<>();
  }

  void push(Integer value) {
    if (minStack.isEmpty()) {
      minStack.push(value);
    } else if (minStack.peek() >= value) {
      minStack.push(value);
    }
    stack.push(value);
  }

  Integer pop() {
    if (minStack.isEmpty()) {
      throw new RuntimeException("stack is empty");
    }
    int pop = minStack.pop();
    if (minStack.peek() == pop) {
      minStack.pop();
    }
    return pop;
  }

  Integer getMin() {
    if (minStack.isEmpty()) {
      throw new RuntimeException("stack is empty");
    }
    return minStack.peek();
  }

  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < nums.length; i++) {
      nums[(nums[i] - 1) % n] += n;
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= n) {
        res.add(i + 1);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    GetMin getMin = new GetMin();
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
    getMin.findDisappearedNumbers(nums);
  }
}
