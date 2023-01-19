package com.history.nappy.dto.board;

import com.history.nappy.domain.board.Board;
import com.history.nappy.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String title;

    private String content;

    private int count;

    private Member member;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .count(0)
                .member(member)
                .build();
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
