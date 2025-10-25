package ru.netology.inherit;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        boolean result = false;
        for(String subtask : subtasks) {
            if (subtask.contains(query)) {
                return result = true;
            }
        }
        return result;
    }
}