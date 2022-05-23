package site.metacoding.algori_api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JusoController {
    
    @GetMapping("/")
    public String index() {

        return "index";
    }

    @PostMapping("/juso/callback")
    public void jusoCallback(String roadFullAddr) {
    }

    @RequestMapping(value = "/juso/popup", method = {RequestMethod.GET, RequestMethod.POST}) // 메서드를 2개 이상 가능함
    public String jusopopup(Model model, String roadFullAddr) {

        if(roadFullAddr == null) {
            System.out.println("버튼 눌려서 호출");
        } else {
            System.out.println(roadFullAddr);
            System.out.println("도로명 주소 국가 서버에서 호출");
        }
        
        String josoUrl = "https://www.juso.go.kr/addrlink/addrLinkUrl.do";
        String confmKey = "devU01TX0FVVEgyMDIyMDUyMzEwNDgzNTExMjYwMDA=";
        String retrunUrl = "http://localhost:8080/juso/popup";

        if(roadFullAddr == null) {
            roadFullAddr = "n";
        }
        model.addAttribute("roadFullAddr", roadFullAddr);
        model.addAttribute("confmKey", confmKey);
        model.addAttribute("returnUrl", retrunUrl);
        model.addAttribute("resultType", "4");
        model.addAttribute("jusoUrl", josoUrl);
        return "jusoPopup";
    }
}
