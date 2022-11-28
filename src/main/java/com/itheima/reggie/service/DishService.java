package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.entity.Dish;


public interface DishService extends IService<Dish> {

    //新增菜品，同时插入口味，两张表：dish，dish_flavor
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和口味
    public DishDto getByIdWithFlaovr (Long id);


   //更新菜品信息，同时更新对应的口味信息
    public void updateWithFlavor(DishDto dishDto);

}
