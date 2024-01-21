package br.com.ada.pooii.Service;

import br.com.ada.pooii.Domain.BaseTask;
import br.com.ada.pooii.Domain.PersonalTask;
import br.com.ada.pooii.Domain.StudyTask;
import br.com.ada.pooii.Domain.WorkTask;
import br.com.ada.pooii.Repository.TaskRepository;
import br.com.ada.pooii.View.TaskView;

import java.util.List;


public class TaskService {

    private final TaskRepository<BaseTask> taskRepository;
    private final TaskView taskView;

    public TaskService(TaskRepository<BaseTask> taskRepository, TaskView taskView) {
        this.taskRepository = taskRepository;
        this.taskView = taskView;
    }

    public void criarTarefa() {
        int tipoTarefa = taskView.exibirOpcoesTipoTarefa();
        String nome = taskView.exibirNomeTarefa();
        String data = taskView.exibirDataTarefa();
        String hora = taskView.exibirHoraTarefa();

        BaseTask novaTarefa;
        switch (tipoTarefa) {
            case 1:
                novaTarefa = new PersonalTask(nome, data, hora);
                break;
            case 2:
                novaTarefa = new WorkTask(nome, data, hora);
                break;
            case 3:
                novaTarefa = new StudyTask(nome, data, hora);
                break;
            default:
                taskView.exibirMensagem("Opção de tipo de tarefa inválida.");
                return;
        }

        taskRepository.addTask(novaTarefa);
    }

    public void editarTarefa(int indiceEdicao, int novoTipoTarefa, String novoNome, String novaData, String novaHora) {
        BaseTask tarefaExistente = taskRepository.getTaskIndex(indiceEdicao);

        if (tarefaExistente != null) {
            BaseTask tarefaEditada = tarefaExistente.copy();

            tarefaEditada.setTask(novoNome);
            tarefaEditada.setDate(novaData);
            tarefaEditada.setTime(novaHora);

            if (tarefaExistente instanceof PersonalTask && novoTipoTarefa != 1) {

                taskRepository.removerTaskIndex(indiceEdicao);
                taskRepository.addTask(new WorkTask(tarefaEditada.getTask(), tarefaEditada.getDate(), tarefaEditada.getTime()));
                taskView.exibirTarefaEditadaComSucesso();
            } else if (tarefaExistente instanceof WorkTask && novoTipoTarefa != 2) {

                taskRepository.removerTaskIndex(indiceEdicao);
                taskRepository.addTask(new StudyTask(tarefaEditada.getTask(), tarefaEditada.getDate(), tarefaEditada.getTime()));
                taskView.exibirTarefaEditadaComSucesso();
            } else if (tarefaExistente instanceof StudyTask && novoTipoTarefa != 3) {

                taskRepository.removerTaskIndex(indiceEdicao);
                taskRepository.addTask(new PersonalTask(tarefaEditada.getTask(), tarefaEditada.getDate(), tarefaEditada.getTime()));
                taskView.exibirTarefaEditadaComSucesso();
            } else {
                taskRepository.editarTaskIndex(indiceEdicao, tarefaEditada);
            }

        } else {
            taskView.exibirIndiceInvalido();
        }
    }

    public void editarTipoTarefa(int indiceEdicao, int novoTipoTarefa) {
        BaseTask tarefaExistente = taskRepository.getTaskIndex(indiceEdicao);

        if (tarefaExistente != null) {
            BaseTask tarefaEditada = tarefaExistente.copy();

            if (tarefaEditada instanceof PersonalTask && novoTipoTarefa != 1) {
                taskRepository.removerTaskIndex(indiceEdicao);
                taskRepository.addTask(new WorkTask(tarefaEditada.getTask(), tarefaEditada.getDate(), tarefaEditada.getTime()));
            } else if (tarefaEditada instanceof WorkTask && novoTipoTarefa != 2) {
                taskRepository.removerTaskIndex(indiceEdicao);
                taskRepository.addTask(new StudyTask(tarefaEditada.getTask(), tarefaEditada.getDate(), tarefaEditada.getTime()));
            } else if (tarefaEditada instanceof StudyTask && novoTipoTarefa != 3) {
                taskRepository.removerTaskIndex(indiceEdicao);
                taskRepository.addTask(new PersonalTask(tarefaEditada.getTask(), tarefaEditada.getDate(), tarefaEditada.getTime()));
            } else {
                tarefaEditada.setTaskType(novoTipoTarefa);
                taskRepository.editarTaskIndex(indiceEdicao, tarefaEditada);
            }
        } else {
            taskView.exibirIndiceInvalido();
        }
    }


    public void editarNomeTarefa(int indiceEdicao, String novoNome) {
        BaseTask tarefaExistente = taskRepository.getTaskIndex(indiceEdicao);

        if (tarefaExistente != null) {
            BaseTask tarefaEditada = tarefaExistente.copy();
            tarefaEditada.setTask(novoNome);
            taskRepository.editarTaskIndex(indiceEdicao, tarefaEditada);
        } else {
            taskView.exibirIndiceInvalido();
        }
    }

    public void editarDataTarefa(int indiceEdicao, String novaData) {
        BaseTask tarefaExistente = taskRepository.getTaskIndex(indiceEdicao);

        if (tarefaExistente != null) {
            BaseTask tarefaEditada = tarefaExistente.copy();
            tarefaEditada.setDate(novaData);
            taskRepository.editarTaskIndex(indiceEdicao, tarefaEditada);
        } else {
            taskView.exibirIndiceInvalido();
        }
    }

    public void editarHoraTarefa(int indiceEdicao, String novaHora) {
        BaseTask tarefaExistente = taskRepository.getTaskIndex(indiceEdicao);

        if (tarefaExistente != null) {
            BaseTask tarefaEditada = tarefaExistente.copy();
            tarefaEditada.setTime(novaHora);
            taskRepository.editarTaskIndex(indiceEdicao, tarefaEditada);
        } else {
            taskView.exibirIndiceInvalido();
        }
    }

    public void deletarTarefa(int indiceDelecao) {
        BaseTask tarefaExistente = taskRepository.getTaskIndex(indiceDelecao);

        if (tarefaExistente != null) {
            taskView.exibirTarefaParaDelecao(tarefaExistente.toString(), tarefaExistente.getTaskType());

            int confirmacao = taskView.exibirConfirmacaoDelecao();
            if (confirmacao == 1) {
                taskRepository.removerTaskIndex(indiceDelecao);
                taskView.exibirMensagem("Tarefa deletada com sucesso!");
            } else {
                taskView.exibirDelecaoCancelada();
            }
        } else {
            taskView.exibirIndiceInvalido();
        }
    }


    public List<BaseTask> listarTarefas() {
        List<BaseTask> tarefas = taskRepository.getTasks();

        if (!tarefas.isEmpty()) {
            taskView.exibirTarefas(tarefas);
        } else {
            taskView.exibirMensagem("Não há tarefas cadastradas.");
        }

        return tarefas;
    }

    public BaseTask getTaskAtIndex(int index) {
        return taskRepository.getTaskIndex(index);
    }
}

