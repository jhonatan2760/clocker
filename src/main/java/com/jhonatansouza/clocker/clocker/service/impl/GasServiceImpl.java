package com.jhonatansouza.clocker.clocker.service.impl;

import com.jhonatansouza.clocker.clocker.data.GasRepository;
import com.jhonatansouza.clocker.clocker.model.GasEntity;
import com.jhonatansouza.clocker.clocker.service.GasService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
        return this.insert(gasEntity);
    }

    @Override
    public List<GasEntity> findAll() {
        return this.findAll();
    }
}
