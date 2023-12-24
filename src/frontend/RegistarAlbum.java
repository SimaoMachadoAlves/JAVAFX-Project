package frontend;

import backend.Album;
import backend.Musica;
import backend.Sistema;
import backend.Musico;

public class RegistarAlbum {

    /* MENU ADMINISTRADOR */
    public void registarAlbum(Sistema sistema, Consola consola) {
        consola.cls();
        Album a = new Album();
        
        consola.escrever("- REGISTAR ÁLBUM -\n\n");
        
        if(sistema.getUtilizadores().verificarProdutor()){
            int codAlbum = consola.lerInteiro("Código do álbum: ");
            while (sistema.getAlbuns().verificarSeExisteAlbum(codAlbum)) {
                /*consola.escrever("\nERRO! Username já existe!");
                cod = consola.lerInteiro("\nIntroduza outro username: ");*/
                consola.verificarCodigos(codAlbum);
            }
            a.setCodigoAlbum(codAlbum);

            String aux = consola.lerStringBuffer("Título do álbum: ");
            a.setTituloAlbum(aux);

            aux = consola.lerString("Username do Produtor associado a este álbum: ");
            while(!sistema.getUtilizadores().verificarSeExisteProdutor(aux)){
                consola.escrever("\nEsse Produtor não existe!");
                aux = consola.lerString("\nIntroduza outro username: ");
            }
            a.setProdutor(sistema.getUtilizadores().devolverProdutor(aux));

            consola.escrever("Tipos de álbum:\n[Música ligeira | Rock | Pop | Hip Hop | Techno | Jazz | Country | etc]\n\n");
            aux = consola.lerString("Tipo do álbum: ");
            a.setTipoAlbum(aux);

            int numMusicas = consola.lerInteiro("\nQuantas músicas terá o album?\n> ");

            for (int i = 0; i < numMusicas; i++) {
                Musica musica = new Musica();
                
                int codMusica = consola.lerInteiro("\nCódigo da música " + (i+1) + ": ");
                while (sistema.getMusicas().verificarSeExisteMusica(codMusica)) {
                    codMusica = consola.verificarCodigos(codMusica);
                }
                musica.setCodigo(codMusica);

                aux = consola.lerStringBuffer("Nome da música " + (i+1) + ": ");
                musica.setTituloMusica(aux);
                
                consola.escrever("\nDefina a duração da música " + (i+1) +" em minutos e segundos\n");
                int minutos = consola.lerInteiro("Minutos: ");
                while(minutos >= 60){
                    consola.escrever("\nErro! Introduza um número menor que 60!");
                    minutos = consola.lerInteiro("\nMinutos: ");
                }
                int segundos = consola.lerInteiro("Segundos: ");
                while(segundos >= 60){
                    consola.escrever("\nErro! Introduza um número menor que 60!");
                    segundos = consola.lerInteiro("\nSegundos: ");
                }
                String duracao = String.valueOf(minutos + ":" + segundos);
                musica.setDuracao(duracao);
                
                int numMusicos = consola.lerInteiro("\n\nNúmero de músicos que participam nesta música: ");
                while(numMusicos > sistema.getUtilizadores().contarNumeroMusicos()){
                    consola.escrever("\nERRO! Só existem " +sistema.getUtilizadores().contarNumeroMusicos()+ " músicos registados");
                    numMusicos = consola.lerInteiro("\nIntroduza outro número: ");
                }
                
                for(int j=0; j < numMusicos; j++){
                    String userMusico = consola.lerStringBuffer("Username de um músico que participa nesta música: ");
                    if(j == 0){
                        while(!sistema.getUtilizadores().verificarSeExisteMusico(userMusico)){
                            consola.escrever("\nEsse músico não existe!");
                            userMusico = consola.lerString("\nIntroduza outro username: ");
                        }
                    }
                    else{
                        while(!sistema.getUtilizadores().verificarSeExisteMusico(userMusico) || 
                                a.devolverMusicaCodigo(codMusica).naoDeixarMesmoMusico(userMusico)){
                            if(!sistema.getUtilizadores().verificarSeExisteMusico(userMusico))
                                consola.escrever("\nERRO! Esse músico não existe!");
                            else if(a.devolverMusicaCodigo(codMusica).naoDeixarMesmoMusico(userMusico))
                                consola.escrever("\nERRO! Esse músico já está associado a esta música!");
                            userMusico = consola.lerString("\nIntroduza outro username: ");
                        }
                    }
                    Musico musico = new Musico();
                    musico = sistema.getUtilizadores().devolverMusico(userMusico);
                    musica.addMusico(musico);
                    
                    sistema.getMusicas().inserir(musica);
                    a.addMusica(musica);
                }
            }
            
            sistema.getAlbuns().inserir(a);

            consola.escrever("\nÁlbum registado com sucesso!");

            int opcao;

            do {
                consola.escrever("\n\n[1] Voltar ao menu anterior");
                consola.escrever("\n[2] Registar outro álbum\n");
                opcao = consola.lerInteiro("> ");
                switch (opcao) {
                    case 1:
                        break;

                    case 2:
                        registarAlbum(sistema, consola);
                        break;

                    default:
                        consola.escrever("\nOpção inválida!");
                }
            } while (opcao != 1 && opcao != 2);
        }
        else{
            consola.escrever("\nNão existe nenhum Produtor!\nLogo não pode registar nenhum álbum!\n");
            consola.voltarMenuAnteriorBuffer();
        }
    }
}