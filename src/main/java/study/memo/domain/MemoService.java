package study.memo.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Memo saveMemo(MemoDto dto) {
        Memo memo = new Memo(dto);
        memoRepository.save(memo);
        return memo;
    }

    @Transactional
    public void updateMemo(Long id, MemoDto dto) {
        memoRepository.update(id, dto);
    }

    @Transactional
    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }

    public Memo findMemo(Long id) {
        return memoRepository.findById(id).get();
    }

    public List<Memo> findAll() {
        return memoRepository.findAll();
    }
}
