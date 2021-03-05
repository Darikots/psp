package primos;

import java.util.Scanner;

public class Runneable {
	public static void main(String[] args) {
		System.out.println("Introduce 3 numeros");
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		EjThread h1 = new Thread(n1);
		EjThread h2 = new Thread(n2);
		EjThread h3 = new Thread(n3);
		
		Thread t1 = new Thread(h1, "Hilo1");
		Thread t2 = new Thread(h2, "Hilo2");
		Thread t3 = new Thread(h3, "Hilo3");
		
		try {
			Thread.sleep(300);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.start();
		Thread.sleep(200);
		t2.start();
		Thread.sleep(200);
		t3.start();
		Thread.sleep(200);
		
		sc.close();
	}

}
