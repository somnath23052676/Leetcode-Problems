/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>() ;
        if (head == null) return null ;
        ListNode temp = head ;

        while (temp != null) {
            list.add(temp.val) ;
            temp = temp.next ;
        }

        ListNode newLink = new ListNode(list.get(list.size() - 1)) ;
        ListNode curr = newLink ;

        for (int i =list.size() - 2; i >=0 ; i--) {
            curr.next = new ListNode(list.get(i)) ;
            curr = curr.next ;
        }

        return newLink ;

        
    }
}
