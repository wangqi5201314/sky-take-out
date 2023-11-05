package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询对应的套餐id
     *
     * @param dishIds
     * @return
     */
    //select setmeal_id from setmeal_dish where dish_id in (1,2,3,4)
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

//    @AutoFill(OperationType.INSERT)
    @Insert("insert into setmeal_dish (setmeal_id, dish_id, name, " +
            "price, copies) values (#{setmealId}, #{dishId}, " +
            "#{name},#{price},#{copies})")
    void addSetmealDish(SetmealDish setmealDish);

    void insertBatch(List<SetmealDish> setmealDishes);
}
