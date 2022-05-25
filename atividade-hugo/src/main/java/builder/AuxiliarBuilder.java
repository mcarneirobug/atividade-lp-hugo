package builder;

import model.Cliente;
import model.Funcionario;
import model.PessoaFisica;
import model.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class AuxiliarBuilder {

    private static final String ENDERECO = "Rua Schulambs";
    private static final String TELEFONE = "(31)99991111";
    private static final String CEP = "31800700";
    private static final String CIDADE = "Belo Horizonte";
    private static final String UF = "MG";

    private static final String NOME_INTER = "Inter";
    private static final String NOME_NUBANK = "Nubank";
    private static final String CNPJ_NUBANK = "18.236.120/0001-58";
    private static final String CNPJ_INTER = "00.416.968/0001-01";

    private static final String NOME_MATHEUS = "Matheus";
    private static final String NOME_RAISSA = "Raissa";
    private static final String CPF_MATHEUS = "12345678910";
    private static final String CPF_RAISSA = "12345678911";

    private static final Double LIMITE_CREDITO_CLIENTE = 10.0;

    private static final Double SALARIO_FUNCIONARIO = 15000.0;
    private static final String CARGO = "Engenheiro de Software";

    private static final String CARGO_PRESIDENTE = "Presidente";
    private static final Double SALARIO_PRESIDENTE = 25000.0;

    private static List<PessoaFisica> criarPessoasFisicas() {
        final var matheus = PessoaFisica.builder()
                .nome(NOME_MATHEUS)
                .endereco(ENDERECO)
                .telefone(TELEFONE)
                .cep(CEP)
                .cidade(CIDADE)
                .uf(UF)
                .cpf(CPF_MATHEUS)
                .build();

        final var raissa = PessoaFisica.builder()
                .nome(NOME_RAISSA)
                .endereco(ENDERECO)
                .telefone(TELEFONE)
                .cep(CEP)
                .cidade(CIDADE)
                .uf(UF)
                .cpf(CPF_RAISSA)
                .build();

        return List.of(matheus, raissa);
    }

    private static List<PessoaJuridica> criarPessoasJuridicas() {
        final var inter = PessoaJuridica.builder()
                .nome(NOME_INTER)
                .endereco(ENDERECO)
                .telefone(TELEFONE)
                .cep(CEP)
                .cidade(CIDADE)
                .uf(UF)
                .cnpj(CNPJ_INTER)
                .build();

        final var nubank = PessoaJuridica.builder()
                .nome(NOME_NUBANK)
                .endereco(ENDERECO)
                .telefone(TELEFONE)
                .cep(CEP)
                .cidade(CIDADE)
                .uf(UF)
                .cnpj(CNPJ_NUBANK)
                .build();

        return List.of(inter, nubank);
    }

    public static List<Cliente> criarClientes() {
        final var pessoasFisicas = criarPessoasFisicas();
        final var pessoasJuridicas = criarPessoasJuridicas();
        final List<Cliente> clientes = new ArrayList<>();

        pessoasFisicas.forEach(pf -> {
            final var cliente = Cliente.builder()
                    .pessoa(pf)
                    .limiteCredito(LIMITE_CREDITO_CLIENTE)
                    .build();

            clientes.add(cliente);
        });

        pessoasJuridicas.forEach(pj -> {
            final var cliente = Cliente.builder()
                    .pessoa(pj)
                    .limiteCredito(LIMITE_CREDITO_CLIENTE)
                    .build();

            clientes.add(cliente);
        });

        return clientes;
    }

    public static List<Funcionario> criarFuncionarios() {
        final var pessoasJuridicas = criarPessoasJuridicas();
        final List<Funcionario> funcionarios = new ArrayList<>();

        pessoasJuridicas.forEach(pj -> {
            final var funcionario = Funcionario.builder()
                    .pessoaJuridica(pj)
                    .cargo(CARGO)
                    .salario(SALARIO_FUNCIONARIO)
                    .build();

            funcionarios.add(funcionario);
        });

        return funcionarios;
    }

    public static Funcionario criarPresidente() {
        return Funcionario.builder()
                .cargo(CARGO_PRESIDENTE)
                .salario(SALARIO_PRESIDENTE)
                .build();
    }
}
