package com.jinnyjinnyjinjin.projecteseok.contorller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/list")
    public String list() {
        return "list.html";
    }
}
