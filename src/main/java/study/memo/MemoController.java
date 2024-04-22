package study.memo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import study.memo.domain.Memo;
import study.memo.domain.MemoDto;
import study.memo.domain.MemoService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/")
    public String home(Model model) {
        List<Memo> memos = memoService.findAll();
        log.info("memos={}", memos.size());
        model.addAttribute("memos", memos);
        return "home";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute(new MemoDto(null, null));
        return "add";
    }

    @PostMapping("/add")
    public String addMemo(MemoDto dto, RedirectAttributes redirectAttributes) {
        Memo savedMemo = memoService.saveMemo(dto);
        redirectAttributes.addAttribute("memoId", savedMemo.getId());
        return "redirect:/{memoId}";
    }

    @GetMapping("/{memoId}")
    public String readMemo(@PathVariable Long memoId, Model model) {
        Memo memo = memoService.findMemo(memoId);
        model.addAttribute(memo);
        return "memo";
    }
}
