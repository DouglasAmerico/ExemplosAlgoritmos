import java.util.Scanner;

/**
 * index
 */
public class testeDeMenorValor {

    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        Integer valor, menor=0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Informe o numero: "+(i+1)+": ");
            do{
                valor= prompt.nextInt();
                if(valor < 0){
                    System.out.println("por favor só imprima numeros positivos");
                }
            }while(valor < 0);
            
            if(i==0){
                menor= valor;
            }else if(valor < menor){
                menor= valor;
            }
        }

        System.out.println("O menor valor digitado é: "+menor);
    }
}