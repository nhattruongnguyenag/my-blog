package com.nhattruongnguyen.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E, D> {
    @Autowired
    private ModelMapper modelMapper;

    public D toDTO(E entity) {
        Type dtoClass = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        D dto = modelMapper.map(entity, dtoClass);
        return dto;
    }

    public E toEntity(D dto) {
        Type entityClass = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        E entity = modelMapper.map(dto, entityClass);
        return entity;
    }

    public List<D> toDTOGroup(List<E> entities) {
        return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
    }

    public List<E> toEntityGroup(List<D> dtos) {
        return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
    }

    public Page<D> toDTOPage(Page<E> pageEntity) {
        return new PageImpl(toDTOGroup(pageEntity.getContent()), pageEntity.getPageable(), pageEntity.getTotalPages());
    }
}
