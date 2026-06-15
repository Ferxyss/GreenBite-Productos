package com.example.Productos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Productos.dtos.ProductoRequestDTO;
import com.example.Productos.dtos.ProductoResponseDTO;
import com.example.Productos.models.Producto;
import com.example.Productos.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoResponseDTO> listarProductos() {
        return productoRepository.findAll()
                .stream()
                .map(this::convertirAResponseDTO)
                .toList();
    }

    @Override
    public ProductoResponseDTO guardarProducto(ProductoRequestDTO dto) {

        Producto producto = new Producto();

        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());

        Producto guardado = productoRepository.save(producto);

        return convertirAResponseDTO(guardado);
    }

    @Override
    public ProductoResponseDTO obtenerProductoPorId(String id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return convertirAResponseDTO(producto);
    }

    @Override
    public void eliminarProducto(String id) {
        productoRepository.deleteById(id);
    }

    private ProductoResponseDTO convertirAResponseDTO(Producto producto) {
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock()
        );
    }
}