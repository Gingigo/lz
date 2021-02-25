package cn.lwjzt.designpattern.action.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Leexiaobu
 * @date 2020-09-07 23:41:33
 */
public class Observer {

    //    这一步很关键，将调用行为提取出来
    public List<ProductObserver> list = new ArrayList<>();
    public Map<String, Integer> map = new HashMap<>();

    public void addObserver(ProductObserver observer) {
        list.add(observer);
    }

    public void removeObserver(ProductObserver observer) {
        list.remove(observer);
    }

    public void addProduct(Product product) {
        map.put(product.getName(), product.price);
        list.forEach(o -> o.doit(product));
    }

    public static void main(String[] args) {
        Observer observer = new Observer();
        ProductObserver lxb = new LXB();
        ProductObserver leexiaobu = new Leexiaobu();
        observer.addObserver(lxb);
        observer.addObserver(leexiaobu);
        Product product = new Product();
        product.setName("a");
        product.setPrice(10);
        observer.addProduct(product);
    }
}


