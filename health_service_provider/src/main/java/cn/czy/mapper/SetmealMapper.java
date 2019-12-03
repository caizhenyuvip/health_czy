package cn.czy.mapper;

import cn.czy.pojo.CheckGroup;
import cn.czy.pojo.Setmeal;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface SetmealMapper {
    void add(Setmeal setmeal);
    void setmealAndCheckgroup(Map map);
    Page<Setmeal> selectByCondition(String queryString);

}
