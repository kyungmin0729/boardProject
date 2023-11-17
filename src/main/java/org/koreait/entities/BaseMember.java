package org.koreait.entities;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
// 공통으로 쓰이는 abstract, @MappedSuperclass, @Getter @Setter, @EntityListeners(AuditingEntityListener.class)
public abstract class BaseMember extends Base {


    @Column(length = 65, updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(length = 65, insertable = false)
    @LastModifiedBy
    private String modifiedBy;
}
