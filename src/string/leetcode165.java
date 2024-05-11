package string;

public class leetcode165 {
    public static void main(String[] args) {
        System.out.println(new leetcode165().compareVersion("1.2", "1.10"));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        //忽略前置 0
        for (int i = 0; i < v1.length; i++) {
            if (v1[i].startsWith("0")) {
                v1[i] = removePrefixZero(v1[i]);
            }
        }
        for (int i = 0; i < v2.length; i++) {
            if (v2[i].startsWith("0")) {
                v2[i] = removePrefixZero(v2[i]);
            }
        }
        int lenght = Math.max(v1.length, v2.length);
        for (int i = 0; i < lenght; i++) {
            if (i >= v1.length){
                if (Integer.parseInt(v2[i]) != 0) {
                    return -1;
                }
                continue;
            }
            if (i >= v2.length){
                if (Integer.parseInt(v1[i]) != 0) {
                    return 1;
                }
                continue;
            }
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                return 1;
            } else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                return -1;
            }
        }

        return 0;
    }

    public String removePrefixZero(String s) {
        int index = 0;
        while (index < s.length() - 1 && s.charAt(index) == '0') {
            index++;
        }
        return s.substring(index);
    }
}
