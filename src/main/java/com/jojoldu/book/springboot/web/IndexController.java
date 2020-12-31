package com.jojoldu.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/*
머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때
앞의 경로와 뒤의 파일 확장자는 자동으로 지정됨
src/main/resources/templates/*.mustache
 */

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    // index가 자동으로 index.mustache로 전환되어 처리됨

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
