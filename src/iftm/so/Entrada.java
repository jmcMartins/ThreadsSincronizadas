package iftm.so;

import java.util.Random;

public class Entrada implements Runnable
{
	private int id = 0;
	private Controle controle;
	
	public Entrada (int _id, Controle _controle) 
	{
		this.id = _id;
		this.controle = _controle;
	}
	
	@Override
	public void run() 
	{
		Thread.currentThread().setName("Aluno "+this.id+"º");
		
		//Porque meu processador organiza por ondem.
		try {
			Thread.sleep(new Random().nextInt(200));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(controle.temVaga())
			controle.inscrever(this.id);
	}
}
