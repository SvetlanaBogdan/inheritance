package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
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

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchSimpleTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("родителям");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpic() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("НетоБанка");

        Assertions.assertArrayEquals(expected, actual);
    }

    // Тест проверяет, что метод search возвращает несколько задач,
// если по запросу подходит более одной задачи.
    @Test
    public void shouldSearchSeveralTasks() {

        // Создаём задачи
        SimpleTask task1 = new SimpleTask(1, "Купить молоко");
        SimpleTask task2 = new SimpleTask(2, "Купить хлеб");
        SimpleTask task3 = new SimpleTask(3, "Позвонить маме");

        // Создаём объект Todos и добавляем задачи
        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        // Ожидаем, что по слову "Купить" найдутся две задачи
        Task[] expected = {task1, task2};

        // Выполняем поиск
        Task[] actual = todos.search("Купить");

        // Сравниваем ожидаемый и фактический результат
        Assertions.assertArrayEquals(expected, actual);
    }

    // Тест проверяет, что метод search возвращает массив из одной задачи,
// если по запросу подходит только одна задача.
    @Test
    public void shouldSearchOneTask() {

        // Создаём задачи
        SimpleTask task1 = new SimpleTask(1, "Купить молоко");
        SimpleTask task2 = new SimpleTask(2, "Позвонить маме");

        // Добавляем задачи в список
        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);

        // Ожидаем, что по слову "маме" найдётся только одна задача
        Task[] expected = {task2};

        // Выполняем поиск
        Task[] actual = todos.search("маме");

        // Проверяем корректность результата
        Assertions.assertArrayEquals(expected, actual);
    }

    // Тест проверяет, что метод search возвращает пустой массив,
// если ни одна задача не соответствует поисковому запросу.
    @Test
    public void shouldSearchNoTasks() {

        // Создаём задачи
        SimpleTask task1 = new SimpleTask(1, "Купить молоко");
        SimpleTask task2 = new SimpleTask(2, "Позвонить маме");

        // Добавляем задачи в список
        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);

        // Ожидаем пустой массив, так как слово "Пельмешка"
        // не встречается ни в одной задаче
        Task[] expected = {};

        // Выполняем поиск
        Task[] actual = todos.search("Пельмешка");

        // Проверяем, что метод вернул пустой массив
        Assertions.assertArrayEquals(expected, actual);
    }


}