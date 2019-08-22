package com.jhonatansouza.clocker.clocker.data;

import com.jhonatansouza.clocker.clocker.model.GasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GasRepository extends JpaRepository<GasEntity, Long> {
}
