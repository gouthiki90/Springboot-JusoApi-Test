package site.metacoding.algori_api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JusoController {
    
    @GetMapping("/")
    public String index(Model model) {
        String josoUrl = "https://www.juso.go.kr/addrlink/addrLinkUrl.do?confmKey=devU01TX0FVVEgyMDIyMDUyMzEwNDgzNTExMjYwMDA=&returnUrl=http://localhost:8080/juso/callback&resultType=4";
        model.addAttribute("jusoUrl", josoUrl);
        return "index";
    }

    // 해당 콜백이 호출되면 push 해주는 게 좋다.
    @PostMapping("/juso/callback")
    public void jusoCallback(String roadFullAddr) {
        System.out.println(roadFullAddr);
        Store.roadFullAddr = roadFullAddr;
    }

    @CrossOrigin
    @GetMapping("/juso/check")
    public @ResponseBody String jusoCheck() {
        return Store.roadFullAddr;
    }
}
