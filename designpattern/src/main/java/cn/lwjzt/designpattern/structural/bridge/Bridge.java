package cn.lwjzt.designpattern.structural.bridge;

/**
 * @author Leexiaobu
 * @date 2020-09-07 22:04:40
 */
public class Bridge {
    //    分离抽象具体
//    用聚合方式连接抽象和具体

    public static void main(String[] args) {

//        这里的Gift 由gift 和giftimpl 组合而成
        Gift gift = new SmallGift(new Book());

    }
}
