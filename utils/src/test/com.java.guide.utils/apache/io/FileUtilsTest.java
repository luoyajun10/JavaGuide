package apache.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileUtilsTest {

    @Test
    public void testReadFileToString() throws IOException {
        String path = this.getClass().getClassLoader().getResource("test1.txt").getPath();
        // readFileToString 读取指定的文本文件内容为一个字符串
        String string = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
        System.out.println(string);
    }

    @Test
    public void testReadLines() throws IOException {
        String path = this.getClass().getClassLoader().getResource("test1.txt").getPath();
        // readLines 读取指定的文本文件内容List<String>
        List<String> list = FileUtils.readLines(new File(path), StandardCharsets.UTF_8);
        System.out.println(list.size());
    }

    @Test
    public void testChecksumCRC32() throws IOException {
        String path = this.getClass().getClassLoader().getResource("test1.txt").getPath();
        // checksumCRC32 返回checksumCRC32值
        System.out.println(FileUtils.checksumCRC32(new File(path)));  // 179732765
    }

    @Test
    public void testOthers() throws IOException {
        String path = this.getClass().getClassLoader().getResource("test1.txt").getPath();
        // isSymlink 判断是否是软链接
        System.out.println(FileUtils.isSymlink(new File(path)));  // false
        // isEmptyDirectory 判断是否是空目录，要求必须是目录否则会抛异常
        path = this.getClass().getClassLoader().getResource("").getPath();
        System.out.println(FileUtils.isEmptyDirectory(new File(path)));  // false
    }
}
