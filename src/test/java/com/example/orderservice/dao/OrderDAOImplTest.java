package com.example.orderservice.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderDAOImplTest {
    @Autowired
    OrderDAOImpl orderDAO;

    @Test
    void test(){
        orderDAO.getOrders(1L);
    }

}