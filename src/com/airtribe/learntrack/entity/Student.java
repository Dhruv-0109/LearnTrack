package com.airtribe.learntrack.entity;

public class Student extends Person{
    private int id;
    private int batch ;
    private boolean status;

    public Student(int id, String firstName, String lastName, String email, int batch) {
        super(firstName,lastName,email);
        this.id = id;
        this.batch = batch;
        this.status = true;
    }

    public Student(int id, String firstName, String lastName, int batch) {
        super(firstName,lastName);
        this.id = id;
        this.batch = batch;
        this.status = true;
    }

    public int getId() {
        return id;
    }
    public void setBatch(int batch) {
        this.batch = batch;
    }
    public int getBatch() {
        return batch;
    }
    public void setStatus(boolean status)
    {
        this.status = status;
    }
    public boolean getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + getFirstName() + " " + getLastName() + '\'' +
                ", email='" + (getEmail() != null ? getEmail() : "N/A") + '\'' +
                ", batch=" + batch +
                ", status=" + (status ? "ACTIVE" : "INACTIVE") +
                '}';
    }
  
}
