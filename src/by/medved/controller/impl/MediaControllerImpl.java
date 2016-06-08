package by.medved.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import by.medved.controller.MediaController;
import by.medved.controller.Process;
import by.medved.model.Media;
import by.medved.view.ShowMediaFiles;

public class MediaControllerImpl implements MediaController
{
	private Scanner input;
	private ShowMediaFiles mediaFiles;

	public MediaControllerImpl()
	{
		input = new Scanner(System.in);
		mediaFiles = new ShowMediaFiles();
	}

	/**
	 * Мапа для хранения списка медиаресурсов, распределенных по группам
	 */
	private Map<String, List<Media>> groups = new HashMap<>();

	{
		groups.put("all", new ArrayList<>());
		groups.put("liked", new ArrayList<>());
	}

	@Override
	public String checkString(String text, String inputString)
	{
		if (inputString.isEmpty())
		{
			System.out.println(text);
			inputString = input.nextLine();
			checkString(text, inputString);
		}
		return inputString;
	}

	@Override
	public Integer checkInteger(String text, String inputString)
	{
		try
		{
			int year = Integer.parseInt(checkString(text, inputString));
			return year;
		} catch (Exception exception)
		{
			System.out.println(text);
			inputString = input.nextLine();
		}
		return checkInteger(text, inputString);
	}

	/**
	 * Мапа для выбора действия в приложении в зависимости от введенной команды
	 * 		add - добавление элемента
	 * 		create - создание группы
	 * 		delete - удаление медиафайла
	 * 		deleteFrom - удаление из избранного
	 * 		edit - редактирование медиафайла
	 * 		show - показать все файлы в выбранной группе
	 * 		move - переместить медиафайл в группу
	 * 		find - поиск файла по заданным параметрам
	 */
	private Map<String, Process> ACTION = new HashMap<>();

	{
		ACTION.put("add", () ->
		{
			System.out.println("Введите имя артиста: ");
			String artist = checkString("Введите имя артиста: ", input.nextLine());

			System.out.println("Введите название медиафайла: ");
			String album = checkString("Введите название медиафайла: ", input.nextLine());

			System.out.println("Введите год выхода: ");
			int year = checkInteger("Введите год выхода: ", input.nextLine());

			System.out.println("Введите длительность: ");
			int duration = checkInteger("Введите длительность: ", input.nextLine());

			Media media = new Media(artist, album, year, duration);

			groups.get("all").add(media);
		});

		ACTION.put("create", () ->
		{
			showAllGroups();
			System.out.println("Введите название новой группы: ");
			String name = checkString("Введите название новой группы: ", input.nextLine());

			groups.put(name, new ArrayList<>());
		});

		ACTION.put("delete", () ->
		{
			mediaFiles.show(groups.get("all"));

			System.out.println("Введите номер медиафайла: ");
			int number = checkInteger("Введите номер медиафайла: ", input.nextLine());

			groups.get("all").remove(number);

		});

		ACTION.put("deleteFrom", () ->
		{
			mediaFiles.show(groups.get("liked"));

			System.out.println("Введите номер медиафайла: ");
			int number = checkInteger("Введите номер медиафайла: ", input.nextLine());
			
			groups.get("liked").remove(number);

		});

		ACTION.put("edit", () ->
		{
			mediaFiles.show(groups.get("all"));

			System.out.println("Введите номер медиафайла: ");
			int number = checkInteger("Введите номер медиафайла: ", input.nextLine());
			
			System.out.println("Введите название изменяемого параметра: ");
			String param = checkString("Введите название изменяемого параметра: ", input.nextLine());
			
			System.out.println("Введите значение изменяемого параметра: ");
			String value = checkString("Введите значение изменяемого параметра: ", input.nextLine());

			editMedia(groups.get("all").get(number), param, value);
		});

		ACTION.put("show", () ->
		{
			System.out.println("Группы");
			showAllGroups();
			
			System.out.println("Введите название группы: ");
			String group = checkString("Введите название группы: ", input.nextLine());
			
			mediaFiles.show(groups.get(group));
		});

		ACTION.put("find", () ->
		{
			System.out.println("Введите название группы: ");
			String group = checkString("Введите название группы: ", input.nextLine());

			System.out.println("Введите название параметра: ");
			String param = checkString("Введите название параметра: ", input.nextLine());
			
			System.out.println("Введите значение изменяемого параметра: ");
			String value = checkString("Введите значение изменяемого параметра: ", input.nextLine());
			
			for(Media media : groups.get(group)) {
				if(media.getArtist().equals(value)) System.out.println(media.toString());
			}
		});

		ACTION.put("move", () ->
		{
			System.out.println("Медиафайлы");
			mediaFiles.show(groups.get("all"));

			System.out.println("Группы");
			showAllGroups();

			System.out.println("Введите название группы: ");
			String group = checkString("Введите название группы: ", input.nextLine());

			System.out.println("Введите номер медиафайла: ");
			int number = checkInteger("Введите номер медиафайла: ", input.nextLine());

			groups.get(group).add(groups.get("all").get(number));
		});
	}

	@Override
	public List<Media> getMedia(String name)
	{
		return groups.get(name);
	}

	@Override
	public void editMedia(Media mediaFile, String param, String value)
	{
		switch (param.toLowerCase())
		{
		case "name":
			mediaFile.setName(value);
			break;
		case "artist":
			mediaFile.setArtist(value);
			break;
		case "year":
			mediaFile.setYear(Integer.parseInt(value));
			break;
		case "duration":
			mediaFile.setDuration(Integer.parseInt(value));
			break;
		}
	}

	@Override
	public void command(String cmd)
	{
		if (!ACTION.containsKey(cmd))
		{
			System.out.println("Некорректный ввод!");
		} else
		{
			ACTION.get(cmd).process();
		}
	}

	@Override
	public void showAllGroups()
	{
		for (Entry<String, List<Media>> entry : groups.entrySet())
		{
			System.out.println(entry.getKey() + " - " + groups.get(entry.getKey()).size() + " file(s)");
		}
	}

}
