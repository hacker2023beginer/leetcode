package gpt.leetcode.mergeTwoLists;

import java.util.*;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
