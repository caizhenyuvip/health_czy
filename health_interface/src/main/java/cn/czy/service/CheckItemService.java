package cn.czy.service;

import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {
    List<CheckItem> findAll();
    //编辑检查项
    void edit(CheckItem checkItem);
    //新增
    void add(CheckItem checkItem);
    //分页
    PageResult pageQuerry(QueryPageBean queryPageBean);
    //删除
    void delect(Integer id);
    //回显
    CheckItem findById(Integer id);
}
