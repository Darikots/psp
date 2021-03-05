package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACIÓN DE SERVIDOR      ");
		System.out.println("----------------------------------");
		
		ServerSocket servidorSocket = null;
		Socket socketConexion = null;
		PrintStream salida = null;
		InputStreamReader entrada = null;		
		
		try {
			servidorSocket = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress(IP_SERVER,PUERTO);
			servidorSocket.bind(direccion);
			
			while(true){
				System.out.println("SERVIDOR: Esperando peticion...");
				socketConexion = servidorSocket.accept();
				
				entrada = new InputStreamReader(socketConexion.getInputStream());
				
				BufferedReader bf = new BufferedReader(entrada);
				
				String stringRecibido = bf.readLine();
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
				String[] numeros = stringRecibido.split("-");
				double iN1 = Double.parseDouble(numeros[0]);
				double iN2 = Double.parseDouble(numeros[1]);
				int operacion = Integer.parseInt(numeros[2]);
				
				double resultado = 0;
				
				if(operacion == 1) {
					resultado = iN1 + iN2;
				}else if(operacion == 2) {
					resultado = iN1 - iN2;
				}else if(operacion == 3) {
					resultado = iN1 * iN2;
				}else if(operacion == 4) {
					resultado = iN1 / iN2;
				}
				
				salida = new PrintStream(socketConexion.getOutputStream());
				salida.println(resultado);
				
			}
		} catch (IOException excepcion) {
			System.out.println(excepcion);
		}finally {//ES MUYYY IMPORTANTE QUE EN LOS SOCKETS SIEMPRE SE CIERREN LAS CONEXIONES
			try {
				if(salida != null && entrada != null){
					salida.close();
					entrada.close();
					socketConexion.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
}




