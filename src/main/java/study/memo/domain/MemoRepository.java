package study.memo.domain;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public class MemoRepository {

    private final EntityManager em;

    public MemoRepository(EntityManager em) {
        this.em = em;
    }

    public Memo save(Memo memo) {
        em.persist(memo);
        return memo;
    }

    public Optional<Memo> findById(Long id) {
        return Optional.ofNullable(em.find(Memo.class, id));
    }

    public void update(Long id, MemoBuilder mb) {
        Memo findMemo = em.find(Memo.class, id);
        findMemo = mb.build();
    }

    public void deleteById(Long id) {
        Memo findMemo = em.find(Memo.class, id);
        if (findMemo != null) {
            em.remove(findMemo);
        }
    }
}
