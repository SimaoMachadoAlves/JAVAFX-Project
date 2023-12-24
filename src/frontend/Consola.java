package frontend;

import backend.Sistema;
import backend.Utilizador;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {

    private final Scanner scanner = new Scanner(System.in);

    public void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException E) {
            System.out.println(E);
        }
    }
    
    // métodos para validar as datas
    private static boolean validarData(LocalDate date, int aux){
        LocalDate dataAtual = LocalDate.now();
        switch (aux){
            case 1:
                if(date.isAfter(dataAtual)){
                    return false;
                }
                else
                    return true;
            case 2:
                if(date.isBefore(dataAtual)){
                    return false;
                }
                else
                    return true;
        }
        return false;
    }

    private String naoPermitirEnter(String str) {
        Scanner input = new Scanner(System.in);

        // nao permitir que o valor da variavel seja nula
        while (str.isEmpty()) {
            System.out.print("ERRO! Tente novamente: ");
            str = input.nextLine();
        }

        return str;
    }
    
    public void voltarMenuAnterior(){
        escrever("\n\nPara voltar ao MENU aperte ENTER...");
        scanner.nextLine();
    }
    
    public void voltarMenuAnteriorBuffer(){
        scanner.nextLine();
        voltarMenuAnterior();
    }
    
    public LocalDate lerDataBuffer(String mensagem){
        scanner.nextLine();
        return lerData(mensagem);
    }
    
    public LocalDate lerData(String mensagem){
        boolean valido;
        LocalDate date = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            escrever(mensagem);
            try {
                String str = scanner.nextLine();
                date = LocalDate.parse(str, dtf);
                boolean val = validarData(date, 1);
                while (val == false) {
                    System.out.print("Data invalida! Introduza outra data (formato dd/MM/yyyy): ");
                    //scanner.nextLine();
                    str = scanner.nextLine();
                    date = LocalDate.parse(str, dtf);
                    val = validarData(date, 1);
                }
                valido = true;
            } catch (DateTimeParseException e) {
                escrever("Data invalida! ");
                valido = false;
            }
        } while (!valido);
        return date;
    }
    
    public LocalDate lerDataFuturaBuffer(String mensagem){
        scanner.nextLine();
        return lerDataFutura(mensagem);
    }
    
    public LocalDate lerDataFutura(String mensagem){
        boolean valido;
        LocalDate date = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            escrever(mensagem);
            try {
                String str = scanner.nextLine();
                date = LocalDate.parse(str, dtf);
                boolean val = validarData(date, 2);
                while (val == false) {
                    escrever("Data invalida! Introduza outra data (formato dd/MM/yyyy): ");
                    //scanner.nextLine();
                    str = scanner.nextLine();
                    date = LocalDate.parse(str, dtf);
                    val = validarData(date, 2);
                }
                valido = true;
            } catch (Exception e) {
                escrever("Data invalida! ");
                valido = false;
            }
        } while (!valido);
        return date;
    }
    
    public void escrever(String mensagem) {
        System.out.print(mensagem);
    }

    public void escreverErro(String mensagem) {
        System.err.println(mensagem);
    }

    public String lerString(String mensagem) {
        escrever(mensagem);
        String str = scanner.nextLine();
        str = naoPermitirEnter(str);
        return str;
    }

    public String lerStringBuffer(String mensagem) {
        scanner.nextLine();
        return lerString(mensagem);
    }
    
    public int lerInteiro(String mensagem) {
        Integer num = null;
        
        do {
            escrever(mensagem);
            try {
                num = scanner.nextInt();
                // verificar se o numero de CC não é menor que 0
                while (num <= 0) {
                    System.out.print("Numero invalido! Introduza outro: ");
                    num = scanner.nextInt();
                }
            } catch (InputMismatchException e) {
                System.out.print("\nNumero invalido!\n");
                scanner.nextLine();
            }
        } while (num == null);

        return num;
    }

    public double lerDecimal(String mensagem) {
        Double num = null;

        do {
            escrever(mensagem);
            try {
                num = scanner.nextDouble();
                // verificar se o numero de CC não é menor que 0
                while (num <= 0) {
                    System.out.println("Numero invalido! Introduza outro: ");
                    num = scanner.nextDouble();
                }
            } catch (InputMismatchException e) {
                System.out.print("\nNumero invalido!\n");
                //scanner.nextLine();
            }
        } while (num == null);

        return num;
    }
    
    public String verificarUsername(Sistema sistema, String aux){
        while(sistema.getUtilizadores().verificarSeExiste(aux)){
            escrever("\nERRO! Username já existe!");
            aux = lerString("\nIntroduza outro username: ");
        }
        return aux;
    }
    
    public int verificarCodigos(int cod){
        escrever("\nERRO! Esse codigo já existe!");
        cod = lerInteiro("\nIntroduza outro codigo: ");
        return cod;
    }
    
}
