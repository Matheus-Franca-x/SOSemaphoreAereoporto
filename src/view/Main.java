package view;

import controller.ControllAereoporto;

public class Main 
{
	public static void main(String[] args)
	{
		for(int i = 1; i <= 12; i++)
		{
			ControllAereoporto controll = new ControllAereoporto();
			
			controll.aviao();
			
		}
	}

}
