package cn.czy.mapper;

import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.pojo.CheckItem;
import com.github.pagehelper.Page;

import java.util.List;

public interface CheckItemMapper {
    List<CheckItem> findAll();
    //编辑检查项
    void edit(CheckItem checkItem);
    //新增
    void add(CheckItem checkItem);
    //分页
    Page<CheckItem> selectByCondition(String queryString);
    //删除
    void deleteById(Integer id);
    long findCountByCheckItemId(Integer id);
    //回显
    CheckItem findById(Integer id);
}
