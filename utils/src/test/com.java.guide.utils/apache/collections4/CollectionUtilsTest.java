package apache.collections4;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtilsTest {

    /**
     * list，set非空判断（null或size>0）
     */
    @Test
    public void testEmpty() {
        List<String> list = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(list)); // true
        // 非空
        System.out.println(CollectionUtils.isNotEmpty(list)); // false
    }

    /**
     * 交集、并集、差集
     */
    @Test
    public void testUnion() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("c");
        list2.add("1");
        list2.add("2");
        // intersection 取交集
        System.out.println(CollectionUtils.intersection(list1, list2));  // [c]
        // union 取并集
        System.out.println(CollectionUtils.union(list1, list2)); // [a, 1, b, 2, c]
        // subtract 取第一个与第二个的差集
        System.out.println(CollectionUtils.subtract(list1, list2)); // [a, b]
        System.out.println(CollectionUtils.subtract(list2, list1)); // [1, 2]
    }
}
