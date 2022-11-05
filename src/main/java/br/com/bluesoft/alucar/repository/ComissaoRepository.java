package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Comissao;
import br.com.bluesoft.alucar.model.projecao.ComissaoProjecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComissaoRepository extends JpaRepository<Comissao, Integer> {

    @Query(value = "" +
            "select v.nome, v.cpf, sum(c.valor) as valor " +
            "from vendedor v " +
            "inner join comissao c on c.vendedor_key = v.vendedor_key " +
            "group by v.nome, v.cpf " +
            "order by 1",
        nativeQuery = true)
    List<ComissaoProjecao> listAllGroupedByAllVendedor();
}
