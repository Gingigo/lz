package cn.lwjzt.designpattern.structural.bridge;

/**
 * @author Leexiaobu
 * @date 2020-09-07 22:18:43
 */
public class LargeGift extends Gift {
    public LargeGift(GiftImpl giftimpl) {
        this.giftimpl = giftimpl;
    }
}
