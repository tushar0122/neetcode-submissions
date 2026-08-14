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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        var t1 = list1;
        ListNode prevt1 = null;
        var t2 = list2;
        while(t1!=null&&t2!=null){
            if(t1.val<t2.val){
                prevt1 = t1;
                t1 = t1.next;
            }
            else{
                var next = t2.next;
                t2.next = t1;
                if(prevt1!=null){
                    prevt1.next = t2; 
                }
                prevt1 = t2;
                t2 = next;
            }
        }
        while(t2!=null){
            var next = t2.next;
            t2.next = t1;
            prevt1.next = t2; 
            prevt1 = t2;
            t2 = next;
        }
        if(list1.val<list2.val){
            return list1;
        }
        return list2;
    }
}