package apache.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilsTest {

    /**
     * 判空
     */
    @Test
    public void testEmpty() {
        String str = " ";
        // isEmpty：包含是null值和空串("")，不包含空白符
        System.out.println(StringUtils.isEmpty(str)); // false
        // isBlank：判断更严谨，包含null值、空串("")、空白符(" "，制表符”\t"，回车符"\r"，"\n"等)
        System.out.println(StringUtils.isBlank(str)); // true
    }

    /**
     * 大小写转换
     */
    @Test
    public void testCapitalize() {
        String str = "update";
        // 首字母大写
        System.out.println(StringUtils.capitalize(str)); // Update
        str = "Update";
        // 首字母小写
        System.out.println(StringUtils.uncapitalize(str)); // update

        // 全部大写：upperCase
        // 全部小写：lowerCase
        // 大小写互换：swapCase
    }

    /**
     * 去除空白符、特定字符
     */
    @Test
    public void testDeleteWhitespace() {
        String str = "abc d ef";
        // deleteWhitespace 去除字符串中所有的空白符
        System.out.println(StringUtils.deleteWhitespace(str)); //abcdef

        str = " abc d ef  ";
        // trim 去除前后空格
        System.out.println(StringUtils.trim(str)); //abc d ef

        // trimToEmpty、trimToNull 在trim基础上进行返回值的扩展，可参考源码
        // trimToEmpty: 如果 isEmpty 则返回""
        // trimToNull:  如果 isEmpty 则返回null

        // strip 去掉前后面匹配的符号，应用广泛
        str = "[abdf]";
        System.out.println(StringUtils.strip(str, "[]"));    //abdf
    }

    /**
     * 替换
     */
    @Test
    public void testReplace() {
        String str = "sshhhss";
        // replaceOnce 只替换一次
        System.out.println(StringUtils.replaceOnce(str, "ss", "p")); // phhhss
        // replace 全部替换
        System.out.println(StringUtils.replace(str, "ss", "p")); // phhhp
        // replaceChars 替换所有字符，区别于replace
        System.out.println(StringUtils.replaceChars(str, "ss", "p")); // pphhhpp
    }

    /**
     * 反转
     */
    @Test
    public void testReverse() {
        String str = "abcdef";
        // reverse 直接反转
        System.out.println(StringUtils.reverse(str)); // fedcba
        // reverseDelimited 根据分隔符进行反转
        str = "a.b.c.de.f";
        System.out.println(StringUtils.reverseDelimited(str, '.')); // f.de.c.b.a
    }
}
