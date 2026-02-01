# Number of Students Unable to Eat Lunch

## Problem Description
This problem simulates a queue of students and a stack of sandwiches.
Each student has a preference (0 = circular, 1 = square).
If the front student's preference matches the top sandwich, they eat and leave.
Otherwise, they move to the end of the queue.

The process stops when no student wants the top sandwich.

## Approach
I solved this problem using:
- Queue data structure for students
- Queue data structure for sandwiches
- FIFO principle
- Rotation counter to detect when no one can eat

### Key Idea
If a student does not like the sandwich:
- Move them to the back of the queue
- Increase a counter

If a student eats:
- Remove both student and sandwich
- Reset counter to 0

When the counter equals the queue size, it means no student wants the sandwich.

## Time Complexity
O(n²) in worst case due to rotations.

## Space Complexity
O(n) for queues.
