package com.history.nappy.domain.cv;

import com.history.nappy.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cv_detail")
@Getter
@Setter
public class CVDetails extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cv_detail_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private CV cv;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

}
