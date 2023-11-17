package com.example.orderservice.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
@Transactional
class TestEntityTest {

    @Autowired
    EntityManager em;

    @Test
    void test() {
        TestEntity te1 = new TestEntity("info1");
        TestEntity te2 = new TestEntity("info2");
        TestEntity te3 = new TestEntity("info3");
        TestEntity te4 = new TestEntity("info4");
        TestEntity te5 = new TestEntity("info5");
        em.persist(te1);
        em.persist(te2);
        em.persist(te3);
        em.persist(te4);
        em.persist(te5);
    }
}