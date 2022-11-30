package com.hanuiijjang.assignment1.model.mapper;

public interface GenericMapper<D, E> {
    E toEntity(final D dto);

    D toDto(final E entity);
}
