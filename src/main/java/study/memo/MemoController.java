package study.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemoController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/add")
    public String addMemo() {
        return "add";
    }
}
