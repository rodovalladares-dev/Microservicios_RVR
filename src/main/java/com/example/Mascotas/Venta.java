package com.example.Mascotas;

import java.util.List;

public class Venta {
    private int id_venta;
    private String fecha;
    private Cliente cliente;
    private List<Producto> productos;
    private int total;


    // Getters y setters
    public int getId_venta() 
    { 
        return id_venta;
     }

    public String getFecha() 
    { 
        return fecha; 
    }

    public Cliente getCliente() 
    { 
        return cliente; 
    }


    public List<Producto> getProductos() 
    { 
        return productos; 
    }


    public int getTotal() 
    { 
        return total; 
    }
 

}