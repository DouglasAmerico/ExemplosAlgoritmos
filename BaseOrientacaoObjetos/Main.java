package BaseOrientacaoObjetos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe o nome: ");
        pessoa.nome= leitor.nextLine();
        System.out.println("Informe a idade: ");
        pessoa.idade= leitor.nextInt();
        System.out.println("Informe o seu sexo: ");
        pessoa.sexo= leitor.nextLine();
        System.out.println("Informe o logradouro do seu endereço: ");
        pessoa.endereco.logradouro= leitor.nextLine();

        System.out.println(pessoa);
    }
}
