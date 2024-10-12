package org.example;

public class Player {
    private int id;
    private String name;
    private String position;
    private int goals;
    private int assists;

    public Player(){

    }

    public Player(int id, String name, String position, int goals, int assists) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
    }

    public Player(String name, String position, int goals, int assists) {
        this.name = name;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", goals=" + goals +
                ", assists=" + assists +
                '}';
    }
}
