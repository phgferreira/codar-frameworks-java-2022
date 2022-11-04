package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carro")
public class CarroController {

    @Autowired
    private CarroRepository caroCarroRepository;

    @PostMapping
    public void insert() {

    }

    @PutMapping
    public void pudate() {

    }

    @DeleteMapping
    public void delete() {

    }

    @GetMapping("{id}")
    public void findById() {

    }

    @GetMapping
    public void listAll() {

    }
}
