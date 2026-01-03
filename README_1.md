# Build Array With Stack Operations

## Problem
Given an increasing array `target` and an integer `n`, build the `target` array using stack operations on numbers from `1` to `n`.

Allowed operations:
- `Push` → add the next number
- `Pop` → remove the last pushed number

Return the list of operations needed to build `target`.

---

## Approach
- Traverse the `target` array.
- If there is a gap between consecutive numbers, perform `Push` and `Pop` for the extra numbers.
- Perform `Push` for each required target number.
- This simulates reading numbers from `1` to `n` in order.

---

## Example Test Cases

### Test Case 1
**Input**
target = [1, 3]
n = 3
**Output**
["Push","Push","Pop","Push"]

### Test Case 2
**Input**
target = [1, 2, 3]
n = 3
**Output**
["Push","Push","Push"]
### Test Case 3
**Input**
target = [1, 2]
n = 4
**Output**
["Push","Push"]

---

## Complexity
- Time Complexity: `O(n)`
- Space Complexity: `O(n)`
- Runtime: `0 ms`

---

## Language Used
- Java
