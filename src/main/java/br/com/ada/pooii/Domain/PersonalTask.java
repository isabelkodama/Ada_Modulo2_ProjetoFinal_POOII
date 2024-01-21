package br.com.ada.pooii.Domain;

public class PersonalTask extends BaseTask {

    // Construtor
    public PersonalTask(String task, String date, String time) {
        super(task, date, time);
    }

    @Override
    public String getTaskType() {
        return "Tarefa Pessoal";
    }

    @Override
    public void setTaskType(int type) {

    }
}