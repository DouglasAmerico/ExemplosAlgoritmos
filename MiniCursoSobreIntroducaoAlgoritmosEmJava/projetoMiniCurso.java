import java.util.Scanner;

public class projetoMiniCurso {
    static Scanner leitor = new Scanner(System.in);//variavel scanner

    public static Integer[] valoresDeAvalicoes(String nome[],String tipo){
        Integer avaliacao[] = new Integer[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Informe o valor da "+tipo+" do Aluno(a) "+nome[i]+": ");
            do{
                avaliacao[i]= leitor.nextInt();
                if (avaliacao[i] < 0 || avaliacao[i] > 100) {
                    System.out.println("Informe um valor entre 0 e 100");
                }
            }while(avaliacao[i] < 0 || avaliacao[i] > 100);
        }
        return avaliacao;
    }

    public static Double[] retornoDasMedias(Integer prova1[],Integer prova2[],Integer trabalhos[]){
        Double medias[] = new Double[3];


        return medias;
    }

    public static void main(String[] args) {
        String nomes[] = new String[3];//criei um array de 3 elementos
        Integer prova1[] = new Integer[3];//criei um array de 3 elementos
        Integer prova2[] = new Integer[3];
        Integer trabalhos[] = new Integer[3];
        Double medias[] = new Double[3];
        String status[] = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Por favor informa o nome do Aluno " + (i + 1) + ": ");
            nomes[i] = leitor.next();
        }

        prova1 = valoresDeAvalicoes(nomes,"Prova 1");
        prova2 = valoresDeAvalicoes(nomes,"Prova 2");
        trabalhos = valoresDeAvalicoes(nomes,"Trabalhos");
        medias = retornoDasMedias(prova1,prova2,trabalhos);

        //deve ser apresentado os nomes dos alunos, o status (aprovado, reprovado e Exame) e a media do mesmo
    }

}
