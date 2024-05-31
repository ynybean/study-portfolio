package com.myybean.portfolio.domain.repository

import com.myybean.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long> {

}