package com.jhonatansouza.clocker.clocker.service;

import com.jhonatansouza.clocker.clocker.model.GasEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface GasService {

    GasEntity insert(GasEntity gasEntity);
    Page<GasEntity> findAll(Pageable pageable);

}
