package com.myybean.portfolio.domain.repository

import com.myybean.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface ProjectRepository : JpaRepository<Project, Long> {

    // project - skill, project - detail 각각은 할 수 있지만, proejct - skill, detail 같이는 못함 -> 설정에서 default_batch_fetch_size: true 해주면 in절로 돌림
    @Query("select p from Project p left join fetch p.skills s left join fetch s.skill where p.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Project>

    @Query("select p from Project p left join fetch p.details where p.id = :id")
    override fun findById(id: Long): Optional<Project>

}