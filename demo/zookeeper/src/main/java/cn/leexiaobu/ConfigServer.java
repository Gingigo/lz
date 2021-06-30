package cn.leexiaobu;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author Leexiaobu
 * @date 2021-06-08 11:57
 */
public class ConfigServer {

  private static final String CONNECT_STR = "192.168.31.192:2181";
  private static final String CONFIG_PATH = "/config";

  private static final int SESSION_TIMEOUT = 6000;
  private static ZooKeeper zooKeeper;

  public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    zooKeeper = new ZooKeeper(CONNECT_STR, SESSION_TIMEOUT, new Watcher() {
      @Override
      public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == KeeperState.SyncConnected
            && watchedEvent.getType() == EventType.None) {
          //连接是异步的
          System.out.println("connect !");
          countDownLatch.countDown();
        }
      }
    });
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Watcher watcher = new Watcher() {
      @Override
      public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == KeeperState.SyncConnected
            && watchedEvent.getType() == EventType.NodeDataChanged
            && watchedEvent.getPath().equals(CONFIG_PATH)) {
          byte[] data = new byte[0];
          try {
            data = zooKeeper.getData(CONFIG_PATH, this, null);
          } catch (KeeperException e) {
            e.printStackTrace();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("更新数据："+new String(data));

        }
      }
    };
    System.out.println("开始处理逻辑");
    //get
    byte[] data = zooKeeper.getData(CONFIG_PATH, watcher, null);
    System.out.println("原始数据：" + new String(data));
    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
  }
}