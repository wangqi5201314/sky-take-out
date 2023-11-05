package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin/shop")
@Slf4j
@RestController("adminShopController")
@Api(tags = "店铺营业状态")
public class ShopController {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置商家的营业状态
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("设置商家的营业状态")
    public Result setStatus(@PathVariable Integer status) {
        log.info("店铺营业状态更改为{}",status==1?"营业中":"打样了");
        redisTemplate.opsForValue().set("status",status);
        return Result.success();
    }

    @GetMapping("/status")
    @ApiOperation("查询商家的营业状态")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get("status");
        log.info("获取到店铺的营业状态为：{}",status == 1 ? "营业中" : "打烊中");
        return Result.success(status);
    }
}
