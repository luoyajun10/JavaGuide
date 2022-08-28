package apache.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtilsTest {

    /**
     * 数组判空
     */
    @Test
    public void testArrayEmpty() {
        int[] arr = new int[1];
        System.out.println(ArrayUtils.isEmpty(arr)); // false
        arr = new int[0];
        System.out.println(ArrayUtils.isEmpty(arr)); // true
    }
}
