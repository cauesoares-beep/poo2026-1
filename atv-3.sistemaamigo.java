import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {

        List<Mensagem> resultado = new ArrayList<>();

        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                resultado.add(m);
            }
        }

        return resultado;
    }

    public void configuraAmigoSecretoDe(
            String emailDaPessoa,
            String emailAmigoSorteado)
            throws AmigoInexistenteException {

        Amigo amigo = pesquisaAmigo(emailDaPessoa);

        amigo.setAmigoSorteado(emailAmigoSorteado);
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException,
                   AmigoNaoSorteadoException {

        Amigo amigo = pesquisaAmigo(emailDaPessoa);

        if (amigo.getEmailAmigoSorteado() == null) {
            throw new AmigoNaoSorteadoException(
                    "Amigo ainda não sorteado");
        }

        return amigo.getEmailAmigoSorteado();
    }

    public Amigo pesquisaAmigo(String email)
            throws AmigoInexistenteException {

        for (Amigo a : amigos) {
            if (a.getEmail().equals(email)) {
                return a;
            }
        }

        throw new AmigoInexistenteException(
                "Amigo inexistente");
    }
}
