package by.medved.model;

/**
 * Медиаресурсы
 */
public class Media
{
	private final String INFO = "%10s\t%10s\t%8d\t%5d";
	
	@Override
	public String toString()
	{
		return String.format(INFO, getArtist(), getName(), getYear(), getDuration());
	}
	
	/**
	 * Имя артиста медиаресурса 
	 */
	private String artist;
	
	/**
	 * Название
	 */
	private String mediaFile;
	
	/**
	 * Год выхода
	 */
	private int year;
	
	/**
	 * Длительность
	 */
	private int duration;
	
	public Media(String artist, String mediaFile, int year, int duration)
	{
		setArtist(artist);
		setName(mediaFile);
		setYear(year);
		setDuration(duration);
	}

	public String getArtist()
	{
		return artist;
	}

	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	public String getName()
	{
		return mediaFile;
	}

	public void setName(String album)
	{
		this.mediaFile = album;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		this.duration = duration;
	}
}
