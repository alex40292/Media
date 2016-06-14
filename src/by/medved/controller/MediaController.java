package by.medved.controller;

import java.util.List;

import by.medved.model.Media;

public interface MediaController
{
	/**
	 * Выполнение введенной с консоли команды(если такая существует)
	 */
	void command(String cmd);

	/**
	 * Получить список медиаресурсов выбранной группы
	 */
	List<Media> getMedia(String name);

	/**
	 * Проверка строки на корректность
	 */
	String checkString(String text, String inputString);

	/**
	 * Проверка на то, что введено число
	 */
	Integer checkInteger(String text, String inputString);

	/**
	 * Редактирование элемента
	 */
	void editMedia(Media mediaFile, String param, String value);

	/**
	 * Поиск по заданному параметру
	 */
	void findMediaByParam(Media mediaFile, String param, String value);
}
