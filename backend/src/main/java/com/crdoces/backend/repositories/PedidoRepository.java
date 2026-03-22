package com.crdoces.backend.repositories;

import com.crdoces.backend.domain.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}