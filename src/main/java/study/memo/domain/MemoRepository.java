package study.memo.domain;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemoRepository {

    private final EntityManager em;

    public Memo save(Memo memo) {
        em.persist(memo);
        return memo;
    }
}
