import java.util.Scanner;

public class HelloWord{
	public static void main(String[] args) {
		Scanner prompt = new Scanner(System.in);

		String nome = prompt.next();
		System.out.println("/nO professor se chama: "+nome);
	}
}