package cn.czy.service;

import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.pojo.CheckItem;

public interface CheckItemService {
    //新增
    void add(CheckItem checkItem);
    //分页
    PageResult pageQuerry(QueryPageBean queryPageBean);
}
