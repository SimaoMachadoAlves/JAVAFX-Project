package frontend;

import backend.Sistema;

public class Executavel {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        MenuPrincipal mp = new MenuPrincipal();
        Consola consola = new Consola();
        mp.menuPrincipal(sistema, consola);
        consola.escrever("\nPrograma terminado com sucesso!");
    }
    
}
