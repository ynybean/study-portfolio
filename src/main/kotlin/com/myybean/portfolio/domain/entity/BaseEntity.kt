package com.myybean.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass // 이걸 붙여야 이걸 상속받는 엔티티 클래스가 이 안에 있는 필드들을 해당 엔티티의 컬럼과 매핑 가능
abstract class BaseEntity {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdDateTime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(nullable = false)
    var updatedDateTime: LocalDateTime = LocalDateTime.now()

}