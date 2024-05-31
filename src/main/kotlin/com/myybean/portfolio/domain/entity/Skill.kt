package com.myybean.portfolio.domain.entity

import com.myybean.portfolio.domain.constant.SkillType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Skill(
    name: String,
    type: String,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null

    var name: String = name

    @Column(name = "skill_type") // 어떤 db는 type이 예약어이므로 컬럼명으로 type을 쓰지 않음 (oracle)
    @Enumerated(value = EnumType.STRING) // STRING으로 해야 enum명 그대로 들어감, ORDINAL이면 enum선언된 순서대로 1 2 3 이런 값이 들어감(enum 선언한 순서 바뀌면,, 안맞아짐...)
    var type: SkillType = SkillType.valueOf(type)

    var isActive: Boolean = isActive

}