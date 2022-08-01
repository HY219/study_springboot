package com.example.hellorestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    /* View없이 문자 그대로 */
    @GetMapping("/helloWorld/string")
    //@ResponseBody는 http body에 return 값("hello")을 넣어준다.
    @ResponseBody
    public String helloWorldString(@RequestParam("messgae") String message) {
        return "hello" + message; //hello
    }

    /* api */
    @GetMapping("/helloWorld/json") //helloWorld/json?message=abc
    @ResponseBody
    public Hello helloWorldJson(@RequestParam("message") String message) {
        Hello hello = new Hello();
        hello.setMessage(message);
        return hello; //{"message":"abc"}
    }

    /* static */
    @GetMapping("helloWorld/page")
    public String HelloWorldPage() {
        return "helloWorld"; //abc
    }
}


