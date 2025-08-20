package me.shinseong.moose.controller;

import lombok.RequiredArgsConstructor;
import me.shinseong.moose.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/get-api/")
public class GetController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World! version 2!";
    }

    @GetMapping(value = "/hello/{name}")
    public String getName(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping(value = "/hello2/{name}")
    public String getName2(@PathVariable("name") String LastName){
        return "Hello Mr." + LastName;
    }

    @GetMapping(value = "/request1")
    public String getRequest1(
            @RequestParam String fname,
            @RequestParam String lname,
            @RequestParam String email
    ){
        return "Welcome, " + fname + " " + lname + ".\n" + "Your email: " + email;
    }

    @GetMapping(value = "/request2")
    public String getRequest2(@RequestParam Map<String, String> params){
        StringBuilder result = new StringBuilder();
        for (String key : params.keySet()) {
            result.append(params.get(key) + ": " + params.get(key) + "\n");
        }
        return params.toString();
    }

    @GetMapping(value = "/request3")
    public String getRequest3(@ModelAttribute MemberDTO member){
        return member.toString(); // 오버라이드된 toString() 호출
    }
}
