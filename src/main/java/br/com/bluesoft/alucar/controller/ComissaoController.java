package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.dto.ComissaoRelatorioDto;
import br.com.bluesoft.alucar.repository.ComissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comissao")
public class ComissaoController {

    @Autowired
    private ComissaoRepository comissaoRepository;

    @GetMapping("relatorio/todos-vendedores")
    public List<ComissaoRelatorioDto> listAllForEachVendedor() {
//        comissaoRepository.listAllGroupedByVendedor();
        return null;
    }

    @GetMapping("relatorio/vendedor/{id}")
    public List<ComissaoRelatorioDto> listAllByVendedor(@PathVariable Integer id) {
        return null;
    }
}
