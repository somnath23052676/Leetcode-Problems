class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> student = new LinkedList<>() ;
        Queue<Integer> sandwich = new LinkedList<>() ;

        for (int i = 0 ; i < students.length ; i++) {
            student.add(students[i]) ;
            sandwich.add(sandwiches[i]) ;
        }
        int left = 0 ;

        while (!student.isEmpty() && left < students.length) {
            if (student.peek().equals(sandwich.peek())) {
                student.poll() ;
                sandwich.poll() ;
                left = 0 ;
            } else {
                int temp1 = student.peek() ;
                student.poll() ;

                student.add(temp1) ;

                left++ ;
            }
        }

        return student.size() ;
        
    }
}
