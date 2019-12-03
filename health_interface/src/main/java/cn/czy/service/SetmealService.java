package cn.czy.service;

import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.pojo.CheckGroup;
import cn.czy.pojo.Setmeal;

import java.util.List;

public interface SetmealService {

    //新增检查项
    void add(Setmeal setmeal, Integer[] checkgroupIds);

    PageResult findPage(QueryPageBean queryPageBean);


}
