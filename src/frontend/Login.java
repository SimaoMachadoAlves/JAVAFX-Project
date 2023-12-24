package frontend;

import backend.Administrador;
import backend.Musico;
import backend.Produtor;
import backend.Sistema;
import backend.Utilizador;

public class Login {

    public Login() {
    }
    
    public void fazerLogin(Sistema sistema, Consola consola, int opc){
        
        String usr, psw;
        
        switch (opc){
            case 1:
                if(!sistema.getUtilizadores().verificarAdmin()){     
                    Administrador admin = new Administrador();
                    consola.cls();
                    
                    consola.escrever("CRIAR CONTA ADMIN\n\n");
                    usr = consola.lerStringBuffer("Novo username: ");       // problema com o buffer! (é resolvido com o método "lerStringBuffer")
                    admin.setUsername(usr);

                    psw = consola.lerString("Nova password: ");
                    admin.setPassword(psw);

                    sistema.getUtilizadores().inserir(admin);
                    consola.escrever("\nConta criada com sucesso!");
                    consola.voltarMenuAnterior();
                    break;
                }
                else{
                    consola.cls();
                    Administrador admin = new Administrador();
                    consola.escrever("LOGIN ADMIN\n\n");
                    usr = consola.lerStringBuffer("Username: ");            // problema com o buffer! (é resolvido com o método "lerStringBuffer")
                    psw = consola.lerString("Password: ");

                    // verificar se os dados introduzidos estão corretos
                    if(sistema.autenticar(usr, psw, 1, admin)){
                        Utilizador u = sistema.getUtilizadorLigado();
                        MenuAdmin mAdmin = new MenuAdmin();
                        mAdmin.menuA(sistema, consola, u);
                    }
                    else{
                        consola.escrever("\nCredênciais inválidas!");
                        consola.voltarMenuAnterior();
                    }
                }
                break;
                
            case 2:
                consola.cls();
                MenuProdutor mProd = new MenuProdutor();
                Produtor p = new Produtor();
                consola.escrever("LOGIN PRODUTOR\n\n");
                usr = consola.lerStringBuffer("Username: ");            // problema com o buffer! (é resolvido com o método "lerStringBuffer")
                psw = consola.lerString("Password: ");

                // verificar se os dados introduzidos estão corretos
                if(sistema.autenticar(usr, psw, 2, p)){                                              
                    Utilizador u = sistema.getUtilizadorLigado();
                    // chamada do menuProdutor
                    mProd.menuP(sistema, consola, u);                         
                }
                else{
                    consola.escrever("\nCredênciais inválidas");
                    consola.voltarMenuAnterior();
                }
                break;
            
            case 3:
                consola.cls();
                MenuMusico mMusic = new MenuMusico();
                Musico m = new Musico();
                consola.escrever("LOGIN MÚSICO\n\n");
                usr = consola.lerStringBuffer("Username: ");            // problema com o buffer! (é resolvido com o método "lerStringBuffer")
                psw = consola.lerString("Password: ");

                // verificar se os dados introduzidos estão corretos
                if(sistema.autenticar(usr, psw, 3, m)){                                              
                    Utilizador u = sistema.getUtilizadorLigado();
                    // chamada do menuMusico
                    mMusic.menuM(sistema, consola, u);
                }
                else{
                    consola.escrever("\nCredênciais inválidas!");
                    consola.voltarMenuAnterior();
                }
                break;
                
        }
    }
}

