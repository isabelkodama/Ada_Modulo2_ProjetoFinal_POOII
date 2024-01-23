package br.com.ada.pooii.Repository;

import br.com.ada.pooii.Domain.BaseTask;

import java.util.List;

public interface TaskInterface<T extends BaseTask> {
    void addTask(T task);

    List<T> getTasks();

    T getTaskIndex(int index);

    void editarTaskIndex(int index, T novaTask);

    void removerTaskIndex(int index);
}