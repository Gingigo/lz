package cn.lwjzt.designpattern.action.observer;

/**
 * @author Leexiaobu
 * @date 2020-09-07 23:56:50
 */
public interface ProductObserver {
    void doit();

    void doit(Product product);
}
