package apache.collections4;

import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapUtilsTest {

    /**
     * map非空判断（null或size>0）
     */
    @Test
    public void testEmpty() {
        Map<String, String> map = new HashMap<>();
        System.out.println(MapUtils.isEmpty(map)); // true
        System.out.println(MapUtils.isNotEmpty(map)); // false
    }
}
