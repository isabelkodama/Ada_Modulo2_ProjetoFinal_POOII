package br.com.ada.pooii.Controller;

import br.com.ada.pooii.Domain.BaseTask;
import br.com.ada.pooii.Service.TaskService;
import br.com.ada.pooii.View.TaskView;

public class TaskController {

    private final TaskService taskService;
    private final TaskView taskView;

    public TaskController(TaskService taskService, TaskView taskView) {
        this.taskService = taskService;
        this.taskView = taskView;
    }

    public void iniciar() {
        int choice;
        do {
            choice = taskView.exibirMenu();

            switch (choice) {
                case 1:
                    taskService.criarTarefa();
                    break;
                case 2:
                    editarTarefa();
                    break;
                case 3:
                    int indiceDelecao = taskView.exibirIndiceDelecao();
                    taskService.deletarTarefa(indiceDelecao);
                    break;
                case 4:
                    taskService.listarTarefas();
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 0);
    }

    private void editarTarefa() {
        int indiceEdicao = taskView.exibirIndiceEdicao();
        editarTarefaConfirmada(indiceEdicao);
    }

    private void editarTarefaConfirmada(int indiceEdicao) {
        BaseTask tarefaParaEditar = taskService.getTaskAtIndex(indiceEdicao);

        if (tarefaParaEditar != null) {
            taskView.exibirTarefaParaEdicao(tarefaParaEditar.toString(), tarefaParaEditar.getTaskType());

            int confirmacaoEdicao = taskView.exibirConfirmacaoEdicao();
            if (confirmacaoEdicao == 1) {
                int opcaoEdicao = taskView.exibirOpcoesEdicao();

                switch (opcaoEdicao) {
                    case 1:
                        editarTarefaCompleta(indiceEdicao);
                        break;
                    case 2:
                        editarTipoTarefa(indiceEdicao);
                        break;
                    case 3:
                        editarNomeTarefa(indiceEdicao);
                        break;
                    case 4:
                        editarDataTarefa(indiceEdicao);
                        break;
                    case 5:
                        editarHoraTarefa(indiceEdicao);
                        break;
                    default:
                        taskView.exibirMensagem("Opção inválida. Tente novamente.");
                        break;
                }
            } else {
                taskView.exibirEdicaoCancelada();
            }
        } else {
            taskView.exibirIndiceInvalido();
        }
    }


    private void editarTarefaCompleta(int indiceEdicao) {
        int novoTipoTarefa = taskView.exibirTipoTarefa();
        String novoNome = taskView.exibirNovoNome();
        String novaData = taskView.exibirNovaData();
        String novaHora = taskView.exibirNovaHora();

        taskService.editarTarefa(indiceEdicao, novoTipoTarefa, novoNome, novaData, novaHora);
        taskView.exibirTarefaEditadaComSucesso();
    }

    private void editarTipoTarefa(int indiceEdicao) {
        int novoTipoTarefa = taskView.exibirTipoTarefa();
        taskService.editarTipoTarefa(indiceEdicao, novoTipoTarefa);
        taskView.exibirTarefaEditadaComSucesso();
    }

    private void editarNomeTarefa(int indiceEdicao) {
        String novoNome = taskView.exibirNovoNome();
        taskService.editarNomeTarefa(indiceEdicao, novoNome);
        taskView.exibirTarefaEditadaComSucesso();
    }

    private void editarDataTarefa(int indiceEdicao) {
        String novaData = taskView.exibirNovaData();
        taskService.editarDataTarefa(indiceEdicao, novaData);
        taskView.exibirTarefaEditadaComSucesso();
    }

    private void editarHoraTarefa(int indiceEdicao) {
        String novaHora = taskView.exibirNovaHora();
        taskService.editarHoraTarefa(indiceEdicao, novaHora);
        taskView.exibirTarefaEditadaComSucesso();
    }
}