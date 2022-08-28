package apache.lang3;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

public class NumberUtilsTest {

    /**
     * 判断是否是数字
     * isDigits 只能判断整数
     * isParsable 可以判断整数、浮点数，不能识别正负
     * isCreatable 可以整数、浮点数、识别正负以及进制
     */
    @Test
    public void testDigits() {
        String str = "12.3aaa";
        System.out.println(NumberUtils.isDigits(str)); // false
        System.out.println(NumberUtils.isParsable(str));// false
        System.out.println(NumberUtils.isCreatable(str));// false
        str = "12.3";
        System.out.println(NumberUtils.isDigits(str)); // false
        System.out.println(NumberUtils.isParsable(str)); // true
        System.out.println(NumberUtils.isCreatable(str)); // true
        str = "+12.3";
        System.out.println(NumberUtils.isDigits(str)); // false
        System.out.println(NumberUtils.isParsable(str)); // false
        System.out.println(NumberUtils.isCreatable(str)); // true
        str = "12";
        System.out.println(NumberUtils.isDigits(str)); // true
        System.out.println(NumberUtils.isParsable(str));// true
        System.out.println(NumberUtils.isCreatable(str));// true
    }

    /**
     * 通过字符串创建数值类型
     */
    @Test
    public void testCreateInteger() {
        String str = "123";
        System.out.println(NumberUtils.createInteger(str)); // 123
        System.out.println(NumberUtils.createDouble(str)); // 123.0
        System.out.println(NumberUtils.createLong(str)); // 123
    }

    @Test
    public void testMinMax() {
        System.out.println(NumberUtils.min(1, 4, 3, 2)); // 1
        System.out.println(NumberUtils.max(1, 4, 3, 2)); // 4
    }
}
