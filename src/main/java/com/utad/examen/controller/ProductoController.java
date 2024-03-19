package com.utad.examen.controller;

import com.utad.examen.model.Producto;
import com.utad.examen.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// UrlBase = http://localhost:8080
// ruta Url = /api/v1/ejemplo
@RestController
@RequestMapping(path = "api/v1/ejemplo")
public class ProductoController {
    private final ProductoService productoService;

    // Inyección de dependencias
    @Autowired
    public ProductoController(ProductoService destinoService){
        this.productoService = destinoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAll() {
        List<Producto> list = productoService.getEjemplos();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Producto> addOrUpdate(@RequestBody Producto producto) {
        Producto addOrUpdateProducto = productoService.addOrUpdateEjemplo(producto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(addOrUpdateProducto);
    }

    @GetMapping("/{idDestino}")
    public ResponseEntity<Optional<Producto>> getById(@PathVariable Long idDestino) {
        Optional<Producto> ejemplo = Optional.ofNullable(productoService.getEjemploById(idDestino));

        if(ejemplo.isPresent()){
            return ResponseEntity.ok(ejemplo);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Producto>> getByCity(@PathVariable String city) {
        List<Producto> list = productoService.getEjemplosByCity(city);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Producto>> getByCountry(@PathVariable String country) {
        List<Producto> list = productoService.getEjemplosByCountry(country);
        return ResponseEntity.ok(list);
    }


    @DeleteMapping("/{idDestino}")
    public ResponseEntity<Optional<Producto>> delete(@PathVariable Long idDestino) {
        productoService.deleteEjemplo(idDestino);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/city/contains/{str}")
    public ResponseEntity<List<Producto>> getByCityContains(@PathVariable String str) {
        List<Producto> list = productoService.getEjemplosByCityContains(str);
        return ResponseEntity.ok(list);
    }

}