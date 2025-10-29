package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 웹 어플리케이션에서 첫 번째 진입점이 컨트롤러이다.
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // templates/hello.html
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name,
                           Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
