import java.util.Scanner;

public class BaseMiniCursoVetores {
           

   public static Integer[] valoresProva1(String nome[], Integer qtdAlunos){
        Integer prova1[] = new Integer[qtdAlunos];
        try (Scanner leitor = new Scanner(System.in)) {
            for (int i = 0; i < qtdAlunos; i++) {
                do{
                    System.out.println("Por favor insira o valor da Prova 1 do Aluno "+nome[i]+": ");
                    prova1[i]= leitor.nextInt();
                }while(prova1[i] > 100 || prova1[i] < 0);
            }
        }
        return prova1;
    }
    
    public static Integer[] valoresProva2(String nome[], Integer qtdAlunos){
        Integer prova2[] = new Integer[qtdAlunos];
        try (Scanner leitor = new Scanner(System.in)) {
            for (int i = 0; i < qtdAlunos; i++) {
                do{
                    System.out.println("Por favor insira o valor da Prova 2 do Aluno "+nome[i]+": ");
                    prova2[i]= leitor.nextInt();
                }while(prova2[i] > 100 || prova2[i] < 0);
            }
        }
        return prova2;
    }
    
    public static Integer[] trabalhosnotas(String nome[], Integer qtdAlunos){
        Integer trabalhos[] = new Integer[qtdAlunos];
        try (Scanner leitor = new Scanner(System.in)) {
            for (int i = 0; i < qtdAlunos; i++) {
                do{
                    System.out.println("Por favor insira o valor dos trabalhos do Aluno "+nome[i]+": ");
                    trabalhos[i]= leitor.nextInt();
                }while(trabalhos[i] > 100 || trabalhos[i] < 0);
            }
        }
        return trabalhos;
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
            
            prova1 = valoresProva1(nomes,qtdAlunos);
            prova2 = valoresProva2(nomes,qtdAlunos);
            trabalhos = trabalhosnotas(nomes,qtdAlunos);
            somaNotas = calculoDasNotas(prova1, prova2, trabalhos,qtdAlunos);
            alunosAprovados = aprovados(somaNotas, alunosAprovados,qtdAlunos);

            for (int i = 0; i < qtdAlunos; i++) {
                System.out.println("O aluno: "+nomes[i]+" foi "+alunosAprovados[i]+" com a nota "+somaNotas[i]);
            }
        }
    }   
}