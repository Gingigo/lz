package io.nio.channel;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import sun.misc.IOUtils;

/**
 * @author Leexiaobu
 * @date 2021-07-01 0:02
 */
public class ChannelTest {

  String fileName = "";
  String outFileName = "";

  @Test
  public void streamReadTest() throws Exception {
    FileInputStream fileInputStream = new FileInputStream(fileName);
    long begin = System.currentTimeMillis();
    byte[] bytes = IOUtils.readFully(fileInputStream, -1, false);
    System.out.println(System.currentTimeMillis() - begin);
    fileInputStream.close();
    begin = System.currentTimeMillis();
    Files.write(Paths.get(outFileName), bytes);
    System.out.println(System.currentTimeMillis() - begin);

  }
}