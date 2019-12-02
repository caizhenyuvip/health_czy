package cn.czy.service.impl;

import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.mapper.CheckGroupMapper;
import cn.czy.mapper.CheckItemMapper;
import cn.czy.pojo.CheckGroup;
import cn.czy.pojo.CheckItem;
import cn.czy.service.CheckGroupService;
import cn.czy.service.CheckItemService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupMapper checkGroupMapper;

    @Override
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
        checkGroupMapper.add(checkGroup);
        Integer checkGroupId = checkGroup.getId();
        this.setCheckItemAndCheckGroup(checkGroupId, checkitemIds);
}
    //分页查询
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        Page<CheckGroup> page = checkGroupMapper.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }

    public void setCheckItemAndCheckGroup(Integer checkGroupId,Integer[] checkitemIds){
        if(checkitemIds !=null && checkitemIds.length>0){
            for (Integer checkitemId : checkitemIds) {
                Map<String,Integer> map =new HashMap<>();
                map.put("checkgroupId",checkGroupId);
                map.put("checkitemId",checkitemId);
                checkGroupMapper.setCheckItemAndCheckGroup(map);
            }
        }
    }
}
