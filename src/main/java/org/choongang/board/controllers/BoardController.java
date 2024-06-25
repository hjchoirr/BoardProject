package org.choongang.board.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.board.service.ArticleRegService;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final ArticleRegService articleRegService;

    //게시물 등록 양식
    @GetMapping("/articlereg")
    public String articleRegist() {

        return "board/articlereg";
    }

    //게시물 등록 처리
    @PostMapping("/articlereg")
    public String articleRegPs(RequestArtReg form) {
        return "board/articlereg";
    }
}
