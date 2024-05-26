package string;

public class leetcode151 {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].length() == 0){
                continue;
            }
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
