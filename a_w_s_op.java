class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>() ;

        if (target[0] != 1) {
            int difference = target[0] - 1 ;
            for (int i = 0 ; i < difference ; i++) {
                list.add("Push") ;
                list.add("Pop") ;
            }
            list.add("Push") ;
        } else {
            list.add("Push") ;
        }

        for (int i = 1 ; i < target.length ; i++) {
            int difference = target[i] - target[i-1] ;
            if (difference == 1) {
                list.add("Push") ;
            }else {
                for (int j = 1 ; j < difference ; j++) {
                    list.add("Push") ;
                    list.add("Pop") ;
                }
                list.add("Push") ;
            }
        }

        return list ;
         
    }
}
