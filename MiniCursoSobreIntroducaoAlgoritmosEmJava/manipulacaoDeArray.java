import java.util.Scanner;

public class manipulacaoDeArray {
    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);

        System.out.print("Quantas informações irá informar: ");
        Integer tamanho = prompt.nextInt();

        Integer array[] = new Integer[tamanho];

        for(int i=0;i<tamanho;i++){
            System.out.print("Informe o valor "+(i+1)+": ");
            array[i]= prompt.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("Valor "+(i+1)+": "+array[i]);
        }

    }   
}
