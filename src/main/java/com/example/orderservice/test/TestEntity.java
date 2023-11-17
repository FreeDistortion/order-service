package com.example.orderservice.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 사용자 정의 sequence 적용
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(
        name = "my_generator",
        sequenceName = "test_seq",
        allocationSize = 1,
        initialValue = 1
)
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_generator")
    private Long id;
    private String info;

    public TestEntity(String info) {
        this.info = info;
    }
}
