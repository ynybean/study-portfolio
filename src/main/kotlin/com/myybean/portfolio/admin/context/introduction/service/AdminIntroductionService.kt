package com.myybean.portfolio.admin.context.introduction.service

import com.myybean.portfolio.admin.data.TableDTO
import com.myybean.portfolio.domain.entity.Introduction
import com.myybean.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService(
    private val introductionService: IntroductionRepository
) {

    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionService.findAll()

        return TableDTO.from(classInfo, entities)
    }
}