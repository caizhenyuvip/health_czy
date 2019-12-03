package cn.czy.controller;

import cn.czy.constant.MessageConstant;
import cn.czy.constant.RedisConstant;
import cn.czy.entity.PageResult;
import cn.czy.entity.QueryPageBean;
import cn.czy.entity.Result;
import cn.czy.pojo.Setmeal;
import cn.czy.service.SetmealService;
import cn.czy.utils.QiniuUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private JedisPool jedisPool;
    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile imgFile){
        String filename = imgFile.getOriginalFilename();
        int index = filename.lastIndexOf(".");
        String substring = filename.substring(index);
       String name= UUID.randomUUID().toString()+ substring;
        try {
            QiniuUtils.upload2Qiniu(imgFile.getBytes(),name);
            jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES,name);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.PIC_UPLOAD_FAIL);
        }
        return new Result(true,MessageConstant.PIC_UPLOAD_SUCCESS,name);
    }
    @Reference
    private SetmealService setmealService;
    @RequestMapping("/add")
    public Result add(@RequestBody Setmeal setmeal,Integer[] checkgroupIds){
        try{
            setmealService.add(setmeal,checkgroupIds);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_SETMEAL_FAIL);
        }
        return new Result(true,MessageConstant.ADD_SETMEAL_SUCCESS);
    }
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return setmealService.findPage(queryPageBean);
    }

}
