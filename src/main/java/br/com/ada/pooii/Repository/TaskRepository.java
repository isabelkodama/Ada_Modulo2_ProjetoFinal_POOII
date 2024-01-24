package br.com.ada.pooii.Repository;

import br.com.ada.pooii.Domain.BaseTask;
import br.com.ada.pooii.Interface.Operations;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository<T extends BaseTask> implements Operations<T> {
    private List<T> tasks = new ArrayList<>();

    @Override
    public void addTask(T task) {
        tasks.add(task);
    }

    @Override
    public List<T> getTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public T getTaskIndex(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        }
        System.out.println("O valor inserido não atende ao intervalo da lista.");
        return null;
    }

    @Override
    public void editarTaskIndex(int index, T novaTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, novaTask);
        } else {
            System.out.println("O valor inserido não atende ao intervalo da lista.");
        }
    }

    @Override
    public void removerTaskIndex(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
}
