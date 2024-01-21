package br.com.ada.pooii.View;

import br.com.ada.pooii.Domain.BaseTask;

import java.util.List;

public interface UserInterface {
    int exibirMenu();
    int exibirOpcoesTipoTarefa();
    String exibirNomeTarefa();
    String exibirDataTarefa();
    String exibirHoraTarefa();
    void exibirTarefas(List<BaseTask> tasks);
    void exibirMensagem(String mensagem);
    void exibirTarefaParaEdicao(String tarefa, String tipoTarefa);
    int exibirIndiceEdicao();
    void exibirEdicaoCancelada();
    void exibirIndiceInvalido();
    String exibirNovoNome();
    String exibirNovaData();
    String exibirNovaHora();
    int exibirTipoTarefa();
    int exibirOpcoesEdicao();
    int exibirConfirmacaoEdicao();
    void exibirTarefaEditadaComSucesso();
    int exibirIndiceDelecao();
    void exibirTarefaParaDelecao(String tarefa, String tipoTarefa);
    int exibirConfirmacaoDelecao();
    void exibirDelecaoCancelada();
}
