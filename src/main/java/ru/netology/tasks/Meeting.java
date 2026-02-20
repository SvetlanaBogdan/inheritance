package ru.netology.tasks;

// Задача типа Meeting.
// Имеет название, проект и время начала.
public class Meeting extends Task {

    // Название проекта
    private String project;

    // Время начала встречи
    private String start;

    // Конструктор принимает все поля
    public Meeting(int id, String title, String project, String start) {
        super(id, title); // передаём id и title в родитель
        this.project = project;
        this.start = start;
    }

    // Геттер для project
    public String getProject() {
        return project;
    }

    // Геттер для start
    public String getStart() {
        return start;
    }

    // Переопределяем метод поиска.
    // Ищем:
    // 1) в названии встречи
    // 2) в названии проекта
    @Override
    public boolean matches(String query) {

        // Проверяем название встречи
        if (getTitle().contains(query)) {
            return true;
        }

        // Проверяем проект
        if (project.contains(query)) {
            return true;
        }

        // Если не найдено
        return false;
    }
}