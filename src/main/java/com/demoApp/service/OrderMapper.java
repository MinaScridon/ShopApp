package com.demoApp.service;

import com.demoApp.dto.OrderDto;
import com.demoApp.entities.Order;
import com.demoApp.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderMapper implements Mapper<Order, OrderDto> {
/*
    public List<OrderDto> listConvertToDto(List<Order> entity){
        List<OrderDto> result = new ArrayList<>();
        for (Order order : entity) {
            OrderDto dto = convertToDto(order);
            result.add(dto);
        }
        return result;
    }

    public Set<Order> listConvertToEntity(Set<OrderDto> dto){
        Set<Order> result = new HashSet<>();
        for (OrderDto order2 : dto) {
            Order order = convertToEntity(order2);
            result.add(order);
        }
        return result;
    }
*/
    @Autowired
    private ProductMapper productMapper;

    @Override
    public OrderDto convertToDto(Order entity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(entity.getId());
        orderDto.setName(entity.getName());
        orderDto.setOrderNumber(entity.getOrderNumber());
        orderDto.setQuantity(entity.getQuantity());
        orderDto.setStatus(entity.getStatus());
        orderDto.setCreatedDate(entity.getCreatedDate());
      //  orderDto.setProductList(productMapper.listConvertToEntity(productMapper.listConvertToDto(entity.getProducts())));

        return orderDto;
    }

    @Override
    public Order convertToEntity(OrderDto dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setName(dto.getName());
        order.setOrderNumber(dto.getOrderNumber());
        order.setQuantity(dto.getQuantity());
        order.setStatus(dto.getStatus());
        if (dto.getCreatedDate() == null){
           // order.setCreatedDate(dto.getCreatedDate() ? LocalDate.now(): null);
            order.setCreatedDate(LocalDate.now());
        }

     //   order.setProducts(productMapper.listConvertToDto(dto.getProductList()));

        return order;
    }

}
