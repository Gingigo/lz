package cn.lwjzt.designpattern.action.observer;

/**
 * @author Leexiaobu
 * @date 2020-09-08 0:03:56
 */
public class LXB implements ProductObserver {
    @Override
    public void doit() {
        System.out.println("LXB 看到了");
    }

    @Override
    public void doit(Product product) {
        if (product == null) {
            doit();
        } else {
            System.out.println("LXB 看到了" + product.getName());
        }
    }
}
