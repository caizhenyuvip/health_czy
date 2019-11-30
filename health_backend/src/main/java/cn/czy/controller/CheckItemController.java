package cn.czy.controller;

import cn.czy.constant.MessageConstant;
import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.entity.Result;
import cn.czy.pojo.CheckItem;
import cn.czy.service.CheckItemService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;
    //分页查询
    @RequestMapping("/findpage")
    public PageResult findpage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = checkItemService.pageQuerry(queryPageBean);
        return pageResult;
    }

    //新建
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){
        try {
            checkItemService.add(checkItem);
            return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
    }
}
