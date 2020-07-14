package com.lizhiyu.demo.controller.user;

import com.lizhiyu.demo.vo.base.R;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("user")
public class LoginController {

    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","13123");
    }
    @GetMapping("/info")
    public R info(){
        return R.ok().data("name","admin").data("roles","[admin]").data("avatar","http://213123");
    }
}
