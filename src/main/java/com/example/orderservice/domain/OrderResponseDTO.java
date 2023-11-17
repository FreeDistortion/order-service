package com.example.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

// DB에서 조회한 주문 정보를 담을 DTO, 얘가 json으로 변환돼서 client로 전송될 거.

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {

    private Long orderId;
    private String addr;
    private Long customerId;
    private Date ordeDate;
    private List<OrderDetailResponseDTO> orderproductlist;
}
