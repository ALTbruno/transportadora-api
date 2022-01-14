package com.ALTbruno.transportadoraapi.domain.repository;

import com.ALTbruno.transportadoraapi.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
