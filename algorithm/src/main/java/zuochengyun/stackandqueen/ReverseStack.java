package zuochengyun.stackandqueen;

import java.util.Stack;

/**
 * @author Leexiaobu
 * @date 2021-06-07 13:56
 */
public class ReverseStack {

  public static void reverse(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return;
    }
    int last = getLast(stack);
    reverse(stack);
    stack.push(last);
  }

  static int getLast(Stack<Integer> stack) {
    int result = stack.pop();
    if (stack.isEmpty()) {
      return result;
    } else {
      int last = getLast(stack);
      stack.push(result);
      return last;
    }

  }


  public static void main(String[] args) {
    Stack<Integer> integers = new Stack<>();
    for (int i = 0; i < 5; i++) {
      integers.push(i);
    }
    reverse(integers);
    while (!integers.isEmpty()){
      System.out.println(integers.pop());
    }
  }
}