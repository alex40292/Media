package by.medved.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import by.medved.model.Media;

/**
 * Вывод медиаресурсов
 */
public class ShowInfo
{
	private final String INFO = "%2d\t%10s\t%10s\t%8d\t%5d";
	private final String HEAD = "%2s\t%10s\t%10s\t%8s\t%5s";

	/**
	 * Вывод медиаресурсов в виде таблицы
	 */
	public void showMedia(List<Media> list)
	{
		int number = 0;
		System.out.println(String.format(HEAD, "№", "Artist", "Name", "Year", "Duration"));
		for (Media media : list)
		{
			System.out.println(
					String.format(INFO, number, media.getArtist(), media.getName(), media.getYear(), media.getDuration()));
			number++;
		}
	}
	/**
	 * Вывод всех возможных комманд
	 */
	public void showAllCommand()
	{
		String commandNames = "\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s";
		System.out.println(String.format(commandNames, "add - добавление элемента", "create - создание группы", "delete - удаление медиафайла в выбранной группе",
				"edit - редактирование медиафайла", "show - показать все файлы в выбранной группе", "move - переместить медиафайл в группу",
				"find - поиск файла по заданным параметрам", "end - завершение программы"));
	}
	
	/**
	 * Показ всех существующих групп
	 */
	public void showAllGroups(Map<String, List<Media>> groups)
	{
		for (Entry<String, List<Media>> entry : groups.entrySet())
		{
			System.out.println(entry.getKey() + " - " + groups.get(entry.getKey()).size() + " file(s)");
		}
	}
}
