package string;

/**
 * 设定一个正整数目标值 target
 * 将 password 前 target 个字符按原顺序移动至字符串末尾
 */
public class offer182 {

    /**
     * 动态密码生成函数
     * 根据给定的原始密码和目标位置，将原始密码的字符按照目标位置进行截取和拼接，生成新的密码。
     *
     * @param password 原始密码，类型为String
     * @param target 目标位置，整数类型。该位置左侧的字符将被拼接到该位置右侧的字符之后，生成新的密码。
     * @return 返回生成的新密码，类型为String。
     */
    public String dynamicPassword(String password, int target) {
        int len = password.length(); // 获取原始密码的长度
        char[] charArray = password.toCharArray(); // 将原始密码转换为字符数组，便于处理

        StringBuilder stringBuilder = new StringBuilder();
        int start = target;
        // 从目标位置开始，将字符依次添加到StringBuilder中
        while (start < len) {
            stringBuilder.append(charArray[start]);
            start++;
        }
        start = 0;
        // 从密码的开始位置到目标位置，将字符依次添加到StringBuilder中
        while (start < target) {
            stringBuilder.append(charArray[start]);
            start++;
        }
        return stringBuilder.toString(); // 将StringBuilder转换为String并返回
    }

    /**
     *         String str = password.substring(target);
     *         str += password.substring(0,target);
     *         return str;
     */
}
