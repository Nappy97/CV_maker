package com.history.nappy.domain.board;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Setter
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    private int count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    @OrderBy("id desc")
    @JsonIgnoreProperties({"board"})
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<BoardReply> boardReplyList;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
