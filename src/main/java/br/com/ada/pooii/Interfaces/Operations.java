package br.com.ada.pooii.Interfaces;

import br.com.ada.pooii.Domain.BaseTask;

import java.util.List;


public interface Operations<T extends BaseTask> extends AddTask<T>, GetTaskIndex<T>, GetTasks<T>, EditarTaskIndex<T>, RemoverTaskIndex<T> {

}
