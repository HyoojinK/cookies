package com.example.cookie.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping({"/",""})
    public String home() {
        return "home";
    }

    @PostMapping("/login")
    public String login(MainVo mainVo, HttpServletResponse response, HttpServletRequest request, Model model){
        mainService.login(mainVo,response);
        MainVo userinfo = mainService.check(request);
        model.addAttribute("userinfo", userinfo);
        return "check";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request, Model model){
        MainVo mainVo = mainService.check(request);
        model.addAttribute("mainVo", mainVo);
        return "user";
    }

    @PostMapping("/modify")
    public String modify(MainVo mainVo, HttpServletResponse response, HttpServletRequest request, Model model){
        mainService.login(mainVo,response);
        MainVo userinfo = mainService.check(request);
        model.addAttribute("userinfo", userinfo);
        return "doublecheck";
    }

    @GetMapping("/doublecheck")
    public String doublecheck(HttpServletRequest request, Model model){
        MainVo mainVo = mainService.check(request);
        model.addAttribute("mainVo", mainVo);
        return "home";
    }

}
