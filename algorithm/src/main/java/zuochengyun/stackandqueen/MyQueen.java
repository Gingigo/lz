package zuochengyun.stackandqueen;

import java.util.Stack;

/**
 * @author Leexiaobu
 * @date 2021-06-07 13:47
 */
public class MyQueen {

  public Stack<Integer> stackPush;
  public Stack<Integer> stackPop;

  public MyQueen() {
    this.stackPop = new Stack<>();
    this.stackPush = new Stack<>();
  }

  void put(int value) {
    this.stackPush.push(value);
  }

  int poll() {
    if (this.stackPush.isEmpty() && this.stackPop.isEmpty()) {
      throw new RuntimeException("queen is empty");
    } else if (!stackPush.isEmpty()) {
      stackPop.push(stackPush.pop());
    }
    return stackPop.pop();
  }


  int peek() {
    if (this.stackPush.isEmpty() && this.stackPop.isEmpty()) {
      throw new RuntimeException("queen is empty");
    } else if (!stackPush.isEmpty()) {
      stackPop.push(stackPush.pop());
    }
    return stackPop.peek();
  }
}