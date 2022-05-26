package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    private PessoaFisica pessoaFisica;
    private String cargo;
    private Double salario;
}
