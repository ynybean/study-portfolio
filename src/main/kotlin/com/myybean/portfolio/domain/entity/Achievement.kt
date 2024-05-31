package com.myybean.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity // 이걸 달아야 jpa에서 얘가 테이블과 맵핑되는 엔티티임을 앎
class Achievement(
    title: String,
    description: String,
    achievedDate: LocalDate?,
    host: String,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id") // 테이블 컬럼명 (자동 매칭이 안될 경우)
    var id: Long? = null // 자료형 뒤에 ? : null이 허용됨
    // Id의 경우 entity 생성 시 들어가는 값이 아니고 database에 들어갈 때 생성되므로 인스턴스를 생성한 순간에는 null일 것이므로 null허용

    var title: String = title

    var description: String = description

    var achievedDate: LocalDate? = achievedDate

    var host: String = host

    var isActive: Boolean = isActive
}