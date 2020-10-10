package com.order_server.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order_server.service.ProductOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/order")
public class ProductController {


    @Autowired
    private ProductOderService service;

    /*@Autowired
    private RedisTemplate redisTemplate;*/
    @RequestMapping("/save")
    @HystrixCommand(fallbackMethod = "saveFindOeder")
    public Object find(@RequestParam("userId")Integer userId, @RequestParam("productId")Integer productId, HttpServletRequest request){
        Map<Object, Object> map = new HashMap<>();
        map.put("code",1);
        map.put("data",service.save(userId,productId));
        return map;
    }

    private Object saveFindOeder(Integer userId,Integer productId, HttpServletRequest request){
        // 监控报警
       /* new Thread( () ->{
            String ip = request.getRemoteAddr();
            String sendRedisKey = "order-service";
            Object o = redisTemplate.opsForValue().get(sendRedisKey);
            if (StringUtils.isEmpty(o)){
                System.out.println("紧急短信，用户下单失败，请离开查找原因,ip地址="+ip);
                //发送一个http请求，调用短信服务 TOOO
                redisTemplate.opsForValue().set(sendRedisKey,"order-service-file",20);
            }else{
                System.out.println("已发送短信，20秒内不准发送短信");
            }
        }).start();*/

        Map<String, Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("msg","抢购人数太多，你被挤出来了，稍后再试");
        return map;
    }
}
