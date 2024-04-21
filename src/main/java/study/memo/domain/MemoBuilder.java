package study.memo.domain;

public class MemoBuilder {
    private String title;
    private String content;

    public Memo build() {
        return new Memo(title, content);
    }

    public MemoBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MemoBuilder content(String content) {
        this.content = content;
        return this;
    }
}
