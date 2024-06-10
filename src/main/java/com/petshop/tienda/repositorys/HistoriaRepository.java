package com.petshop.tienda.repositorys;

import com.petshop.tienda.models.Historia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaRepository extends JpaRepository<Historia, Long> {
}
