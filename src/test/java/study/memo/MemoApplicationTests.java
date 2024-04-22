package study.memo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.memo.domain.MemoDto;
import study.memo.domain.Memo;
import study.memo.domain.MemoRepository;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemoApplicationTests {

    @Autowired
	MemoRepository memoRepository;

	@Test
	void 메모생성() {
		Memo memo = new Memo("제목", "내용");
		memoRepository.save(memo);
		Memo findMemo = memoRepository.findById(memo.getId()).get();
		assertThat(findMemo).isEqualTo(memo);
	}

	@Test
	void 메모수정() {
		Memo memo = new Memo("제목", "내용");
		memoRepository.save(memo);
		memoRepository.update(memo.getId(), new MemoDto("제목2", "내용2"));
		Memo findMemo = memoRepository.findById(memo.getId()).get();
		assertThat(findMemo.getTitle()).isEqualTo("제목2");
		assertThat(findMemo.getContent()).isEqualTo("내용2");
	}

	@Test
	void 메모삭제() {
		Memo memo = new Memo("제목", "내용");
		memoRepository.save(memo);
		memoRepository.deleteById(memo.getId());
		assertThatThrownBy(() -> memoRepository.findById(memo.getId()).get())
				.isInstanceOf(NoSuchElementException.class);
	}
}
