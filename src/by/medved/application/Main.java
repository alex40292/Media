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
		
		controllerImpl.getMedia("all").add(new Media("Linkin Park", "Numb", 2008, 5));
		controllerImpl.getMedia("all").add(new Media("Linkin Park", "In The End", 2008, 3));
		controllerImpl.getMedia("all").add(new Media("Limp Bizkit", "Rollin", 2008, 7));
		controllerImpl.getMedia("all").add(new Media("Bon Jovi", "It's my Life", 2008, 4));
		
		do
		{
			System.out.println("Введите вашу команду: ");
			cmd = input.nextLine();
			
			controllerImpl.command(cmd);
			
		} while (!cmd.equalsIgnoreCase("end"));
	}
}
