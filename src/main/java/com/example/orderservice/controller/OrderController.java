package com.example.orderservice.controller;

import com.example.orderservice.domain.OrderRequestDTO;
import com.example.orderservice.domain.OrderResponseDTO;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService service;
    @PostMapping("/create")
    public void create(@RequestBody OrderRequestDTO order){
        log.info("주문내역==>{}",order);
        service.save(order);//주문하기
    }

    @GetMapping("/getOrders/{customerId}")
    public List<OrderResponseDTO> getOrders(@PathVariable Long customerId){
        List<OrderResponseDTO> responseList = service.findAllByCustomerId(customerId);
        log.info("주문 내역: {}",responseList);
        return responseList;
    }
}

