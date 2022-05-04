package com.example.wcrud.api.mapper;

import org.mapstruct.Mapping;

import java.util.List;

public interface EntityMapper<E, T, D> {


    E toDomain(T requestDTO);

    D fromDomain(E entity);

    List<D> fromDomainList(List<E> entityList);
}
