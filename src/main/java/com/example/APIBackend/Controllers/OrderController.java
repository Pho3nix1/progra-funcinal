package com.example.APIBackend.Controllers;

import com.example.APIBackend.Models.Food;
import com.example.APIBackend.Models.Order;
import com.example.APIBackend.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/obtenerMenus")
    public List<Food> obtenerMenus() {
        return orderService.obtenerMenus();
    }

    @GetMapping("/obtenerPedidos")
    public List<Order> obtenerPedidos(){
        return orderService.obtenerPedidos();
    }

    @PostMapping("/insertarPedido")
    public ResponseEntity<String> insertarPedido(@RequestBody Order request) {
       orderService.insertarPedido(request);
        return ResponseEntity.ok("Pedido guardado con éxito");
    }

    @GetMapping("obtenerIdPedido/{pedidoId}")
    public Order obtenerIdPedido(@PathVariable Integer pedidoId) {
        return orderService.obtenerIdPedido(pedidoId);
    }

    @DeleteMapping("eliminarPedido/{pedidoId}")
    public ResponseEntity<String> eliminarPedido(@PathVariable Integer pedidoId) {
        orderService.eliminarPedido(pedidoId);
        return ResponseEntity.ok("Pedido eliminado con éxito");
    }

}