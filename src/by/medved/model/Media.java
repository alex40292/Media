package by.medved.model;

// gnkdnssn
public class Media
{
	private String artist;
	private String mediaFile;
	private int year;
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
