package com.jhonatansouza.clocker.clocker.data;

import com.jhonatansouza.clocker.clocker.model.GasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GasRepository extends JpaRepository<GasEntity, Long> {

    @Query(value = "SELECT * From GAS_ENTITY g ORDER BY g.id DESC LIMIT 10", nativeQuery = true)
    List<GasEntity> getLast10Pulses();

}
