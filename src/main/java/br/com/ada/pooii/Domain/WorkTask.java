package br.com.ada.pooii.Domain;

public class WorkTask extends BaseTask {

    // Construtor
    public WorkTask(String task, String date, String time) {
        super(task, date, time);
    }

    @Override
    public String getTaskType() {
        return "Tarefa de Trabalho";
    }

    @Override
    public void setTaskType(int type) {

    }
}
