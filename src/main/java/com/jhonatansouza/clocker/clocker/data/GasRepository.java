package com.jhonatansouza.clocker.clocker.data;

import com.jhonatansouza.clocker.clocker.model.GasEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GasRepository extends JpaRepository<GasEntity, Long> {

}
