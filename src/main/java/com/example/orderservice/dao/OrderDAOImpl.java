package com.example.orderservice.dao;

import com.example.orderservice.domain.OrderEntity;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Slf4j
@RequiredArgsConstructor
public class OrderDAOImpl implements OrderDAO{
    private final OrderRepository repository;
    @Override
    public void save(OrderEntity orderEntity) {
        repository.save(orderEntity);
    }

    @Override
    public OrderEntity findById(Long orderId) {
        return null;
    }

    @Override
    public List<OrderEntity> getOrders(Long customerId) {
        List<OrderEntity> orderList = repository.findByCustomerId(customerId);
        log.info("@@@@@@@@@findByCustomerId: {}",orderList);
        log.info("@@@@@@@@@findByCustomerId.get(0).getOrderProductList(): {}",orderList.get(0).getOrderproductlist());
        return null;

    }
}
