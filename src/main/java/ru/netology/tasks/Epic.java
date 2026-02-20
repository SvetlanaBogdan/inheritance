package ru.netology.tasks;

// Задача типа Epic.
// У Epic нет title, но есть список подзадач.
public class Epic extends Task {

    // Массив подзадач
    private String[] subtasks;

    // Конструктор принимает id и массив подзадач.
    // title передаём null, так как его нет.
    public Epic(int id, String[] subtasks) {
        super(id, null);
        this.subtasks = subtasks;
    }

    // Геттер для подзадач (может понадобиться в тестах)
    public String[] getSubtasks() {
        return subtasks;
    }

    // Переопределяем метод поиска.
    // Ищем только среди подзадач.
    @Override
    public boolean matches(String query) {

        // Перебираем все подзадачи
        for (String subtask : subtasks) {

            // Если хотя бы одна содержит запрос — возвращаем true
            if (subtask.contains(query)) {
                return true;
            }
        }

        // Если ничего не найдено
        return false;
    }
}