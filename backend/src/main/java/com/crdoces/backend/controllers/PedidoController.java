package com.crdoces.backend.controllers;

import com.crdoces.backend.domain.pedido.Pedido;
import com.crdoces.backend.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        pedido.setStatus("pendente");
        Pedido savedPedido = repository.save(pedido);
        return ResponseEntity.ok(savedPedido);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Pedido> updateStatus(@PathVariable Long id, @RequestBody String newStatus) {
        Pedido pedido = repository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(newStatus.replace("\"", ""));
        repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}