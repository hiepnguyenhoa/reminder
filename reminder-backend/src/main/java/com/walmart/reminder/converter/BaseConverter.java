package com.walmart.reminder.converter;

import com.walmart.reminder.entity.BaseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

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
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
        return target;
    }

    static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

}
