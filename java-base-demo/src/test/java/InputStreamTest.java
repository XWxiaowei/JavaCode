import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * @author xiang.wei
 * @create 2018/1/17 14:13
 */
public class InputStreamTest {
    private InputStream inputStream;
    private static final String CONTENT = "Hello World";

    /**
     * getResourceAsStream方法中
     *  1.加"/" 代表了工程的根目录
     *  2.不加"/" 代表当前类的目录
     * getResourceAsStream方法只能在读取的文件路径只局限与工程的源文件夹中，
     * 包括在工程src根目录下，以及类包里面任何位置，
     * 但是如果配置文件路径是在除了源文件夹之外的其他文件夹中时，该方法是用不了的
     */
    @Before
    public void setUp() {
        this.inputStream = InputStreamTest.class.getResourceAsStream("input.txt");
    }

    /**
     * 读取 InputStream 中的所有剩余字节。
     * @throws IOException
     */
    @Test
    public void testReadAllBytes() throws IOException {
        String content = new String(inputStream.readAllBytes());
        assertEquals(CONTENT, content);
    }

    /**
     * 从 InputStream 中读取指定数量的字节到数组中。
     */
    @Test
    public void testReadNBytes() throws IOException {
        byte[] data = new byte[5];
        this.inputStream.readNBytes(data, 0, 5);
        assertEquals("Hello", new String(data));
    }

    /**
     * 读取 InputStream 中的全部字节并写入到指定的 OutputStream 中 。
     * @throws IOException
     */
    @Test
    public void testTransferTo() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        this.inputStream.transferTo(outputStream);
        assertEquals(CONTENT,outputStream.toString());
    }
}
