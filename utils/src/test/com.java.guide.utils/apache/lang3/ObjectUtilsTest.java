package apache.lang3;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

public class ObjectUtilsTest {

    @Test
    public void testIdentityToString() {
        // identityToString 获取对象的类名@HashCode, 为 null 时返回 null
        System.out.println(ObjectUtils.identityToString("abc")); // java.lang.String@41975e01
        System.out.println(ObjectUtils.identityToString(null));  // null
    }

    @Test
    public void testFirstNonNull() {
        String str1 = null;
        String str2 = null;
        String str3 = "123";
        // firstNonNull 取第一个不为空的作为结果
        System.out.println(ObjectUtils.firstNonNull(str1, str2, str3));
    }
}
