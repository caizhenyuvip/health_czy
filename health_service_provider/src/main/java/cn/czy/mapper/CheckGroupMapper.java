package cn.czy.mapper;

import cn.czy.pojo.CheckGroup;
import cn.czy.pojo.CheckItem;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface CheckGroupMapper {
    void add(CheckGroup checkGroup);
    void setCheckItemAndCheckGroup(Map map);
    Page<CheckGroup> selectByCondition(String queryString);
}
