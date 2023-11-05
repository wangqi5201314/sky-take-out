package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService {
    void addSetmeal(SetmealDTO setmealDTO);

    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    void deleteByIds(List<Long> ids);

    SetmealVO getById(Long id);

    void update(SetmealDTO setmealDTO);
    /**
     * 套餐起售、停售
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);
}
