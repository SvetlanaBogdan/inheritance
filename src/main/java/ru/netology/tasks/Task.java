package ru.netology.tasks;

// Базовый класс задачи.
// От него будут наследоваться все остальные типы задач.
public class Task {

    // Уникальный идентификатор задачи
    protected int id;

    // Название задачи (может быть null у Epic)
    protected String title;

    // Конструктор базового класса
    public Task(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // Геттер для id
    public int getId() {
        return id;
    }

    // Геттер для title
    public String getTitle() {
        return title;
    }

    // Базовая реализация поиска.
    // По умолчанию ищем по названию задачи.
    // У Epic title = null, поэтому добавлена проверка.
    public boolean matches(String query) {
        return title != null && title.contains(query);
    }
}