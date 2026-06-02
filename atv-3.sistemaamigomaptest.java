package br.ufpb.dcx.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {

    private Map<String, Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigoMap() {
        this.amigos = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo)
            throws AmigoJaExisteException {

        if (amigos.containsKey(emailAmigo)) {
            throw new AmigoJaExisteException(
                    "Já existe amigo com este e-mail");
        }

        amigos.put(emailAmigo,
                new Amigo(nomeAmigo, emailAmigo));
    }

    public Amigo pesquisaAmigo(String emailAmigo)
            throws AmigoInexistenteException {

        Amigo amigo = amigos.get(emailAmigo);

        if (amigo == null) {
            throw new AmigoInexistenteException(
                    "Amigo não encontrado");
        }

        return amigo;
    }

    public void enviarMensagemParaTodos(
            String texto,
            String emailRemetente,
            boolean ehAnonima) {

        mensagens.add(
                new MensagemParaTodos(
                        texto,
                        emailRemetente,
                        ehAnonima));
    }

    public void enviarMensagemParaAlguem(
            String texto,
            String emailRemetente,
            String emailDestinatario,
            boolean ehAnonima) {

        mensagens.add(
                new MensagemParaAlguem(
                        texto,
                        emailRemetente,
                        emailDestinatario,
                        ehAnonima));
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {

        List<Mensagem> anonimas =
                new ArrayList<>();

        for (Mensagem m : mensagens) {

            if (m.ehAnonima()) {
                anonimas.add(m);
            }
        }

        return anonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configuraAmigoSecretoDe(
            String emailDaPessoa,
            String emailAmigoSorteado)
            throws AmigoInexistenteException {

        Amigo amigo =
                pesquisaAmigo(emailDaPessoa);

        amigo.setAmigoSorteado(
                emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(
            String emailDaPessoa)
            throws AmigoInexistenteException,
                   AmigoNaoSorteadoException {

        Amigo amigo =
                pesquisaAmigo(emailDaPessoa);

        if (amigo.getEmailAmigoSorteado()
                == null) {

            throw new AmigoNaoSorteadoException(
                    "Amigo não sorteado");
        }

        return amigo.getEmailAmigoSorteado();
    }
}
