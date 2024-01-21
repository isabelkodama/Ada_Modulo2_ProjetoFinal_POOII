package br.com.ada.pooii.Domain;

public abstract class BaseTask {

    private String task; // nome da tarefa
    private String date; // data em formato DD/MM/YYYY
    private String time; // em horas


    // Construtor
    public BaseTask(String task, String date, String time) {
        this.task = task;
        this.date = date;
        this.time = time;
    }


    // Metodos
    @Override
    public String toString() {
        return "Dia: " + getDate() + ", Hora: " + getTime() + ", Tarefa: " + task;
    }

    public abstract String getTaskType();

    public BaseTask copy() {
        BaseTask copyTask;
        if (this instanceof PersonalTask) {
            copyTask = new PersonalTask(getTask(), getDate(), getTime());
        } else if (this instanceof WorkTask) {
            copyTask = new WorkTask(getTask(), getDate(), getTime());
        } else if (this instanceof StudyTask) {
            copyTask = new StudyTask(getTask(), getDate(), getTime());
        } else {
            throw new UnsupportedOperationException("Tipo de tarefa não suportado.");
        }

        return copyTask;
    }

    public abstract void setTaskType(int type);

    // Getters e Setters
    public String getTask() {
        return task;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }


}


