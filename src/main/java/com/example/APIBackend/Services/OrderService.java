package com.example.APIBackend.Services;

import com.example.APIBackend.Models.Food;
import com.example.APIBackend.Models.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<Order> lista_pedidos = new ArrayList<>();

    public List<Order> obtenerPedidos() {
        //Listar en Array...
        return lista_pedidos;
    }

    public List<Food> obtenerMenus(){
        List<Food> menu = new ArrayList<>();
        menu.add(new Food("Hamburger", "A delicious hamburger", 5.99));
        menu.add(new Food("Pizza", "A cheesy pizza", 8.99));
        menu.add(new Food("Salad", "A healthy salad", 4.99));
        return menu;
    }

    public void insertarPedido(Order request){
        lista_pedidos.add(request);
    }

    public Order obtenerIdPedido(Integer pedidoId) {
        return lista_pedidos.stream()
                .filter(order -> order.getId().equals(pedidoId))
                .findFirst()
                .orElse(null);
    }

    public void eliminarPedido(Integer pedidoId) {
        lista_pedidos.removeIf(order -> order.getId().equals(pedidoId));
    }

}
