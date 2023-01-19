package com.history.nappy.controller;

import com.history.nappy.config.auth.PrincipalDetail;
import com.history.nappy.domain.board.BoardReply;
import com.history.nappy.service.board.BoardReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardReplyController {

    private final BoardReplyService boardReplyService;

    // 댓글작성
    @PostMapping("/api/v1/board/{boardId}/reply")
    public void save(@PathVariable Long boardId,
                     @RequestBody BoardReply boardReply,
                     @AuthenticationPrincipal PrincipalDetail principalDetail) {
        boardReplyService.replySave(boardId, boardReply, principalDetail.getMember());
    }

    // delete
    @DeleteMapping("/api/v1/board/{boardId}/reply/{replyId}")
    public void delete(@PathVariable Long replyId) {
        boardReplyService.replyDelete(replyId);
    }
}
