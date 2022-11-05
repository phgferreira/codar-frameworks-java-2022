package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Comissao;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.model.projecao.ComissaoProjecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComissaoRepository extends JpaRepository<Comissao, Integer> {

    @Query(value = "" +
            "select v.nome, v.cpf, cc.banco, cc.agencia, cc.conta_corrente, sum(cm.valor) as valor " +
            "from vendedor v " +
            "inner join comissao cm on cm.vendedor_key = v.vendedor_key " +
            "inner join conta_corrente cc on cc.vendedor_key = v.vendedor_key " +
            "group by v.nome, v.cpf, cc.banco, cc.agencia, cc.conta_corrente " +
            "order by 1",
        nativeQuery = true)
    List<ComissaoProjecao> listAllGroupedByAllVendedor();

    @Query("" +
            "select v.nome as nome, v.cpf as cpf, " +
            "cc.banco as banco, cc.agencia as agencia, cc.contaCorrente as contaCorrente, " +
            "sum(cm.valor) as valor " +
            "from Comissao cm " +
            "inner join cm.vendedor v " +
            "inner join ContaCorrente cc on cc.vendedor.vendedorKey = v.vendedorKey " +
            "where v.vendedorKey = :vendedorKey " +
            "group by v.nome, v.cpf, cc.banco, cc.agencia, cc.contaCorrente")
    ComissaoProjecao getComissaoOfOneVendedor(Integer vendedorKey);

}
