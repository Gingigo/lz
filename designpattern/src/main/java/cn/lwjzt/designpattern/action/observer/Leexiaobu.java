package cn.lwjzt.designpattern.action.observer;

/**
 * @author Leexiaobu
 * @date 2020-09-08 0:03:56
 */
public class Leexiaobu implements ProductObserver {
    @Override
    public void doit() {
        System.out.println("leexiaobu 看到了");
    }

    @Override
    public void doit(Product product) {
        if (product == null) {
            doit();
        } else {
            System.out.println("leexiaobu 看到了" + product.getName());

        }
    }
}
