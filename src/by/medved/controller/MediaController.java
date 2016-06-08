package by.medved.controller;

import java.util.List;

import by.medved.model.Media;

public interface MediaController
{
	void command(String cmd);

	void showAllGroups();

	List<Media> getMedia();

	String checkString(String text, String inputString);

	Integer checkInteger(String text, String inputString);

	void editMedia(Media mediaFile, String param, String value);
}
