package com.myybean.portfolio.presentation.controller

import com.myybean.portfolio.presentation.dto.IntroductionDTO
import com.myybean.portfolio.presentation.dto.LinkDTO
import com.myybean.portfolio.presentation.dto.ProjectDTO
import com.myybean.portfolio.presentation.dto.ResumeDTO
import com.myybean.portfolio.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController // -> response body를 가지고 있음. return 값을 body에 넣어서 응답함
@RequestMapping("/api")
class PresentationApiController(
    private val presentationService: PresentationService
) {

    @GetMapping("/test")
    fun test(): String {
        return "OK"
    }

    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO> {
        return presentationService.getIntroductions()
    }

    @GetMapping("/v1/links")
    fun getLinks(): List<LinkDTO> {
        return presentationService.getLinks()
    }

    @GetMapping("/v1/resume")
    fun getResume(): ResumeDTO {
        return presentationService.getResume()
    }

    @GetMapping("/v1/projects")
    fun getProjects(): List<ProjectDTO> {
        return presentationService.getProjects()
    }

}