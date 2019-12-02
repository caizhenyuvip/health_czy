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

import java.util.List;

@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemMapper checkItemMapper;

    @Override
    public List<CheckItem> findAll() {
        return checkItemMapper.findAll();
    }

    //编辑检查项
    @Override
    public void edit(CheckItem checkItem) {
        checkItemMapper.edit(checkItem);

    }

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
    //删除检查项
    @Override
    public void delect(Integer id) {
        long count = checkItemMapper.findCountByCheckItemId(id);
        if(count>0){
            throw new RuntimeException();
        }
        checkItemMapper.deleteById(id);

    }

    @Override
    public CheckItem findById(Integer id) {
        return checkItemMapper.findById(id);
    }


}
