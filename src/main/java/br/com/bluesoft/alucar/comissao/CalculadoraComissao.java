package br.com.bluesoft.alucar.comissao;

import br.com.bluesoft.alucar.model.Aluguel;

import java.math.BigDecimal;

public class CalculadoraComissao {

    public BigDecimal calcula(Aluguel aluguel) {
        Comissao comissao = new ComissaoVendedorCincoAnos( new ComissaoVendedorNormal() );
        return comissao.calcular(aluguel);
    }
}
