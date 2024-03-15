package string;

/**
 * 假定一段路径记作字符串 path，其中以 "." 作为分隔符。
 * 现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。
 */
public class offer122 {

    public String pathEncryption(String path) {

        char[] charArray = path.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '.'){
                charArray[i] = ' ';
            }
        }
        return String.valueOf(charArray);

    }
}
