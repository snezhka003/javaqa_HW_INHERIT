package ru.netology.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldBeTrueForQueryByTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(12, "Позвонить родителям");

        String[] subtasks = { "Получение посылки", "Уборка в доме", "Выполнение домашнего задания" };
        Epic epic = new Epic(36, subtasks);

        Meeting meetingOne = new Meeting(
                89,
                "Тестирование задачи из новой сборки",
                "Приложение СЭД",
                "После сообщения девопса об успешной установке сборки"
        );

        Meeting meetingTwo = new Meeting(
                41,
                "Тестирование задачи из новой сборки",
                "Приложение банка",
                "После сообщения об установке сборки"
        );

        boolean[] expected = { true, true, true, true };
        boolean[] actual = { simpleTask.matches("звонить"), epic.matches("дом"), meetingOne.matches("сборки"), meetingTwo.matches("банк") };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeFalseForQueryByTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(12, "Позвонить родителям");

        String[] subtasks = { "Получение посылки", "Уборка в доме", "Выполнение домашнего задания" };
        Epic epic = new Epic(36, subtasks);

        Meeting meetingOne = new Meeting(
                89,
                "Тестирование задачи из новой сборки",
                "Приложение СЭД",
                "После сообщения девопса об успешной установке сборки"
        );

        Meeting meetingTwo = new Meeting(
                41,
                "Тестирование задачи из новой сборки",
                "Приложение банка",
                "После сообщения об установке сборки"
        );

        boolean[] expected = { false, false, false, false };
        boolean[] actual = { simpleTask.matches("убрать"), epic.matches("звонок"), meetingOne.matches("девопс"), meetingTwo.matches("установ") };
        Assertions.assertArrayEquals(expected, actual);
    }
}
