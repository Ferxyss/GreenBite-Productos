package com.example.Productos.services;

import java.util.List;

import com.example.Productos.dtos.ProductoRequestDTO;
import com.example.Productos.dtos.ProductoResponseDTO;

public interface ProductoService {

    List<ProductoResponseDTO> listarProductos();

    ProductoResponseDTO guardarProducto(ProductoRequestDTO dto);

    ProductoResponseDTO obtenerProductoPorId(String id);

    void eliminarProducto(String id);
}