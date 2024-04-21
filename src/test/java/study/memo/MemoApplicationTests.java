package study.memo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.Assertions;
import org.hibernate.sql.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import study.memo.domain.Memo;
import study.memo.domain.MemoBuilder;
import study.memo.domain.MemoRepository;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemoApplicationTests {

    @Autowired
	MemoRepository memoRepository;

	@Test
	void 메모생성() {
		MemoBuilder mb = new MemoBuilder();
		Memo memo = mb.title("제목")
				.content("내용")
				.build();
		memoRepository.save(memo);
		Memo findMemo = memoRepository.findById(1L).get();
		assertThat(memo).isEqualTo(findMemo);
	}
}
