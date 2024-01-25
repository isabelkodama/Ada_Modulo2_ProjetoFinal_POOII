package br.com.ada.pooii.Interfaces;

import br.com.ada.pooii.Domain.BaseTask;

public interface GetTaskIndex<T extends BaseTask> {
    T getTaskIndex(int index);
}
