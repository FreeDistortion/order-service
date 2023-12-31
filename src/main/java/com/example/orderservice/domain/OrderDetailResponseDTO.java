package com.example.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailResponseDTO {
    private Long orderDetailId;
    private Long productNo;
    private int orderPrice;
    private int count;
}
