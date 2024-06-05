import java.util.Scanner;

public class BaseMiniCursoVetoresMatrizes {

    static 
        Integer 
            prova1= 0, 
            prova2= 1,
            trabalho= 2;
    //declarando constantes para armazenar os codigos para usar como linhas nas matrizes

   public static Integer[] valoresProva1(String nome[]){
        Integer prova1[] = new Integer[3];
        Scanner grava = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            do{
                System.out.println("Por favor insira o valor da Prova 1 do Aluno "+nome[i]+": ");
                prova1[i]= grava.nextInt();
            }while(prova1[i] > 10 || prova1[i] < 0);
        }
        
        return prova1;
    }
    
    public static Integer[] valoresProva2(String nome[]){
        Integer prova2[] = new Integer[3];
        Scanner grava = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            do{
                System.out.println("Por favor insira o valor da Prova 2 do Aluno "+nome[i]+": ");
                prova2[i]= grava.nextInt();
            }while(prova2[i] > 10 || prova2[i] < 0);
        }
        
        return prova2;
    }
    
    public static Integer[] trabalhosnotas(String nome[]){
        Integer trabalhos[] = new Integer[3];
        Scanner grava = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            do{
                System.out.println("Por favor insira o valor dos trabalhos do Aluno "+nome[i]+": ");
                trabalhos[i]= grava.nextInt();
            }while(trabalhos[i] > 10 || trabalhos[i] < 0);
        }
        
        return trabalhos;
    }
    
    public static Double[] calculoDasNotas(Integer prova1[], Integer prova2[], Integer trabalhos[]){
        Double somaNotas[] = new Double[3];
        for (int i = 0;i<3; i++){
             somaNotas[i] = prova1[i]*0.4 + prova2[i]*0.3 + trabalhos[i]*0.3;
        }
        return somaNotas;
    }
    
    public static String[] aprovados(Double somaNotas[], String alunosAprovados[]){
          
          for(int i=0; i<3; i++){
              if (somaNotas[i] >=7){
                  alunosAprovados[i] = "Aprovado";
              }else if(somaNotas[i] >=4){
                  alunosAprovados[i] = "Exame";
              }else if(somaNotas[i]<4){
                  alunosAprovados[i] = "Reprovado";
              }
          }
       return alunosAprovados;
      }

    public static void main(String[] args) {    
        Scanner grava = new Scanner(System.in);
        System.out.println("Quantos alunos serão inseridos? ");
        Integer tamanho = grava.nextInt();

        String nomes[] = new String[tamanho];
        Integer notas[][] = new Integer[3][tamanho];
        Double somaNotas[] = new Double[3];
        String alunosAprovados[] = new String[3];

        
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Por favor informa o nome do Aluno "+ (i+1)+": ");
            nomes[i]= grava.next();
        }
        
        //notas = valoresProva1(nomes);
        //prova2 = valoresProva2(nomes);
        //trabalhos = trabalhosnotas(nomes);
        //somaNotas = calculoDasNotas(prova1, prova2, trabalhos);
        alunosAprovados = aprovados(somaNotas, alunosAprovados);

        for (int i = 0; i < 3; i++) {
            System.out.println("O aluno: "+nomes[i]+" foi "+alunosAprovados[i]);
        }
    }   
}