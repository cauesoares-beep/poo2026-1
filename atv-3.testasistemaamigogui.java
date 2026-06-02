import java.util.Scanner;

public class TestaSistemaAmigoGUI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SistemaAmigo sistema = new SistemaAmigo();

        System.out.print("Quantidade de amigos: ");
        int qtd = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < qtd; i++) {

            System.out.println("\nAmigo " + (i + 1));

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            sistema.cadastraAmigo(nome, email);
        }

        System.out.println("\n===== SORTEIO =====");

        for (int i = 0; i < qtd; i++) {

            System.out.print("Email da pessoa: ");
            String pessoa = sc.nextLine();

            System.out.print("Email do amigo sorteado: ");
            String sorteado = sc.nextLine();

            try {

                sistema.configuraAmigoSecretoDe(
                        pessoa,
                        sorteado);

            } catch (AmigoInexistenteException e) {

                System.out.println(e.getMessage());
            }
        }

        System.out.println("\n===== MENSAGEM =====");

        System.out.print("Remetente: ");
        String remetente = sc.nextLine();

        System.out.print("Texto: ");
        String texto = sc.nextLine();

        System.out.print("Anonima? (true/false): ");
        boolean anonima =
                Boolean.parseBoolean(sc.nextLine());

        sistema.enviarMensagemParaTodos(
                texto,
                remetente,
                anonima);

        System.out.println("Mensagem enviada!");
    }
}
