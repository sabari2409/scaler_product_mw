package com.scaler.product.dto.mapper;

import java.util.List;

public interface IMapper<E, D> {

    D toDTO(E entity);

    E toEntity(D dto);

    List<D> toDTOList(List<E> entityList);
}
