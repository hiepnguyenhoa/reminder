package com.walmart.reminder.converter;

import com.walmart.reminder.dto.StatusEnum;
import com.walmart.reminder.entity.StatusEntity;
import org.springframework.stereotype.Component;

/**
 * convert between dto object and entity object  which would throw an unchecked exception
 * Created by HiepNguyen on 7/2/2017.
 */
@Component
public class StatusConverter implements BaseConverter<StatusEnum, StatusEntity> {

    @Override
    public StatusEnum toDto(StatusEntity entity) {
        validateInput(entity);
        return StatusEnum.valueOf(entity.getCode());
    }

    @Override
    public StatusEntity toEntity(StatusEnum statusEnum) {
        validateInput(statusEnum);
        StatusEntity entity = new StatusEntity();
        entity.setCode(statusEnum.getCode());
        return entity;
    }
}
