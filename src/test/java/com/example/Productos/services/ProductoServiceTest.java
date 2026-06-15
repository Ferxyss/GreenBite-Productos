package com.example.Productos.services;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.Productos.dtos.ProductoRequestDTO;
import com.example.Productos.dtos.ProductoResponseDTO;
import com.example.Productos.models.Producto;
import com.example.Productos.repositories.ProductoRepository;

public class ProductoServiceTest {
    private ProductoRepository productoRepository;
    private ProductoServiceImpl productoService;

    @BeforeEach
    void setup() {
        productoRepository = Mockito.mock(ProductoRepository.class);
        productoService = new ProductoServiceImpl(productoRepository);
    }

    @Test
    void deberiaGuardarProducto() {

        ProductoRequestDTO dto = new ProductoRequestDTO();

        dto.setNombre("Caja Verde");
        dto.setPrecio(15000.0);
        dto.setStock(10);

        Producto productoGuardado = new Producto(
                "1",
                dto.getNombre(),
                dto.getPrecio(),
                dto.getStock()
        );

        when(productoRepository.save(any(Producto.class)))
                .thenReturn(productoGuardado);

        ProductoResponseDTO response =
                productoService.guardarProducto(dto);
        assertNotNull(response);
        assertEquals("Caja Verde", response.getNombre());
        verify(productoRepository, times(1))
                .save(any(Producto.class));
    }

    @Test
    void deberiaListarProductos() {

        List<Producto> productos = List.of(
                new Producto("1", "Caja 1", 10000.0, 5),
                new Producto("2", "Caja 2", 20000.0, 10)
        );

        when(productoRepository.findAll()).thenReturn(productos);
        List<ProductoResponseDTO> resultado =
                productoService.listarProductos();
        assertEquals(2, resultado.size());
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    void deberiaObtenerProductoPorId() {
        Producto producto = new Producto(
                "1",
                "Caja Premium",
                25000.0,
                8
        );

        when(productoRepository.findById("1"))
                .thenReturn(Optional.of(producto));
        ProductoResponseDTO response =
                productoService.obtenerProductoPorId("1");
        assertEquals("Caja Premium", response.getNombre());
    }

    @Test
    void deberiaEliminarProducto() {
        productoService.eliminarProducto("1");
        verify(productoRepository, times(1))
                .deleteById("1");
    }
}