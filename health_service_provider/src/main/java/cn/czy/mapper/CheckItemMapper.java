package cn.czy.mapper;

import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.pojo.CheckItem;
import com.github.pagehelper.Page;

public interface CheckItemMapper {
    //新增
    void add(CheckItem checkItem);
    //分页
    Page<CheckItem> selectByCondition(String queryString);
}
