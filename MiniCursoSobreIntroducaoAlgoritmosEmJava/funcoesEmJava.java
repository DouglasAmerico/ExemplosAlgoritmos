public class funcoesEmJava {

    public static Integer soma(Integer numero1, Integer numero2){
        return numero1+numero2;
    }

    public static void mostrarValores(Integer numero1, Integer numero2){
        System.out.println("valor 1: "+numero1+" valor 2: "+numero2);
    }

    public static void main(String[] args) {
        System.out.println(soma(2,5));
        mostrarValores(6, 8);
    }
}
