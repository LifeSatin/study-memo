package study.memo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.memo.domain.MemoDto;
import study.memo.domain.MemoService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("form", new MemoDto());
        return "add";
    }

    @PostMapping("/add")
    public String addMemo(@ModelAttribute("form") MemoDto dto) {
        log.info("content={}", dto.getContent());
        log.info("title={}", dto.getTitle());
        memoService.saveMemo(dto);
        return "home";
    }
}
