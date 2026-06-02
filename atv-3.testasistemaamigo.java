import java.util.List;

public class TestaSistemaAmigo {

    public static void main(String[] args) {

        SistemaAmigo sistema = new SistemaAmigo();

        sistema.cadastraAmigo(
                "Jose",
                "jose@email.com");

        sistema.cadastraAmigo(
                "Maria",
                "maria@email.com");

        try {

            sistema.configuraAmigoSecretoDe(
                    "jose@email.com",
                    "maria@email.com");

            sistema.configuraAmigoSecretoDe(
                    "maria@email.com",
                    "jose@email.com");

        } catch (AmigoInexistenteException e) {

            System.out.println(e.getMessage());
        }

        sistema.enviarMensagemParaAlguem(
                "Oi José!",
                "maria@email.com",
                "jose@email.com",
                true);

        sistema.enviarMensagemParaTodos(
                "Boa sorte para todos!",
                "maria@email.com",
                true);

        List<Mensagem> anonimas =
                sistema.pesquisaMensagensAnonimas();

        for (Mensagem m : anonimas) {

            System.out.println(
                    m.getTextoCompletoAExibir());
        }

        try {

            String amigo =
                    sistema.pesquisaAmigoSecretoDe(
                            "jose@email.com");

            if (amigo.equals("maria@email.com")) {
                System.out.println("Ok");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
