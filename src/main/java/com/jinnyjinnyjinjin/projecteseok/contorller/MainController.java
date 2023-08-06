package com.jinnyjinnyjinjin.projecteseok.contorller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    @RequestMapping("")
    public String index() {
        return "index";
    }
}
