package com.lambdaschool.javatodos.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="todo")
public class Todo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoid;

    @Column(nullable = false)
    private String description;

    private Timestamp datestarted;

    private Boolean completed;

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

    public Timestamp getDatestarted()
    {
        return datestarted;
    }

    public void setDatestarted(Timestamp datestarted)
    {
        this.datestarted = datestarted;
    }

    public Boolean getCompleted()
    {
        return completed;
    }

    public void setCompleted(Boolean completed)
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
