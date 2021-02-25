package cn.lwjzt.designpattern.structural.bridge;

/**
 * @author Leexiaobu
 * @date 2020-09-07 22:18:20
 */
public class SmallGift extends Gift {
    public SmallGift(GiftImpl giftimpl) {
        this.giftimpl = giftimpl;
    }
}
