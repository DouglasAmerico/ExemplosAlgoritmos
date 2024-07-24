import java.util.Scanner;

public class LeitorDeNotasMelhorado {
           

    public static  Integer[] avaliacoes(String nome[], Integer qtdAlunos, String tipo){
        Integer avaliacao[] = new Integer[qtdAlunos];
        Scanner leitor = new Scanner(System.in);
        for(int i=0; i<qtdAlunos;i++){
            do{
                System.out.println("Por favor insira o valor da "+tipo+" do Aluno "+nome[i]+": ");
                avaliacao[i]= leitor.nextInt();
            }while(avaliacao[i] > 100 || avaliacao[i]<0);
        }

        return avaliacao;
    }

    public static Double[] calculoDasNotas(Integer prova1[], Integer prova2[], Integer trabalhos[], Integer qtdAlunos){
        Double somaNotas[] = new Double[qtdAlunos];
        for (int i = 0;i<qtdAlunos; i++){
             somaNotas[i] = prova1[i]*0.4 + prova2[i]*0.3 + trabalhos[i]*0.3;
        }
        return somaNotas;
    }
    
    public static String[] aprovados(Double somaNotas[], String alunosAprovados[], Integer qtdAlunos){
          
          for(int i=0; i<qtdAlunos; i++){
              if (somaNotas[i] >=70){
                  alunosAprovados[i] = "Aprovado";
              }else if(somaNotas[i] >=40){
                  alunosAprovados[i] = "Exame";
              }else{
                  alunosAprovados[i] = "Reprovado";
              }
          }
       return alunosAprovados;
      }

    public static void main(String[] args) {        
        try (Scanner leitor = new Scanner(System.in)) {
            System.out.println("Irá informar a nota de quantos alunos?");
            Integer qtdAlunos = leitor.nextInt();
            
            String nomes[] = new String[qtdAlunos];
            Integer prova1[] = new Integer[qtdAlunos];
            Integer prova2[] = new Integer[qtdAlunos];
            Integer trabalhos[] = new Integer[qtdAlunos];
            Double somaNotas[] = new Double[qtdAlunos];
            String alunosAprovados[] = new String[qtdAlunos];
            
            
            for (int i = 0; i < qtdAlunos; i++) {
                System.out.println("Por favor informa o nome do Aluno "+ (i+1)+": ");
                nomes[i]= leitor.next();
            }
            
            prova1 = avaliacoes(nomes,qtdAlunos,"Prova 1");
            prova2 = avaliacoes(nomes,qtdAlunos,"Prova 2");
            trabalhos = avaliacoes(nomes,qtdAlunos,"Trabalho");
            somaNotas = calculoDasNotas(prova1, prova2, trabalhos,qtdAlunos);
            alunosAprovados = aprovados(somaNotas, alunosAprovados,qtdAlunos);

            for (int i = 0; i < qtdAlunos; i++) {
                System.out.println("O aluno: "+nomes[i]+" foi "+alunosAprovados[i]+" com a nota "+somaNotas[i]);
            }
        }
    }   
}