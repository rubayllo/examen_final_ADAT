package com.utad.examen.service;

import com.utad.examen.model.Producto;
import com.utad.examen.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getEjemplos(){
        return productoRepository.findAll();
    }

    public Producto getEjemploById(Long id){
        return productoRepository.findById(id).orElse(null);
    }

    public Producto addOrUpdateEjemplo(Producto producto){
        return productoRepository.save(producto);
    }

    public void deleteEjemplo(Long id){
        productoRepository.deleteById(id);
    }



    // Zona de Servicios creados en Repositorio
    public List<Producto> getEjemplosByCityContains(String str) {
            return productoRepository.findByCityContains(str);
    }

    public List<Producto> getEjemplosByCity(String city){
        return productoRepository.findByCityContainingIgnoreCase(city);
    }

    public List<Producto> getEjemplosByCountry(String country) {
        return productoRepository.findByCountryContainingIgnoreCase(country);
    }
}