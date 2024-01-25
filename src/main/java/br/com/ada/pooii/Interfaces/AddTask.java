package br.com.ada.pooii.Interfaces;

import br.com.ada.pooii.Domain.BaseTask;

public interface AddTask<T extends BaseTask> {
    void addTask(T task);
}
