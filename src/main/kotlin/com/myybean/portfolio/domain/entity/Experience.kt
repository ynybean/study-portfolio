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
class Experience(
    title: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?,
    endMonth: Int?,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    var id: Long? = null

    var title: String = title

    var description: String = description

    var startYear: Int = startYear

    var startMonth: Int = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = endMonth

    var isActive: Boolean = isActive

    @OneToMany(
        targetEntity = ExperienceDetail::class,
        fetch = FetchType.LAZY, // jpa proxy가 최초에 Experience에는 빈 가짜 객체로 들고있다가, 이 details를 다시 조회함. -> n + 1 문제 발생
        cascade = [CascadeType.ALL]
    ) // 영속성 컨텍스트 관련
    @JoinColumn(name = "experience_id")
    var details: MutableList<ExperienceDetail> = mutableListOf() // Mutable : 변할 수 있음, mutableListOf() = 빈 list

    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }

        return "${endYear}.${endMonth}" // 2023.12
    }

    fun update(
        title: String,
        description: String,
        startYear: Int,
        startMonth: Int,
        endYear: Int?,
        endMonth: Int?,
        isActive: Boolean
    ) {
        this.title = title
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    } // entity의 값을 바꾸면 jpa가 transaction 끝날 때 지금 entity와 db값과 비교해서 db에 저장 함

    fun addDetails(details: MutableList<ExperienceDetail>?) {
        if (details != null) {
            this.details.addAll(details)
        }
    }

}