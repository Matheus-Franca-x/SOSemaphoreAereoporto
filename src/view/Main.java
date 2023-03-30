package view;

import java.util.concurrent.Semaphore;

import controller.ControllAereoporto;

public class Main 
{
	public static void main(String[] args)
	{
		Semaphore liberaS = new Semaphore(1);
		Semaphore liberaN = new Semaphore(1);
		
		for(int i = 1; i <= 12; i++)
		{
			ControllAereoporto controll = new ControllAereoporto(i, liberaS, liberaN);
			controll.aviao();
		}
	}

}
