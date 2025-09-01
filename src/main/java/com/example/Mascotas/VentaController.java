package com.example.Mascotas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VentaController {
    //Lista en memoria que almacena las publicaciones cargadas desde el archivo.
    private List<Venta> ventas = new ArrayList<>();

    public VentaController() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/Data/ventas.json");
            ventas = mapper.readValue(inputStream, new TypeReference<List<Venta>>() {});
            System.err.println(ventas);
        } catch (Exception e) {
            System.err.println("Error al cargar ventas.json: " + e.getMessage());
        }
    }

    @GetMapping("/ventas")
    public List<Venta> getVentas() {
        return ventas;
    }

    @GetMapping("/ventas/{id}")
    public Venta getVentaById(@PathVariable int id) {
        for (Venta v : ventas) {
            if (v.getId_venta() == id) {
                return v;
            }
        }
        return null;
    }
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {

        Map<Integer, Cliente> clientesUnicos = new HashMap<>();
        for (Venta v : ventas) {
            Cliente c = v.getCliente();
            clientesUnicos.putIfAbsent(c.getId(), c);
        }
        return new ArrayList<>(clientesUnicos.values());
    }


    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
        return ventas.stream()
            .map(Venta::getCliente)
            .filter(c -> c.getId() == id)
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(null);

    
    }
    



    @GetMapping("/productos")
    public List<Producto> getProductos() {

        List<Producto> productos = new ArrayList<>();
        for (Venta v : ventas) {
            productos.addAll(v.getProductos());
        }
        return productos;
    }


    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
        return ventas.stream()
            .flatMap(v -> v.getProductos().stream())
            .filter(p -> p.getId() == id)
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(null);

    }


}