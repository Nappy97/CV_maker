package com.history.nappy.controller;

import com.history.nappy.config.auth.PrincipalDetail;
import com.history.nappy.domain.board.Board;
import com.history.nappy.dto.board.BoardSaveRequestDto;
import com.history.nappy.dto.board.BoardUpdateRequestDto;
import com.history.nappy.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    // 목록
    @GetMapping("/board")
    public String index(Model model,
                        @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                        @RequestParam(required = false, defaultValue = "") String search) {

        Page<Board> boards = boardService.findByTitleContainingOrContentContaining(search, search, pageable);
        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards", boards);
        return "board/boards";
    }

    // 작성
    @GetMapping("/board/save")
    public String save() {
        return "board/boardSave";
    }

    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto boardSaveRequestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return boardService.save(boardSaveRequestDto, principalDetail.getMember());
    }

    // detail
    @GetMapping("/board/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        boardService.updateCount(id);
        return "board/boardDetail";
    }

    // delete
    @DeleteMapping("/api/v1/board/{id}")
    public Long deleteById(@PathVariable Long id) {
        boardService.deleteById(id);
        return id;
    }

    // update
    @GetMapping("/board/{id}/update")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        return "board/boardUpdate";
    }

    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        return boardService.update(id, boardUpdateRequestDto);
    }
}
