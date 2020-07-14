package com.lizhiyu.demo.controller.user;

import com.lizhiyu.demo.vo.base.R;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/user/list")
    public R login(){
        return R.ok().data("msg","13123");
    }
}
