package com.javasm.tycrm.mapper;

import com.javasm.tycrm.entity.MenuMainEntity;
import com.javasm.tycrm.entity.MenuSubEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName MenuMapper
 * @Description 菜单dao层
 * @Author jiafu
 * @Date 2019/9/8 1:34
 * @Version V1.0
 **/
public interface MenuMapper {

    @Select("select * from t_menu_one")
    @Results(id = "resultMap1",value = {
            @Result(id = true,property = "menuId",column ="menu_id"),
            @Result(property = "menuName",column ="menu_name"),
            @Result(property = "menuIcon",column ="menu_icon"),
    })
    List<MenuMainEntity> getMainMenuList();

    @Select("select * from t_menu_two where menu_super_id = #{menuSuperId, jdbcType=SMALLINT}")
    @Results(id = "resultMap2",value = {
            @Result(id = true,property = "menuId",column ="menu_id"),
            @Result(property = "menuName",column ="menu_name"),
            @Result(property = "menuSuperId",column ="menu_super_id"),
            @Result(property = "menuIcon",column ="menu_icon"),
    })
    List<MenuSubEntity> getTwoMenuList(@Param("menuSuperId") short menuSuperId);

    @Select("select * from t_menu_three where menu_super_id = #{menuSuperId, jdbcType=SMALLINT}")
    @Results(id = "resultMap3",value = {
            @Result(id = true,property = "menuId",column ="menu_id"),
            @Result(property = "menuName",column ="menu_name"),
            @Result(property = "menuSuperId",column ="menu_super_id"),
            @Result(property = "menuIcon",column ="menu_icon"),
    })
    List<MenuSubEntity> getThreeMenuList(@Param("menuSuperId") short menuSuperId);
}
