package iftm.so;

import java.util.Vector;

public class Main 
{
	
	public static int QNTALUNOS = 400;
	public static int QNTVAGAS = 30;

	public static void main(String[] args) throws InterruptedException
	{
		Vector<Thread> entrada = new Vector<Thread>();
		Controle controle = new Controle();
		
		for (int i = 0; i < Main.QNTALUNOS; i++) 
		{
			entrada.add(new Thread( new Entrada(i, controle)));
			entrada.lastElement().start();
		}
		
		for (int i = 0; i < Main.QNTALUNOS; i++) 
		{
			entrada.get(i).join();
		}
		
		controle.mostrarResultado();
		
	}

}
