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
