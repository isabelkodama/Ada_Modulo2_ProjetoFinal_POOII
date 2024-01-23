package br.com.ada.pooii.View;

import br.com.ada.pooii.Domain.BaseTask;

import java.util.List;
import java.util.Scanner;

public class TaskView {
    private final Scanner scanner;

    public TaskView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Criar tarefa");
        System.out.println("2. Editar tarefa");
        System.out.println("3. Deletar tarefa");
        System.out.println("4. Visualizar tarefas");
        System.out.println("0. Sair");

        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    public int exibirOpcoesTipoTarefa() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEscolha o tipo de tarefa:");
        System.out.println("1. Tarefa pessoal");
        System.out.println("2. Tarefa de trabalho");
        System.out.println("3. Tarefa de estudo");

        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    public String exibirNomeTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome da tarefa: ");
        return scanner.nextLine();
    }

    public String exibirDataTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a data (DD/MM/YYYY): ");
        return scanner.nextLine();
    }

    public String exibirHoraTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a hora (hh:mm): ");
        return scanner.nextLine();
    }

    public void exibirTarefas(List<BaseTask> tasks) {
        System.out.println("\nTarefas no repositório:");
        for (int i = 0; i < tasks.size(); i++) {
            BaseTask task = tasks.get(i);
            System.out.println(i + ". " + task.toString() + " , Tipo: " + task.getTaskType());
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirTarefaParaEdicao(String tarefa, String tipoTarefa) {
        System.out.println("Tarefa selecionada para edição:");
        System.out.println(tarefa + " , Tipo: " + tipoTarefa);
    }

    public int exibirIndiceEdicao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o índice da tarefa que deseja editar: ");
        return scanner.nextInt();
    }

    public void exibirEdicaoCancelada() {
        System.out.println("Edição cancelada.");
    }

    public void exibirIndiceInvalido() {
        System.out.println("Índice inválido. Tarefa não encontrada.");
    }

    public String exibirNovoNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Novo nome da tarefa: ");
        return scanner.nextLine();
    }

    public String exibirNovaData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nova data (DD/MM/YYYY): ");
        return scanner.nextLine();
    }

    public String exibirNovaHora() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nova hora (hh:mm): ");
        return scanner.nextLine();
    }

    public int exibirTipoTarefa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Novo tipo de tarefa:\n1. Tarefa pessoal\n2. Tarefa de trabalho\n3. Tarefa de estudo\nOpção: ");
        return scanner.nextInt();
    }
    public int exibirOpcoesEdicao() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEscolha uma opção de edição:");
        System.out.println("1. Editar toda a tarefa");
        System.out.println("2. Editar tipo de tarefa");
        System.out.println("3. Editar nome da tarefa");
        System.out.println("4. Editar data da tarefa");
        System.out.println("5. Editar hora da tarefa");

        System.out.print("Opção: ");
        return scanner.nextInt();
    }


    public int exibirConfirmacaoEdicao() {
        Scanner scanner = new Scanner(System.in);

        int confirmacao;
        do {
            System.out.print("Confirma a edição? \n1. Sim\n2. Não\n Resposta: ");
            confirmacao = scanner.nextInt();
            scanner.nextLine();
            if (confirmacao != 1 && confirmacao != 2) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (confirmacao != 1 && confirmacao != 2);

        return confirmacao;
    }

    public void exibirTarefaEditadaComSucesso() {
        System.out.println("Tarefa editada com sucesso!");
    }

    public int exibirIndiceDelecao() {
        System.out.print("Digite o índice da tarefa que deseja deletar: ");
        return scanner.nextInt();
    }
    public void exibirTarefaParaDelecao(String tarefa, String tipoTarefa) {
        System.out.println("Tarefa selecionada para ser deletada:");
        System.out.println(tarefa + " , Tipo: " + tipoTarefa);
    }
    public int exibirConfirmacaoDelecao() {
        int confirmacao;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Confirma a deleção? \n1. Sim\n2. Não\n Resposta: ");
            confirmacao = scanner.nextInt();
            scanner.nextLine();
            if (confirmacao != 1 && confirmacao != 2) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (confirmacao != 1 && confirmacao != 2);

        return confirmacao;
    }

    public void exibirDelecaoCancelada() {
        System.out.println("Deleção cancelada.");
    }



}


