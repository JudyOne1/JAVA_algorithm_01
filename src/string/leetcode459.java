package string;

public class leetcode459 {
    public boolean repeatedSubstringPattern(String s) {
        //判断字符串s是否由重复子串组成，只要两个s拼接在一起
        //里面还出现一个s的话，就说明是由重复子串组成。
        String t = s + s;
        t = t.substring(1, t.length() - 1); // 掐头去尾，避免在s+s中搜索出原来的s，我们要搜索的是中间拼接出来的s
        if (t.contains(s)) return true; // 检查是否存在子字符串
        return false;

//        //要不就是奇数个重复构成，要不就是偶数个重复构成
//        if (s.length() == 0 || s.length() == 1)
//            return false;
//
//        //偶数个的话直接对半拆开，看看是不是相同的字符串 abcd ab|cd abcd
//        String s1 = s.substring(0, s.length() / 2);
//        String s2 = s.substring(s.length() / 2, s.length());
//        if (s1.equals(s2))
//            return true;
//        //奇数个的话，再加上一份自己，取中间的，看看能不能和s匹配
//        String ss = s + s;
//        String ssFirst = ss.substring(0, ss.length() / 3);
//
//        String ssMid = ss.substring(ss.length() / 3, ss.length() / 3 * 2);
//        if (ssFirst.equals(ssMid))
//            return true;
//
//        return false;


    }
}
