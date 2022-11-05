package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.dto.ComissaoRelatorioDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comissao")
public class ComissaoController {

    @GetMapping
    public List<ComissaoRelatorioDto> listAll() {
        return null;
    }
}
