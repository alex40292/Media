package by.medved.application;

import by.medved.controller.impl.MediaControllerImpl;
import by.medved.model.Media;


public class Main
{
	public static void main(String[] args)
	{

		MediaControllerImpl controllerImpl = new MediaControllerImpl();
		
		
		controllerImpl.getMedia("all").add(new Media("Linkin Park", "Numb", 2008, 5));
		controllerImpl.getMedia("all").add(new Media("Linkin Park", "In The End", 2008, 3));
		controllerImpl.getMedia("all").add(new Media("Limp Bizkit", "Rollin", 2008, 7));
		controllerImpl.getMedia("all").add(new Media("Bon Jovi", "It's my Life", 2008, 4));
		
		controllerImpl.inputUserCommand();

	}
}
