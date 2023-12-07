package com.example.cookie.util;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CookieService {

    public void setCookie(HttpServletResponse res, String key, String value){
        Cookie cookie = new Cookie(key, URLEncoder.encode(value, StandardCharsets.UTF_8)); // 쿠키 이름 지정하여 생성( key, value 개념)
        cookie.setMaxAge(60); //쿠키 유효 기간: 하루로 설정(60초 * 60분 * 24시간)
        cookie.setPath("/"); //모든 경로에서 접근 가능하도록 설정
        res.addCookie(cookie); //response에 Cookie 추가
    }

    public void setImportantCookie(HttpServletResponse res, String key, String value){
        Cookie cookie = new Cookie(key, URLEncoder.encode(value, StandardCharsets.UTF_8)); // 쿠키 이름 지정하여 생성( key, value 개념)
        cookie.setMaxAge(60); //쿠키 유효 기간: 하루로 설정(60초 * 60분 * 24시간)
        cookie.setPath("/check");
        res.addCookie(cookie); //response에 Cookie 추가
    }

    public Map<String, List<String>> getCookie(HttpServletRequest req) {
        List<String> name = new ArrayList<>();
        List<String> value = new ArrayList<>();
        Cookie[] cookies = req.getCookies(); // 모든 쿠키 가져오기
        if (cookies != null) {  // 쿠키에 데이터가 들어있다면?
            for (Cookie cookie : cookies) {  // 쿠키에 하나씩 접근하기
                name.add(cookie.getName()); // 쿠키 이름 가져오기
                value.add(URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8)); // 쿠키 값 가져오기
            }
        }
        System.out.println("name = " + name);
        System.out.println("value = " + value);

        Map<String, List<String>> map = new HashMap<>();
        map.put("name", name);
        map.put("value", value);
        return map;
    }

}
