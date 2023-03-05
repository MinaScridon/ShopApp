package com.demoApp.mapper;

public interface Mapper<E, D>{

    D convertToDto(E entity);
    E convertToEntity(D dto);
}
