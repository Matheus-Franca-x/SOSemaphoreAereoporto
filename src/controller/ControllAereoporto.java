package controller;

import java.util.concurrent.Semaphore;

public class ControllAereoporto extends Thread
{
	
	int idAviao;
	int pista;
	Semaphore sul;
	Semaphore norte;
	
	public ControllAereoporto(int id, Semaphore liberaS, Semaphore liberaN)
	{
		this.idAviao = id;
		this.sul = liberaS;
		this.norte = liberaN;
	}
	
	
	public void aviao()
	{
		new Thread()
		{
			public void run()
			{
				if(pistaVazia())
				{
					manobrar();
					taxiar();
					decolar();
					afastamento();
				}
			}
			
		}.start();
	}
	
	public boolean pistaVazia()
	{
		this.pista = (int) (Math.random() * 2) + 1;
		
		try {
			if(this.pista == 1)
			{
				sul.acquire();				
			}
			else
			{
				norte.acquire();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public void manobrar()
	{
		System.out.println("O aviao " + this.idAviao + " esta manobrando.");
		
		try {
			sleep((int)(Math.random() * 5000) + 3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("O aviao " + this.idAviao + " terminou de manobrar.");
	}
	
	public void taxiar()
	{
		System.out.println("O aviao " + this.idAviao + " esta a taxiar na pista.");
		
		try {
			sleep((int)(Math.random() * 6000) + 5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("O aviao " + this.idAviao + " terminou de taxiar.");
		
	}
	
	public void decolar()
	{
		System.out.println("O aviao " + this.idAviao + " esta prestes a decolar.");
		
		try {
			sleep((int)(Math.random() * 4000) + 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("O aviao " + this.idAviao + " terminou de decolar.");
		
	}
	
	public void afastamento()
	{
		
		try {
			if(this.pista == 1)
			{
				System.out.println("Aguarde 3 a 8 segundo para a liberacao da pista sul");
				sleep((int)(Math.random() * 6000) + 3000);
				sul.release();
				System.out.println("Pista sul foi liberado.");
			}
			else
			{
				System.out.println("Aguarde 3 a 8 segundo para a liberacao da pista norte");
				sleep((int)(Math.random() * 6000) + 3000);
				norte.release();
				System.out.println("Pista norte foi liberado.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
