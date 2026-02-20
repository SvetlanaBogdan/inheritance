package ru.netology.tasks;

// Простая задача.
// Не имеет дополнительных полей.
// Наследуется от Task.
public class SimpleTask extends Task {

    // Конструктор принимает id и title
    public SimpleTask(int id, String title) {
        super(id, title); // вызываем конструктор родителя
    }

    // Метод matches() НЕ переопределяем,
    // используем реализацию из Task.
}