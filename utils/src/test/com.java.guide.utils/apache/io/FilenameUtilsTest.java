package apache.io;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

public class FilenameUtilsTest {

    /**
     * 获取文件扩展名、baseName
     */
    @Test
    public void testExtension() {
        String path = this.getClass().getClassLoader().getResource("test1.txt").getPath();
        System.out.println(FilenameUtils.getBaseName(path));  // test1
        System.out.println(FilenameUtils.getExtension(path)); // txt
    }
}
