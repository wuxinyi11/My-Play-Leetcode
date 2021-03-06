package T206ReverseLinkedList;

/**
 * @auther: snake
 * @date: 2020/2/17 17:33
 */

// 206. 反转链表
// https://leetcode-cn.com/problems/reverse-linked-list/
// 时间复杂度: O(n)
// 空间复杂度: O(n) - 注意，递归是占用空间的，占用空间的大小和递归深度成正比：）
public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        // 递归终止条件
        if (head == null || head.next == null)
            return head;

        ListNode rhead = reverseList(head.next);

        // head->next此刻指向head后面链表的尾结点
        // head->next->next = head把head节点放在了尾部
        head.next.next = head;
        head.next = null;

        return rhead;
    }


}
