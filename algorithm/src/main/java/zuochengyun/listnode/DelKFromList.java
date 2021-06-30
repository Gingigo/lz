package zuochengyun.listnode;

/**
 * @author Leexiaobu
 * @date 2021-06-07 15:10
 */
public class DelKFromList {

  public Node delete(int k, Node head) {
    Node temp = head;
    Node nBefore = head;
    Node node = head;
    for (int i = 0; i < k; i++) {
      temp = temp.next;
    }
    if (temp == null) {
      return head.next;
    } else {
      temp = temp.next;
      nBefore = nBefore.next;
    }
    while (temp != null) {
      temp = temp.next;
      nBefore = nBefore.next;
      node = node.next;
    }
    node.next = nBefore.next;
    return head;


  }
}