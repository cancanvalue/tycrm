package com.javasm.tycrm.service.impl;

import com.alibaba.fastjson.JSON;
import com.javasm.tycrm.entity.MenuMainEntity;
import com.javasm.tycrm.entity.MenuSubEntity;
import com.javasm.tycrm.mapper.MenuMapper;
import com.javasm.tycrm.service.MenuService;
import com.javasm.tycrm.service.redis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @ClassName MenuServiceImpl
 * @Description 菜单业务逻辑类
 * @Author jiafu
 * @Date 2019/9/8 1:27
 * @Version V1.0
 **/

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public String getMenu() {
        String mainMenuList = null;
        Jedis jedis = jedisUtil.getJedis();
        if(jedisUtil.getJedis().exists("menu")){
             mainMenuList = jedis.get("menu");
        }else{
            List<MenuMainEntity> mainMenuEntityList = menuMapper.getMainMenuList();
            for (MenuMainEntity mainMenu:mainMenuEntityList) {
                short menuSuperId = mainMenu.getMenuId();
                List<MenuSubEntity> twoMenuList = menuMapper.getTwoMenuList(menuSuperId);
                mainMenu.setMenuSub(twoMenuList);
                for (MenuSubEntity twoMenu:twoMenuList) {
                    menuSuperId = twoMenu.getMenuId();
                    List<MenuSubEntity> threeMenuList = menuMapper.getThreeMenuList(menuSuperId);
                    twoMenu.setMenuSub(threeMenuList);
                }
            }
            mainMenuList = JSON.toJSONString(mainMenuEntityList);
            jedis.set("menu",mainMenuList);
        }
        jedisUtil.release(jedis);
        return mainMenuList;
    }
}
