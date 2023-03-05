package com.demoApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private int orderNumber;

    @NotEmpty
    private  int quantity;

    @NotEmpty
    private String status;

    @NotEmpty
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdDate;

    private List<ProductDto> productList;
}
