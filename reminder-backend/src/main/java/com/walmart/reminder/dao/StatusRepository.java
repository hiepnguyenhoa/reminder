package com.walmart.reminder.dao;

import com.walmart.reminder.entity.StatusEntity;
import org.springframework.data.repository.query.Param;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
public interface StatusRepository extends BaseRepository<StatusEntity> {

    Optional<StatusEntity> getByCode(String code);

    @QueryParam("SELECT s FROM StatusEntity e WHERE e.code IN (:codes)")
    List<StatusEntity> getAllByCode(@Param("codes") List<String> codes);

}
