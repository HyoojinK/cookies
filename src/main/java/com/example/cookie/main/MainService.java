package com.example.cookie.main;

import com.example.cookie.util.CookieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
@RequiredArgsConstructor

public class MainService {

private final CookieService cookieService;
    public void login(MainVo mainVo, HttpServletResponse response){
        cookieService.setCookie(response, "name", mainVo.getName());
        cookieService.setImportantCookie(response, "email", mainVo.getEmail() );
        cookieService.setImportantCookie(response, "password", mainVo.getPassword());
        cookieService.setCookie(response, "address", mainVo.getAddress());
    }


    public MainVo check(HttpServletRequest request){
        Map<String, List<String>> map = cookieService.getCookie(request);
        List<String> name = map.get("name");        // [JSESSIONID, name, email, password, address]
        List<String> value = map.get("value");      // [45C1A5912A675FC7D0BA76EE7295B99B, 김효진, kyg0328@naver.com, 1234, 서울 강남구]
        MainVo mainVo = new MainVo();

        for(int i=0; i<name.size(); i++){
            if(name.get(i).equals("name")) {
                mainVo.setName(value.get(i));
            } else if(name.get(i).equals("email")){
                mainVo.setEmail(value.get(i));
            } else if (name.get(i).equals("password")) {
                mainVo.setPassword(value.get(i));
            } else if (name.get(i).equals("address")) {
                mainVo.setAddress(value.get(i));
            }
        }
        return mainVo;
    }



}
