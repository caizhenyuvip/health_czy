package cn.czy.jobs;

import cn.czy.constant.RedisConstant;
import cn.czy.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

import java.util.Set;

public class ClearImgJob {
    @Autowired
    private JedisPool jedisPool;

    public void clearImg(){
        //根据Redis中保存的两个set集合进行差值计算，获得垃圾图片名称集合
        Set<String> set = jedisPool.getResource().sdiff(RedisConstant.SETMEAL_PIC_RESOURCES, RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        if(set !=null){
            for (String name : set) {
                QiniuUtils.deleteFileFromQiniu(name);
                jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_RESOURCES,name);
                System.out.println("自定义任务执行，清理垃圾图片:" + name);
            }
        }
    }
}
