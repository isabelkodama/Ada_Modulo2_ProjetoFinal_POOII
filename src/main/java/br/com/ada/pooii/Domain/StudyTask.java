package br.com.ada.pooii.Domain;

public class StudyTask extends BaseTask {

    // Construtor
    public StudyTask(String task, String date, String time) {
        super(task, date, time);
    }

    @Override
    public String getTaskType() {
        return "Tarefa de Estudo";
    }

    @Override
    public void setTaskType(int type) {

    }
}