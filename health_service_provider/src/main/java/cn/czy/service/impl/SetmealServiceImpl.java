package cn.czy.service.impl;

import cn.czy.constant.RedisConstant;
import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.mapper.CheckGroupMapper;
import cn.czy.mapper.SetmealMapper;
import cn.czy.pojo.CheckGroup;
import cn.czy.pojo.CheckItem;
import cn.czy.pojo.Setmeal;
import cn.czy.service.CheckGroupService;
import cn.czy.service.SetmealService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealMapper setmealMapper;
    @Autowired
    private JedisPool jedisPool;

    @Override
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
           setmealMapper.add(setmeal);
        Integer setmealId = setmeal.getId();
        String name = setmeal.getImg();
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES,name);
        if(checkgroupIds != null && checkgroupIds.length>0){
            for (Integer checkgroupId : checkgroupIds) {
                Map<String,Integer> map=new HashMap();
                map.put("setmealId",setmealId);
                map.put("checkgroupId",checkgroupId);
                setmealMapper.setmealAndCheckgroup(map);
            }
        }
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        String queryString = queryPageBean.getQueryString();
        Page<Setmeal> page = setmealMapper.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }


}
