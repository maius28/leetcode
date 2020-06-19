//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


package leetcode.editor.cn;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode itr1 = l1;
            ListNode itr2 = l2;

            ListNode head = new ListNode(0);
            ListNode itr3 = head;
            int carry = 0;
            while (itr1 != null && itr2 != null) {
                itr3.next = new ListNode(0);
                itr3 = itr3.next;

                int sum = itr1.val + itr2.val + carry;
                carry = sum / 10;
                itr3.val = sum % 10;
                itr1 = itr1.next;
                itr2 = itr2.next;
            }

            ListNode rest = itr1 == null ? itr2 : itr1;

            while (rest != null) {
                itr3.next = new ListNode(0);
                itr3 = itr3.next;
                int sum = rest.val + carry;
                carry = sum / 10;
                itr3.val = sum % 10;
                rest = rest.next;
            }

            //注意：这里最后要考虑进位的问题
            if (carry == 0) {
                return head.next;
            } else {
                itr3.next = new ListNode(carry);
                return head.next;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}