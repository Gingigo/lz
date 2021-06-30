package zuochengyun.listnode;

/**
 * @author Leexiaobu
 * @date 2021-06-07 15:07
 */
public class PrintCommonPart {

  public void printCommonPart(Node node1, Node node2) {
    while (node1 != null && node2 != null) {
      if (node1.value == node2.value) {
        System.out.println(node1.value);
        node1 = node1.next;
        node2 = node2.next;
      } else if (node1.value < node2.value) {
        node1 = node1.next;
      } else {
        node2 = node2.next;
      }
    }
  }
}