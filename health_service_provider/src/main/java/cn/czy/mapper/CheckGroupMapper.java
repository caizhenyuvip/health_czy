package cn.czy.mapper;

import cn.czy.pojo.CheckGroup;
import cn.czy.pojo.CheckItem;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CheckGroupMapper {
    void add(CheckGroup checkGroup);
    void setCheckItemAndCheckGroup(Map map);
    Page<CheckGroup> selectByCondition(String queryString);
    //编辑的检查组回显
    CheckGroup findById(Integer id);
    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
    //编辑检查组
    void edit(CheckGroup checkGroup);
    void deleteAssociation(Integer id);
    void setCheckGroupAndCheckItem(Map map);
    //删除
    void deleteById(Integer id);
//    @Select("select * from t_checkgroup")
    List<CheckGroup> findAll();
}
