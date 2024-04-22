package study.memo.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    public void update(Long id, MemoDto dto) {
        Memo findMemo = em.find(Memo.class, id);
        findMemo.update(dto.getTitle(), dto.getContent());
    }

    public void deleteById(Long id) {
        Memo findMemo = em.find(Memo.class, id);
        if (findMemo != null) {
            em.remove(findMemo);
        }
    }

    public Optional<Memo> findById(Long id) {
        return Optional.ofNullable(em.find(Memo.class, id));
    }

    public List<Memo> findAll() {
        return em.createQuery("select m from Memo m", Memo.class).getResultList();
    }
}
