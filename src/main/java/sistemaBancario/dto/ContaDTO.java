package sistemaBancario.dto;

import sistemaBancario.models.Conta;

public class ContaDTO {
    private String nome;
    private Double saldo;

    public ContaDTO(Conta conta) {
        this.nome = conta.getNome();
        this.saldo = conta.getSaldo();
    }
}
