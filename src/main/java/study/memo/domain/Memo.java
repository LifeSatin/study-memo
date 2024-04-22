package study.memo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
public class Memo {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String content;

    protected Memo() {

    }

    public Memo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Memo(MemoDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
