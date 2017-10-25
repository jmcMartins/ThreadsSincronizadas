package iftm.so;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Controle
{
	private Vector<Aluno> inscritos = new Vector<Aluno>();
	private Lock accessLock = new ReentrantLock();
	private Condition canWrite = accessLock.newCondition();
	private boolean ocupado = false;
	private Random aleatorio = new Random();
 
	public boolean temVaga() 
	{
		accessLock.lock();
		while(ocupado) 
		{
			try {
				canWrite.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		boolean resultado = inscritos.size() < Main.QNTVAGAS;
		
		if(resultado)
			ocupado = true;
		
		accessLock.unlock();
		return resultado;
	}
	
	public void inscrever(int _id) 
	{
		accessLock.lock();
		
		try{
			int ra = aleatorio.nextInt(1000);
			Aluno aluno = new Aluno(Thread.currentThread().getName(), ra ,_id);
			inscritos.add(aluno);
			ocupado = false;
			canWrite.signalAll();
		}catch (Exception e) {
			
		}finally{
			accessLock.unlock();
		}
	}
	
	public void mostrarResultado()
	{
		for (int i = 0; i < inscritos.size(); i++) {
			if(i<9) System.out.print("0");
			System.out.print((i+1)+"º: ");
			System.out.println(inscritos.get(i));
		}
	}
}
