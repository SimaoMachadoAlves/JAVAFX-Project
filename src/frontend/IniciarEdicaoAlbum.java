package frontend;

import backend.Album;
import backend.Musica;
import backend.Produtor;
import backend.SessaoGravacao;
import backend.Sistema;
import backend.Utilizador;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IniciarEdicaoAlbum {

    public void mensagem(Sistema sistema, Consola consola, Utilizador u) {
        int opcao;
        do {
            consola.escrever("\n\n[1] Voltar ao menu anterior");
            consola.escrever("\n[2] Voltar a iniciar edição de um álbum\n");
            opcao = consola.lerInteiro("-> ");
            
            switch (opcao) {
                case 1:
                    break;

                case 2:
                    iniciarEdicaoAlbum(sistema, consola, u);
                    break;

                default:
                    consola.escrever("\nOpção inválida!");
            }
        } while (opcao != 1 && opcao != 2);
    }
    
    /*MENU PRODUTOR*/
    public void iniciarEdicaoAlbum(Sistema sistema, Consola consola, Utilizador u) {
        consola.cls();
        consola.escrever("- EDIÇÃO DE UM ÁLBUM -\n\n");

        Album a = new Album();
        Musica m = new Musica();
        SessaoGravacao s = new SessaoGravacao();
        LocalDate date, dateF;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int aux = 0;

        consola.escrever("Álbuns existentes\n\n"+sistema.getAlbuns().devolverRegistoAlbum());
        
        int codAlbum = consola.lerInteiro("\n\nCódigo do álbum que pretende iniciar edição: ");

        //verificar se o album existe e se o produtor em questão é "dono" desse album
        if (sistema.getAlbuns().verificarSeExisteAlbum(codAlbum) && sistema.getAlbuns().devolverUsernameProdutorAlbum(codAlbum).equals(u.getUsername())) {

            a = sistema.getAlbuns().devolverAlbum(codAlbum );
            a.setProdutor((Produtor) u);

            date = consola.lerDataFuturaBuffer("Data de edição do álbum (formato dd/MM/yyyy): ");
            a.setDataAlbum(date);

            int num = consola.lerInteiro("Número de sessões do álbum: ");
            a.setNumSessoesAlbum(num);

            sistema.getAlbuns().inserirDadosAlbum(codAlbum, date, num);

            for (int i = 0; i < num; i++) {
                int cod = consola.lerInteiro("\nIntroduza o código da sessão " + (i+1) + ": ");
                while (sistema.getSessoesGrav().verificarSeExisteSessaoGrav(cod)) {
                    cod = consola.verificarCodigos(cod);
                }
                s.setCodigoSessao(cod);
                
                consola.escrever("\nMúsicas pertencentes ao álbum:\n\n" +sistema.getAlbuns().devolverAlbum(codAlbum).getMapSongs());
                int codMusica = consola.lerInteiro("\nCódigo da música que pretende gravar nesta sessão de gravação: ");
                while(!sistema.getAlbuns().devolverAlbum(codAlbum).verificarSeExisteMusicaNoAlbum(codMusica)){
                    consola.escrever("\nEssa música não pertence ao álbum!");
                    codMusica = consola.lerInteiro("\nIntroduza outro código: ");
                }
                s.setMusica(sistema.getMusicas().devolverMusica(codMusica));
                
                s.setNomeSessao("Sessão " + (i+1));

                if (i == 0) {
                    consola.escrever("Data de agendamento desta sessão: " + dtf.format(date));
                    s.setDataInicialSessao(date);
                } else {
                    LocalDate dateAux = sistema.getSessoesGrav().devolverDataSessaoGravacao(aux, 1);
                    dateF = consola.lerDataFuturaBuffer("Data de agendamento desta sessão (formato dd/MM/yyyy): ");
                    while (dateF.isBefore(dateAux) || dateF.isEqual(dateAux)) {
                        consola.escrever("\nERRO! A data desta sessão deve ser posterior à data prevista de conclusão da sessão anterior!\nData prevista de conclusão da sessão anterior: " + dtf.format(sistema.getSessoesGrav().devolverDataSessaoGravacao(aux, 1)));
                        dateF = consola.lerDataFutura("\nIntroduza uma data posterior: ");
                    }
                    s.setDataInicialSessao(dateF);
                }
                
                for(int j = 0; j < sistema.getAlbuns().devolverAlbum(codAlbum).getMapSongs().size(); j++){
                    s.setMapMusicos(sistema.getAlbuns().devolverAlbum(codAlbum).devolverMusica().getMapMusicos());
                }
                
                aux = cod;
                s.setEstadoSessao("Não iniciado");
                s.setAlb(a);

                sistema.getSessoesGrav().inserir(s);
                dateF = consola.lerDataFuturaBuffer("\nData prevista de conclusão desta sessão (formato dd/MM/yyyy): ");
                while (dateF.isBefore(sistema.getSessoesGrav().devolverDataSessaoGravacao(aux, 2))) {
                    consola.escrever("\nERRO! A data prevista de conclusão deve ser posterior à data de agendamento desta sessão!\nData de agendamento desta sessão: " + dtf.format(sistema.getSessoesGrav().devolverDataSessaoGravacao(aux, 2)));
                    dateF = consola.lerDataFutura("\nIntroduza uma data: ");
                }
                
                s.setDataFinalSessao(dateF);
                s = new SessaoGravacao();
            }
            mensagem(sistema, consola, u);
        }
        else if(!sistema.getAlbuns().verificarSeExisteAlbum(codAlbum)){
            consola.escrever("\nERRO! Não existe esse album!");
            mensagem(sistema, consola, u);
        }
        else if(!sistema.getAlbuns().devolverUsernameProdutorAlbum(codAlbum).equals(u.getUsername())){
            consola.escrever("\nERRO! Este album não é seu!");
            mensagem(sistema, consola, u);
        }
    }
}