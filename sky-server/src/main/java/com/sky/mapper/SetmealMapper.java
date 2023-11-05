package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    @Insert("insert into setmeal (category_id, name, price, " +
            "description, image, create_time, update_time, " +
            "create_user, update_user) VALUES (#{categoryId}," +
            "#{name}, " +
            "#{price}, #{description},#{image},#{createTime}, " +
            "#{updateTime}," +
            "    #{createUser}, #{updateUser})")
    @AutoFill(OperationType.INSERT)
    void addSetmeal(Setmeal setmeal);

    @Select("select id from setmeal where name=#{name}")
    Long getIdByName(String name);

    /**
     * 分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    //根据套餐id,查询数据库,返回setmeal对象
    @Select("select * from setmeal where id=#{id}")
    Setmeal getById(Long id);

    //根据id删除setmeal表中的所有信息
    @Delete("delete from setmeal where id=#{id}")
    void deleteById(Long id);

    @AutoFill(value = OperationType.UPDATE)
    void update(Setmeal setmeal);
}
