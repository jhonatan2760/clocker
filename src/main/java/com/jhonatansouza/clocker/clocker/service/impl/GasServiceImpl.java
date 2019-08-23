package com.jhonatansouza.clocker.clocker.service.impl;

import com.jhonatansouza.clocker.clocker.data.GasRepository;
import com.jhonatansouza.clocker.clocker.model.GasEntity;
import com.jhonatansouza.clocker.clocker.service.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<GasEntity> findAll() {
        return this.gasRepository.getLast10Pulses();
    }
}
