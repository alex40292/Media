package by.medved.view;

import java.util.List;

import by.medved.model.Media;

public class ShowMediaFiles
{
	private final String INFO = "%2d\t%10s\t%10s\t%8d\t%5d";
	private final String HEAD = "%2s\t%10s\t%10s\t%8s\t%5s";

	public void show(List<Media> list)
	{
		int i = 0;
		System.out.println(String.format(HEAD, "№", "Artist", "Name", "Yeat", "Duration"));
		for (Media media : list)
		{
			System.out.println(
					String.format(INFO, i, media.getArtist(), media.getName(), media.getYear(), media.getDuration()));
			i++;
		}
	}
}
