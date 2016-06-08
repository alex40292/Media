package by.medved.application;

import java.util.Scanner;

import by.medved.controller.impl.MediaControllerImpl;
import by.medved.model.Media;


public class Main
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{

		MediaControllerImpl controllerImpl = new MediaControllerImpl();
		Scanner input = new Scanner(System.in);
		String cmd;
		
		controllerImpl.getMedia().add(new Media("Linkin Park", "Numb", 2008, 5));
		
		do
		{
			System.out.println("Введите вашу команду: ");
			cmd = input.nextLine();
			
			controllerImpl.command(cmd);
			
			if(cmd.equalsIgnoreCase("end")) break;
		} while (true);
	}
}
