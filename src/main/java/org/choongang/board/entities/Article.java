package org.choongang.board.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Article {
    private long artNo;
    private String artTitle;
    private long userNo;
    private String artBody;
    private long readCnt;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
