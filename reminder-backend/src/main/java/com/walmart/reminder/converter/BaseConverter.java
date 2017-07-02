package com.walmart.reminder.converter;

import com.walmart.reminder.dto.BaseDto;
import com.walmart.reminder.entity.BaseEntity;
import org.springframework.beans.BeanUtils;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
public interface BaseConverter<DTO, ENTITY extends BaseEntity> {

    DTO toDto(ENTITY entity);

    ENTITY toEntity(DTO dto);

    default void validateInput(Object objcet) {
        if (objcet == null)
            throw new IllegalArgumentException();
    }

    default <E> E copyProperties(Object source, E target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }

}
