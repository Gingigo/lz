package cn.leexiaobu.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;

/**
 * @author Leexiaobu
 * @date 2021-06-23 21:58
 */
public interface UserMapper {


  /*
  * con
  * exec sql
  * */
  @Select("select * from test")
  List<Map<String, Object>> query();

  @Select("select * from test where id =?")
  List<Map<String, Object>> getById();
}
