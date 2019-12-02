package cn.czy.service;

import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.pojo.CheckGroup;

public interface CheckGroupService {
    //新增检查项
    void add(CheckGroup checkGroup, Integer[] checkitemIds);
    PageResult findPage(QueryPageBean queryPageBean);

}
