package com.jhonatansouza.clocker.clocker.service.impl;

import com.jhonatansouza.clocker.clocker.data.GasRepository;
import com.jhonatansouza.clocker.clocker.model.GasEntity;
import com.jhonatansouza.clocker.clocker.service.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GasServiceImpl implements GasService {

    private GasRepository gasRepository;

    @Autowired
    public GasServiceImpl(GasRepository gasRepository){
        this.gasRepository = gasRepository;
    }

    @Override
    public GasEntity insert(GasEntity gasEntity) {
        return this.gasRepository.save(gasEntity);
    }

    @Override
    public Page<GasEntity> findAll(Pageable pageable) {
        return this.gasRepository.findAll(pageable);
    }
}
