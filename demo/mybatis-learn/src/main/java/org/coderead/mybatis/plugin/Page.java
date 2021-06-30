package org.coderead.mybatis.plugin;

/**
 * @author tommy
 * @title: Page
 * @projectName coderead-mybatis
 * @description:
 * @date 2020/6/2110:35 AM
 */
public class Page {
    private int total;// 总行数
    private int size;   //每页大小
    private int index;  //页码 从1开始

    public Page(int size, int index) {
        this.size=size;
        this.index=index;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getOffset() {
        return size * (index - 1);
    }
}
