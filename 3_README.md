# 796. Rotate String

**Difficulty:** Easy  
**Topic Tags:** `String` `String Matching`

---

## Problem Statement

Given two strings `s` and `goal`, return `true` if and only if `s` can become `goal` after some number of **shifts** on `s`.

A **shift** on `s` consists of moving the leftmost character of `s` to the rightmost position.

> **Example:** if `s = "abcde"`, then it will be `"bcdea"` after one shift.

---

## Examples

**Example 1:**
```
Input:  s = "abcde", goal = "cdeab"
Output: true
```

**Example 2:**
```
Input:  s = "abcde", goal = "abced"
Output: false
```

---

## Approach — Brute Force (Rotation Simulation)

### Intuition

Simulate every possible rotation of `s` (there are exactly `n` distinct rotations for a string of length `n`) and check if any of them matches `goal`.

For each index `i`, a rotation splits `s` into two halves and swaps them:
- Left part: `s[0..i]`
- Right part: `s[i+1..n-1]`

The rotated string becomes: `s[i+1..n-1] + s[0..i]`

### Steps

1. If `s.length() != goal.length()`, return `false` immediately.
2. Iterate `i` from `0` to `n-1`.
3. At each step, construct the rotated string by appending `s[i+1:]` and `s[:i+1]`.
4. If the rotated string equals `goal`, return `true`.
5. If no rotation matches, return `false`.

---

## Solution (Java)

```java
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();

            sb.append(s.substring(i + 1, s.length()));
            sb.append(s.substring(0, i + 1));

            if (sb.toString().equals(goal)) {
                return true;
            }
        }

        return false;
    }
}
```

---

## Complexity Analysis

| | Complexity | Reason |
|---|---|---|
| **Time** | O(n²) | O(n) rotations × O(n) string comparison each |
| **Space** | O(n) | `StringBuilder` of size `n` created each iteration |

---

## Optimal Approach (For Reference)

A cleaner O(n) trick: **every rotation of `s` is a substring of `s + s`**.

So the problem reduces to checking if `goal` is a substring of the doubled string `s + s`.

```java
// One-liner optimal solution
return s.length() == goal.length() && (s + s).contains(goal);
```

> This works because concatenating `s` with itself generates all possible rotations as contiguous substrings.

---

## Key Takeaway

> When dealing with rotation problems, the **"double the string"** trick (`s + s`) is a powerful pattern worth remembering for interviews.
