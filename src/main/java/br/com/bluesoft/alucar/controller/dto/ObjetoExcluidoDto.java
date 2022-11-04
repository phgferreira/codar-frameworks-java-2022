package br.com.bluesoft.alucar.controller.dto;

public class ObjetoExcluidoDto {

    private String mensagem;

    public ObjetoExcluidoDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
