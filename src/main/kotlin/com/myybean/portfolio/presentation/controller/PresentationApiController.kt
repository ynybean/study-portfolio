package com.myybean.portfolio.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController // -> response body를 가지고 있음. return 값을 body에 넣어서 응답함
@RequestMapping("/api")
class PresentationApiController {

    @GetMapping("/test")
    fun test(): String {
        return "OK"
    }

}