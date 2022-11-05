package br.com.bluesoft.alucar.comissao;

import br.com.bluesoft.alucar.model.Aluguel;

import java.math.BigDecimal;

public class ComissaoVendedorNormal extends Comissao {

    public ComissaoVendedorNormal() {
        super(null);
    }

    @Override
    protected BigDecimal efetuaCalculo(Aluguel aluguel) {
        return aluguel.getValorTotal().multiply( new BigDecimal("0.1") );
    }

    @Override
    public Boolean aplicavel(Aluguel aluguel) {
        return true;
    }
}
