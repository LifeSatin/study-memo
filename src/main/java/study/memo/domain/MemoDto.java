package study.memo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoDto {
    private String title;
    private String content;

    public MemoDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public MemoDto() {
    }
}
