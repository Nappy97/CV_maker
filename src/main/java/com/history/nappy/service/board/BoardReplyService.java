package com.history.nappy.service.board;

import com.history.nappy.domain.board.Board;
import com.history.nappy.domain.board.BoardReply;
import com.history.nappy.domain.member.Member;
import com.history.nappy.repository.board.BoardRepository;
import com.history.nappy.repository.board.BoardReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardReplyService {

    private final BoardReplyRepository boardReplyRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void replySave(Long boardId, BoardReply boardReply, Member member) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("해당 boardId가 없습니다. id=" + boardId));

        boardReply.save(board, member);

        boardReplyRepository.save(boardReply);
    }

    @Transactional
    public void replyDelete(Long replyId) {
        boardReplyRepository.deleteById(replyId);
    }
}
