package br.com.bluesoft.alucar.comissao;

import br.com.bluesoft.alucar.model.Aluguel;

import java.math.BigDecimal;

public abstract class Comissao {

    protected Comissao comissao;

    public Comissao(Comissao comissao) {
        this.comissao = comissao;
    }


    public BigDecimal calcular(Aluguel aluguel) {
        if (aplicavel(aluguel))
            return efetuaCalculo(aluguel);
        return comissao.calcular(aluguel);
    }

    protected abstract BigDecimal efetuaCalculo(Aluguel aluguel);
    public abstract Boolean aplicavel(Aluguel aluguel);
}
