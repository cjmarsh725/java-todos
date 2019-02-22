package com.lambdaschool.javatodos.models;

import javax.persistence.*;

@Entity
@Table(name="todo")
public class Todo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoid;

    @Column(nullable = false)
    private String description;

    private String datestarted;

    private int completed;

    @Column(nullable = false)
    private int userid;

    public Todo()
    {
    }

    public int getTodoid()
    {
        return todoid;
    }

    public void setTodoid(int todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDatestarted()
    {
        return datestarted;
    }

    public void setDatestarted(String datestarted)
    {
        this.datestarted = datestarted;
    }

    public int getCompleted()
    {
        return completed;
    }

    public void setCompleted(int completed)
    {
        this.completed = completed;
    }

    public int getUserid()
    {
        return userid;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
    }
}
