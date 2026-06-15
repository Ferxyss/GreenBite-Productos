package com.example.Productos.controllers;

import com.example.Productos.dtos.ProductoRequestDTO;
import com.example.Productos.dtos.ProductoResponseDTO;
import com.example.Productos.services.ProductoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")

public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoResponseDTO> listar() {
        return productoService.listarProductos();
    }

    @PostMapping
    public ProductoResponseDTO guardar(@Valid @RequestBody ProductoRequestDTO productoDTO) {
        return productoService.guardarProducto(productoDTO);
    }

    @GetMapping("/{id}")
    public ProductoResponseDTO obtenerPorId(@PathVariable String id) {
        return productoService.obtenerProductoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        productoService.eliminarProducto(id);
    }
}