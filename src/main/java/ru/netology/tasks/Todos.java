package ru.netology.tasks;

// Класс хранения всех задач.
// Демонстрирует полиморфизм.
public class Todos {

    // Массив задач.
    // Храним именно Task, чтобы можно было
    // добавлять SimpleTask, Epic и Meeting.
    private Task[] tasks = new Task[0];

    // Метод добавления новой задачи
    public void add(Task task) {

        // Создаём новый массив на 1 элемент больше
        Task[] tmp = new Task[tasks.length + 1];

        // Копируем старые задачи
        for (int i = 0; i < tasks.length; i++) {
            tmp[i] = tasks[i];
        }

        // Добавляем новую задачу в конец массива
        tmp[tmp.length - 1] = task;

        // Перезаписываем ссылку
        tasks = tmp;
    }

    // Метод возвращает все задачи
    public Task[] findAll() {
        return tasks;
    }

    // Метод поиска задач.
    // Здесь работает полиморфизм.
    public Task[] search(String query) {

        // Массив для найденных задач
        Task[] result = new Task[0];

        // Перебираем все задачи
        for (Task task : tasks) {

            // Вызывается matches() конкретного класса
            if (task.matches(query)) {

                // Увеличиваем массив результатов
                Task[] tmp = new Task[result.length + 1];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }

                tmp[tmp.length - 1] = task;
                result = tmp;
            }
        }

        return result;
    }
}