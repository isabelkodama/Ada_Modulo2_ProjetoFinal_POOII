package br.com.ada.pooii.Interfaces;

import br.com.ada.pooii.Domain.BaseTask;

public interface EditarTaskIndex<T extends BaseTask> {
    void editarTaskIndex(int index, T novaTask);
}
