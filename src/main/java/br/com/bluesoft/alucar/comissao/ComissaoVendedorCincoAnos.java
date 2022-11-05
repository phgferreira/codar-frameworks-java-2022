package br.com.bluesoft.alucar.comissao;

import br.com.bluesoft.alucar.model.Aluguel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class ComissaoVendedorCincoAnos extends Comissao {
    public ComissaoVendedorCincoAnos(Comissao comissao) {
        super(comissao);
    }

    @Override
    protected BigDecimal efetuaCalculo(Aluguel aluguel) {
        return aluguel.getValorTotal().multiply(new BigDecimal("0.13") );
    }

    @Override
    public Boolean aplicavel(Aluguel aluguel) {
        return Period.between( aluguel.getVendedor().getDataAdmissao(), aluguel.getDataCriacao())
                .getYears() > 5;
    }
}
