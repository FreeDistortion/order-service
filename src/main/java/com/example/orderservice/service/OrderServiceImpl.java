package com.example.orderservice.service;

import com.example.orderservice.dao.OrderDAO;
import com.example.orderservice.dao.OrderProductDAO;
import com.example.orderservice.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderDAO dao; //주문의 일반적인 내용
    private final OrderProductDAO detaildao;//주문한 상품에 대한 정보

    @Override
    public void save(OrderRequestDTO orderrequest) {
        //  //주문한상품들에 대한 정보를 저장할 수 있도록 생성
        ModelMapper mapper = new ModelMapper();
        log.info("orderdetaillist=>{}", orderrequest);
        List<OrderProductEntity> detaillist = orderrequest.getOrderDetailDTOList().stream()
                .map((detailDTO) -> {
                    return mapper.map(detailDTO, OrderProductEntity.class);
                }).collect(Collectors.toList());
        log.info("================================================");
        log.info("orderdetaillist=>{}", detaillist);
        log.info("================================================");
        //주문생성
        OrderEntity orderEntity =
                OrderEntity.makeOrderEntity(orderrequest.getAddr(), orderrequest.getCustomerId(), detaillist);
        log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        log.info("저장전:{}", orderEntity);

        // 양방향돤게의 경우 parent와 child table의 data를 모두 persist해주면서, parent에 record를 저장할 때 child의 record에 대한 저장을 한 번에 같이 진행 가능.
        // entity에 cascadetype을 ALL로 정의한다.
        dao.save(orderEntity);

        detaildao.save(orderEntity.getOrderproductlist());
    }

    @Override
    public OrderResponseDTO findById(Long orderId) {
        return null;
    }

    @Override
    public List<OrderResponseDTO> findAllByCustomerId(Long customerId) {
        // dao의 method를 호출하고 데이터를 반환
        List<OrderEntity> orders = dao.getOrders(customerId);
        ModelMapper mapper=new ModelMapper();
        List<OrderResponseDTO> orderList =
                orders.stream()
                        .map(orderEntity ->
                                mapper.map(orderEntity,OrderResponseDTO.class))
                        .collect(Collectors.toList());

        return orderList;
    }
}
