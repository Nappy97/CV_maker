package com.history.nappy.service.board;

import com.history.nappy.domain.board.Board;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.board.BoardSaveRequestDto;
import com.history.nappy.dto.board.BoardUpdateRequestDto;
import com.history.nappy.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // 작성
    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto, Member member) {
        boardSaveRequestDto.setMember(member);
        return boardRepository.save(boardSaveRequestDto.toEntity()).getId();
    }

    // 글목록 로직
    @Transactional(readOnly = true)
    public Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable) {
        return boardRepository.findByTitleContainingOrContentContaining(title, content, pageable);
    }

    // 글상세
    @Transactional(readOnly = true)
    public Board detail(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
    }

    // 글삭제
    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    // 글수정
    @Transactional
    public Long update(Long id, BoardUpdateRequestDto boardUpdateRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
        board.update(boardUpdateRequestDto.getTitle(), boardUpdateRequestDto.getContent());
        return id;
    }

    // 글 조회수
    @Transactional
    public int updateCount(Long id) {
        return boardRepository.updateCount(id);
    }
}
