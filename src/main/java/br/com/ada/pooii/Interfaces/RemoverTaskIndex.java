package br.com.ada.pooii.Interfaces;

import br.com.ada.pooii.Domain.BaseTask;

public interface RemoverTaskIndex<T extends BaseTask> {
    void removerTaskIndex(int index);
}
