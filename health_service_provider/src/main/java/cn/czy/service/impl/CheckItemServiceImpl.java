package cn.czy.service.impl;

import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.mapper.CheckItemMapper;
import cn.czy.pojo.CheckItem;
import cn.czy.service.CheckItemService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemMapper checkItemMapper;
    //新增
    @Override
    public void add(CheckItem checkItem) {
        checkItemMapper.add(checkItem);
    }
    //分页
    @Override
    public PageResult pageQuerry(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckItem> page = checkItemMapper.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }


}
