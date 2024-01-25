package br.com.ada.pooii.Interfaces;

import br.com.ada.pooii.Domain.BaseTask;

import java.util.List;

public interface GetTasks<T extends BaseTask> {
    List<T> getTasks();
}