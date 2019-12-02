package cn.czy.service;

import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {
    List<CheckGroup> findAll();
    void deleteById(Integer id);
    //编辑的检查组
    void edit(CheckGroup checkGroup,Integer[] checkitemIds);
    //编辑的检查组回显
    CheckGroup findById(Integer id);
    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
    //新增检查项
    void add(CheckGroup checkGroup, Integer[] checkitemIds);
    PageResult findPage(QueryPageBean queryPageBean);

}
