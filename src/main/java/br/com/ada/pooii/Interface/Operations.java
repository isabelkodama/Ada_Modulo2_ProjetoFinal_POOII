package br.com.ada.pooii.Interface;

import br.com.ada.pooii.Domain.BaseTask;

import java.util.List;

public interface Operations<T extends BaseTask> {
    void addTask(T task);

    List<T> getTasks();

    T getTaskIndex(int index);

    void editarTaskIndex(int index, T novaTask);

    void removerTaskIndex(int index);
}