package ru.netology.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeTrueForQueryByAllTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(12, "Звонить родителям");

        String[] subtasks = { "Звонок родителям", "Уборка в доме", "Выполнение домашнего задания" };
        Epic epic = new Epic(36, subtasks);

        Meeting meetingOne = new Meeting(
                89,
                "Тестирование задачи из новой сборки",
                "Приложение Звонок",
                "После сообщения девопса об успешной установке сборки"
        );

        Meeting meetingTwo = new Meeting(
                41,
                "Тестирование задачи приложения Звонок",
                "Приложение банка",
                "После сообщения об установке сборки"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meetingOne);
        todos.add(meetingTwo);

        Task[] expected = { simpleTask, epic, meetingOne, meetingTwo };
        Task[] actual = todos.search("Звон");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeFalseForQueryByAllTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(12, "Позвонить родителям");

        String[] subtasks = { "Получение посылки", "Уборка в доме", "Выполнение домашнего задания" };
        Epic epic = new Epic(36, subtasks);

        Meeting meeting = new Meeting(
                89,
                "Проверка задачи из новой сборки",
                "Приложение СЭД",
                "После сообщения девопса об успешной установке сборки"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("тестирование");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeTrueForQueryByTasksOfSomeTypes() {
        SimpleTask simpleTask = new SimpleTask(12, "Приложить компресс");

        String[] subtasks = { "Получение посылки", "Уборка в доме", "Выполнение домашнего задания" };
        Epic epic = new Epic(36, subtasks);

        Meeting meetingOne = new Meeting(
                89,
                "Тестирование задачи из новой сборки",
                "Нетология",
                "После сообщения девопса об успешной установке сборки"
        );

        Meeting meetingTwo = new Meeting(
                41,
                "Тестирование задачи проекта Приложение Звонок",
                "Приложение Звонок",
                "После сообщения об установке сборки"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meetingOne);
        todos.add(meetingTwo);

        Task[] expected = { simpleTask, meetingTwo };
        Task[] actual = todos.search("Прилож");
        Assertions.assertArrayEquals(expected, actual);
    }
}