package study.memo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;

@Entity
public class Memo {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String content;

    public Memo(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
