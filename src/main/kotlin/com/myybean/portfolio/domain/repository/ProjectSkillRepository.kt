package com.myybean.portfolio.domain.repository

import com.myybean.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long> {

    // select * from project_skill where project_id = :projectID and skill_id = :skillId
    fun findByProjectIdAndSkillId(projectId: Long, skillId: Long): Optional<ProjectSkill>

}