package com.myybean.portfolio.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller // -> html파일을 리턴해준다
class PresentationViewController {

    @GetMapping("/test")
    fun test(): String {
        return "test" // view resolver가 이 이름의 html을 찾아서 retun함
    }

}