package guava;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class GuavaTest {

    /**
     * Joiner，Splitter: 把集合通过指定的分隔符拼接成字符串；通过指定的分隔符把字符串转为集合
     */
    @Test
    public void testJoinerSplitter() {
        // Joiner: 把集合通过指定的分隔符拼接成字符串
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(null);
        Joiner joiner = Joiner.on(",")
                // 忽略null，否则遇null会报错
                .skipNulls();
        System.out.println(joiner.join(list)); // a,b,c

        // 使用jdk8 stream实现也比较方便
        System.out.println(list.stream().filter(StringUtils::isNoneBlank)
                .collect(Collectors.joining(","))); // a,b,c

        // Splitter: 通过指定的分隔符把字符串转为集合
        String str = "a,b,, c,";
        Splitter splitter = Splitter.on(",")
                // 过滤掉空白占位符(不包括"")
                .omitEmptyStrings()
                // trim每个元素前后空格
                .trimResults();
        // split
        Iterable<String> iterable = splitter.split(str);
        System.out.println(iterable); // [a, b, c]
        // splitToList
        List<String> splitToList = splitter.splitToList(str);
        System.out.println(splitToList); // [a, b, c]
    }

    /**
     * 下划线和驼峰互转
     */
    @Test
    public void testCaseFormat() {
        String str = "student_name";
        // 下划线转驼峰
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str)); // studentName
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str)); // StudentName

        // 驼峰转下划线
        str = "studentName";
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str)); // student_name
    }

    /**
     * Lists用法，另有Sets、Maps
     */
    @Test
    public void testLists() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        // newArrayList 提供集合的快速创建方式
        List<String> list2 = Lists.newArrayList("a", "b", "c");

        // partition 按最大size将list分成小的集合（场景：接口调用）
        List<List<String>> partition =  Lists.partition(list2, 2);
        System.out.println(partition); // [[a, b], [c]]
    }

    /**
     * Ints用法，另有Longs,Floats等
     */
    @Test
    public void testInts() {
        List<Integer> integers = Ints.asList(1, 2, 3);
        System.out.println(integers); // [1, 2, 3]
    }

    /**
     * Multiset, 比如HashMultiset实现类
     */
    @Test
    public void testMultiset() {
        // list: 元素可重复的有序集合; set: 元素不可重复的无序集合
        // Multiset 元素可重复的无序集合
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("a");
        System.out.println(multiset);  // [a x 2, b, c]
        System.out.println(multiset.entrySet());   // [a x 2, b, c]
        System.out.println(multiset.elementSet()); // [a, b, c]

        // 遍历
        Set<Multiset.Entry<String>> entries = multiset.entrySet();
        for (Multiset.Entry<String> entry : entries) {
            System.out.println("元素: " + entry.getElement() + ", 个数: " + entry.getCount());
        }
    }

    /**
     * Multimap, 比如HashMultimap实现类
     * 用来替换jdk原生的Map<String, Collection<String> map;
     */
    @Test
    public void testMultimap() {
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("a", "1");
        multimap.put("a", "2");
        multimap.put("a", "3");
        // get返回一个Collection集合
        Collection<String> aValues = multimap.get("a");
        System.out.println(aValues); // [1, 2, 3]
        // contains
        System.out.println(multimap.containsEntry("a", "1")); // true
        System.out.println(multimap.containsEntry("a", "4")); // false
        // 转成jdk原生集合
        Map<String, Collection<String>> jdkMap = multimap.asMap();
        System.out.println(jdkMap); // {a=[1, 2, 3]}
    }
}
