package hashTable;

import java.util.HashMap;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */

public class leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        //利用hashMap保存magazine中每个字符的出现次数
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i),0) + 1);
        }

        //再遍历ransomNote，判断每个字符是否在magazine中出现，以及是否出现次数大于等于ransomNote中对应字符的出现次数
        for (int i = 0; i < ransomNote.length(); i++){
            if (map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i)) > 0){
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            }else {
                return false;
            }
        }
        return true;
    }

    //法二：改map为数组
    public boolean way02(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }

        return true;
    }
}
