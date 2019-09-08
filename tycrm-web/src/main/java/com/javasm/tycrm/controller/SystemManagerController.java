package com.javasm.tycrm.controller;

import com.javasm.tycrm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SystemManagerController
 * @Description 系统管理控制器
 * @Author jiafu
 * @Date 2019/9/8 1:21
 * @Version V1.0
 **/

@RestController
@CrossOrigin
public class SystemManagerController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/getMenu")
    public ResponseEntity<String> getMenu(){
        String menu = menuService.getMenu();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<String>(menu, headers, HttpStatus.OK);
    }
}
