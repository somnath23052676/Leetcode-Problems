# 83. Remove Duplicates from Sorted List

![LeetCode](https://img.shields.io/badge/LeetCode-83-orange?style=flat-square&logo=leetcode) ![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=flat-square) ![Topic](https://img.shields.io/badge/Topic-LinkedList-blue?style=flat-square) ![Language](https://img.shields.io/badge/Language-Java-red?style=flat-square)

## Problem

Given the `head` of a **sorted** linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

---

## Examples

**Example 1:**
```
Input:  [1, 1, 2]
Output: [1, 2]
```

**Example 2:**
```
Input:  [1, 1, 2, 3, 3]
Output: [1, 2, 3]
```

---

## Constraints

- Number of nodes: `[0, 300]`
- `-100 <= Node.val <= 100`
- List is guaranteed to be in **ascending sorted order**

---

## Approach — Single Pass Traversal

Since the list is already sorted, all duplicates are always **adjacent**. A single pass with one pointer is enough.

**Key Insight:**
- If `temp.next.val == temp.val` → duplicate found, skip `temp.next` by doing `temp.next = temp.next.next`
- If no duplicate → advance `temp = temp.next`
- Only move forward when **no deletion** happened, so the new `temp.next` gets re-checked against `temp.val`

**Visualization:**
```
[1] -> [1] -> [2] -> null
 ^
temp: temp.next.val == temp.val → delete

[1] -> [2] -> null
 ^
temp: temp.next.val != temp.val → advance

[1] -> [2] -> null
        ^
temp.next == null → stop

Output: [1, 2] ✓
```

---

## Solution

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;   // skip duplicate
            } else {
                temp = temp.next;             // move forward only when no deletion
            }
        }
        return head;
    }
}
```

---

## Complexity

| | Complexity |
|---|---|
| **Time** | `O(n)` — single pass through the list |
| **Space** | `O(1)` — no extra data structures used |

---

## Common Mistakes

- ❌ **Advancing `temp` after every iteration** — causes infinite loop when a duplicate is deleted, since the new `temp.next` never gets checked
- ❌ **Missing null check on `head`** — throws `NullPointerException` on empty list input
