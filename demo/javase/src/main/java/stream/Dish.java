package stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author Leexiaobu
 * @date 2021-07-01 11:48
 */
public class Dish {


  public static void main(String[] args) {
    //返回低热量的菜肴名称 getCalories() < 400
    //筛选出所有素菜
    //按照Map里面的类别对菜肴进行分组
    //筛选各异的元素
    //使用流来筛选菜单，找出三个高热量菜肴的名字
    //选出热量超过300卡路里的头三道菜
    //跳过超过300卡路里的头2道菜
    //。如果你要找出每道菜的名称有多长
    //对于一张单
    //词表，如何返回一张列表，列出里面 各不相同的字符 呢
    StringBuffer sb= new StringBuffer();
    sb.append("1232");
  }
  static {
     List<Dish> menu = Arrays.asList(
        new Dish("pork", false, 800, Dish.Type.MEAT),
        new Dish("beef", false, 700, Dish.Type.MEAT),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("pizza", true, 550, Dish.Type.OTHER),
        new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("salmon", false, 450, Dish.Type.FISH) );
  }
  private final String name;
  private final boolean vegetarian;
  private final int calories;
  private final Type type;
  public Dish(String name, boolean vegetarian, int calories, Type type) {
    this.name = name;
    this.vegetarian = vegetarian;
    this.calories = calories;
    this.type = type;
  }
  public String getName() {
    return name;
  }
  public boolean isVegetarian() {
    return vegetarian;
  }
  public int getCalories() {
    return calories;
  }
  public Type getType() {
    return type;
  }
  @Override
  public String toString() {
    return name;
  }
  public enum Type { MEAT, FISH, OTHER }
}