import java.util.Scanner;

public class cursoResolvidoCompleto {
    static Scanner leitor = new Scanner(System.in);//variavel scanner
    static String p1= "Prova 1", p2= "Prova 2", tb= "Trabalhos";

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

        for(int i=0;i<3;i++){
            medias[i]= (prova1[i]*0.4) + (prova2[i]*0.3) + (trabalhos[i]*0.3);
        }

        return medias;
    }

    public static String[] calculoDeStatus(Double medias[]){
        String status[] = new String[3];

        for(int i=0;i<3;i++){
            if(medias[i] >= 7.0){
                status[i]= "Aprovado";
            }else if(medias[i] >= 4.0){
                status[i]= "Exame";
            }else{
                status[i]= "Reprovado";
            }
        }

        return status;
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

        prova1 = valoresDeAvalicoes(nomes,p1);
        prova2 = valoresDeAvalicoes(nomes,p2);
        trabalhos = valoresDeAvalicoes(nomes,tb);
        medias = retornoDasMedias(prova1,prova2,trabalhos);
        status = calculoDeStatus(medias);

        for(int i=0;i<3;i++){
            System.out.println("------------------------------");
            System.out.println("O aluno(a) "+nomes[i]+" obteve as notas");
            System.out.println(p1+": "+prova1[i]);
            System.out.println(p2+": "+prova2[i]);
            System.out.println(tb+": "+trabalhos[i]);
            System.out.println("Com a media: "+medias[i]);
            System.out.println("Ficou com o status: "+status[i]);
        }
    }

}
