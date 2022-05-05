package com.zlz.spider.entity;

public class ServoData {

    private Integer id;

    private String name;

    private Integer process = 0;

    public Integer getProcess() {
        return process;
    }

    public void setProcess(Integer process) {
        this.process = process;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServoData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", process=" + process +
                '}';
    }
}
