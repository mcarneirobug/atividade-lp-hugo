import model.*;

import java.util.List;
import java.util.function.Supplier;

import static builder.AuxiliarBuilder.*;

public class App {

    public static void main(String[] args) {

        final var clientes = criarClientes();
        final var funcionarios = criarFuncionarios();
        final var presidente = criarPresidente();

        final var ambev = Empresa.builder()
                .clientes(clientes)
                .funcionarios(funcionarios)
                .presidente(presidente)
                .build();

        final var nestle = Empresa.builder()
                .clientes(clientes)
                .funcionarios(funcionarios)
                .presidente(presidente)
                .build();

        Supplier<List<Empresa>> empresas = () -> List.of(ambev, nestle);

        empresas.get().forEach(System.out::println);
    }

}
