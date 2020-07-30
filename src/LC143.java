//字符串"PAYPALISHIRING"写成3行的Z字形的样式如下：
//P   A   H   N↵A P L S I I G↵Y   I   R
//按行读这个Z字形图案应该是 "PAHNAPLSIIGYIR"
//请编写代码完成将字符串转化为指定行数的Z字形字符串
public class LC143 {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 1) {
            return s;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i = i + 2 * nRows - 2) {
            stringBuffer.append(s.charAt(i));
        }
        int k = 1;
        for (int i = k; i < nRows - 1; i++) {
            for (int j = i; j < s.length(); j = j + 2 * nRows - 2) {
                stringBuffer.append(s.charAt(j));
                if (j + 2 * nRows - 2 - 2 * k < s.length()) {
                    stringBuffer.append(s.charAt(j + 2 * nRows - 2 - 2 * k));
                }
            }
            k++;
        }
        for (int i = nRows - 1; i < s.length(); i = i + 2 * nRows - 2) {
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }
}
