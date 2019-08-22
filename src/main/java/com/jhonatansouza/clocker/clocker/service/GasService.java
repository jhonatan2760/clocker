package com.jhonatansouza.clocker.clocker.service;

import com.jhonatansouza.clocker.clocker.model.GasEntity;
import com.sun.tools.javac.util.List;

public interface GasService {
    GasEntity insert(GasEntity gasEntity);
    List<GasEntity> findAll();
}
