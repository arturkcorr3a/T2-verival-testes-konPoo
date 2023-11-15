import java.util.Scanner;
public class App {
    Controle controle = new Controle();
    Scanner in = new Scanner(System.in);

    public void run() {
    }

    public void novoLocal() {
        System.out.println("""
                ---- CADASTRAR NOVO DESTINO ----

                Insira a cidade:\s""");
        String cidade = in.nextLine();

        System.out.println("Insira o nome do destino: ");
        String nome = in.nextLine();
        // NAO SEI SE É ISSO OS 50KM DA DISTANCIA??
        if (controle.consultaAlgumDestinoJaCadastrado()) controle.novoLocal(cidade, nome, 50);
        else System.out.println("Informe a distância da origem: ");
        double distancia = in.nextDouble();
        controle.novoLocal(cidade, nome, distancia);
        System.out.println("Destino cadastrado.");
    }

    public void novoCaminhao() {
        System.out.println("""
                ---- CADASTRAR NOVO CAMINHÃO ----

                Insira o nome do caminhão:\s""");
        String nome = in.nextLine();

        if ((!controle.consultaNomeUnicoCaminhao(nome))) {
            int menu = 0;
            do {
                System.out.println("""
                        ERRO: CAMINHÃO JÁ CADASTRADO
                        Escolha uma opção:
                                                
                        [1] Continuar Cadastrando Outro Caminhão
                        [2] Sair""");
                menu = in.nextInt();
                switch (menu) {
                    case 1 -> {
                        System.out.println("Insira o nome do caminhão: ");
                        nome = in.nextLine();
                    }
                    case 2 -> System.out.println("Cadastro cancelado.");
                    default -> {
                        System.out.println("Opção inválida, cadastro cancelado.");
                        menu = 2;
                    }
                }
            } while (!controle.consultaNomeUnicoCaminhao(nome) || menu != 1);
        }
        System.out.println("\nInsira a autonomia do caminhão (Km/L): ");
        double autonomia = in.nextDouble();

        System.out.println("\nInsira a velocidade do caminhão: ");
        double velocidade = in.nextDouble();

        System.out.println("\nInsira o custo por Km do caminhão: ");
        double custoPorKm = in.nextDouble();

        controle.novoCaminhao(nome, autonomia, velocidade, custoPorKm);
        System.out.println("Caminhão cadastrado na frota");
    }
}
