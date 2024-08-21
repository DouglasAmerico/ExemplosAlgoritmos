package ContaBanco;

import java.io.IOException;
import java.util.Scanner;

public class IndexContaBanco {

    public static void limpar(){
        for (int i=0;i<5;i++){
            System.out.println(" ");
        }
    }

    public static Boolean menu(ClasseContaBanco ccb) throws IOException {
        Scanner prompt = new Scanner(System.in);
        System.out.println("Insira uma a opção:");
        System.out.println("1- Inserir Saldo");
        System.out.println("2- Retirar Saldo");
        System.out.println("3- Visualizar conta");
        System.out.println("4- Sair");
        Integer seletor= prompt.nextInt();

        if(seletor == 1){
            System.out.println("Quanto deseja inserir? ");
            ccb.inserirSaldo(prompt.nextDouble());
        }else if(seletor == 2){
            System.out.println("Quanto deseja retirar? ");
            if(ccb.sacarSaldo(prompt.nextDouble())){
                System.out.println("Valor retirado com sucesso");
            }else{
                System.out.println("Saldo insuficiente");
            }
        }else if(seletor == 3){
            System.out.println("Conta: "+ccb.numeroConta);
            System.out.println("Nome: "+ccb.nomeCliente);
            System.out.println("Saldo: "+ccb.saldoConta);
        }else if(seletor == 4) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        ClasseContaBanco ccb = new ClasseContaBanco();
        Scanner prompt = new Scanner(System.in);

        System.out.print("Informe o numero da conta: ");
        ccb.numeroConta= prompt.nextDouble();
        System.out.print("Informe o nome do cliente da conta "+ccb.numeroConta+": ");
        ccb.nomeCliente= prompt.next();
        System.out.println("\nO cliente "+ccb.nomeCliente+" recebeu um saldo de 1000,00R$ ao abir a conta\n");

        while(menu(ccb)){
            menu(ccb);
            limpar();
        }
        System.out.println("Obrigado por utilizar o sistema");
    }
}
