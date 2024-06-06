package MiniCursoDeAlgoritmosEmJava;

import java.util.Scanner;

public class CodigoBase {

    public static Integer[] valoresProva1(String nome[]){
        Integer prova1[] = new Integer[3];
        //fazer o processo de leitura das notas e devolver para o main
        return prova1;
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String nomes[] = new String[3];
        Integer prova1[] = new Integer[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Por favor informa o nome do Aluno " + (i + 1) + ": ");
            nomes[i] = leitor.next();
        }

        prova1 = valoresProva1(nomes);

        //deve ser apresentado os nomes dos alunos, o status (aprovado, reprovado e Exame) e a media do mesmo
    }
}
