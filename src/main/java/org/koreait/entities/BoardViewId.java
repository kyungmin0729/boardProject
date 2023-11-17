package org.koreait.entities;


import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data @IdClass(BoardViewId.class)
public class BoardViewId {


    private Long seq;


    private Integer uid;
}
