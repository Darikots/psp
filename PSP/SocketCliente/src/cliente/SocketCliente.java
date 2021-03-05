package cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketCliente {

	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");
		
		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		Scanner sc = new Scanner(System.in);
		try {
			socketCliente = new Socket();
			socketCliente.connect(direccionServidor);
			System.out.println("Conexion establecida... a " + IP_SERVER + " por el puerto "
					+ PUERTO);
			
			entrada = new InputStreamReader(socketCliente.getInputStream());
			salida = new PrintStream(socketCliente.getOutputStream());
			
			String n1;
			String n2;
			String operacion;
			String numeros;
			String continuar;
			
			BufferedReader bf = new BufferedReader(entrada);
			String resultado;
			
			boolean continuar1 = true;
			boolean continuar2 = true;
			
			while (continuar1) {
				
				System.out.println("CLIENTE: INICIO PROGRAMA CIFRAS");
				
				System.out.println("\nIntroduce el primer número");
				n1 = sc.nextLine();
				
				System.out.println("\nIntroduce el segundo número número");
				n2 = sc.nextLine();
				
				System.out.println("\nIntroduce el código de operación");
				System.out.println("1 - SUMA");
				System.out.println("2 - RESTA");
				System.out.println("3 - MULTIPLICACIÓN");
				System.out.println("4 - DIVISIÓN");
				operacion = sc.nextLine();
				
				numeros = n1 + "-" + n2 + "-" + operacion;
				
				salida.println(numeros);
				
				 resultado = bf.readLine();
					
				System.out.println("CLIENTE: " + resultado);
				
				while (continuar2) {
					
					System.out.println("¿Desea continuar operando?");
					System.out.println("S/N");
					continuar = sc.nextLine();
					
					if (continuar.toUpperCase().equals("S")) {
						
						continuar1 = true;
						continuar2 = false;
						
					} else if (continuar.toUpperCase().equals("N")) {
						
						continuar1 = false;
						continuar2 = false;
						
					} else {
						
						continuar2 = true;
						
						System.out.println("Código no aceptado");
						
					}
					
				}
				
			}
			
			System.out.println("FIN DEL PROGRAMA");

		} catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace();
			
		} finally {//ES MUYYY IMPORTANTE QUE EN LOS SOCKETS SIEMPRE SE CIERREN LAS CONEXIONES			
			try {
				salida.close();
				entrada.close();
				socketCliente.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	}

}
