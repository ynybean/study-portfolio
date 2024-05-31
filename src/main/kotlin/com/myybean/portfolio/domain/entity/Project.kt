package com.myybean.portfolio.domain.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany

@Entity
class Project(
    name: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?,
    endMonth: Int?,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    var id: Long? = null

    var name: String = name

    var description: String = description

    var startYear: Int = startYear

    var startMonth: Int = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = endMonth

    var isActive: Boolean= isActive

    @OneToMany(targetEntity = ProjectDetail::class,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL])
    @JoinColumn(name = "proejct_id")
    var details: MutableList<ProjectDetail> = mutableListOf()

    @OneToMany(mappedBy = "project")
    var skills: MutableList<ProjectSkill> = mutableListOf()

    fun getEndYearMonth() : String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }

        return "${endYear}.${endMonth}" // 2023.12
    }

    fun update(name: String, description: String, startYear: Int, startMonth: Int, endYear: Int?, endMonth: Int?, isActive: Boolean) {
        this.name = name
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    } // entity의 값을 바꾸면 jpa가 transaction 끝날 때 지금 entity와 db값과 비교해서 db에 저장 함

    fun addDetails(details: MutableList<ProjectDetail>?) {
        if (details != null) {
            this.details.addAll(details)
        }
    }
}