package by.medved.view;

import java.util.List;

import by.medved.model.Media;

/**
 * Вывод медиаресурсов
 */
public class ShowMediaFiles
{
	private final String INFO = "%2d\t%10s\t%10s\t%8d\t%5d";
	private final String HEAD = "%2s\t%10s\t%10s\t%8s\t%5s";

	/**
	 * Вывод медиаресурсов в виде таблицы
	 */
	public void show(List<Media> list)
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
}
