package com.hibernate.CollMappObject.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students", schema = "test_db")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "avg_grade")
    private Double avgGrade;

    @ElementCollection       // Создается таблица Student_friends по дефолту
    @CollectionTable(name = "st_friends", joinColumns = @JoinColumn(name = "student_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "st_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "st_surname")),
            @AttributeOverride(name = "age", column = @Column(name = "st_age"))
    })
    @Column(name = "friends_name")
    List<Friend> friends = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String surname, Double avgGrade, List<Friend> friends) {
        this.name = name;
        this.surname = surname;
        this.avgGrade = avgGrade;
        this.friends = friends;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", avgGrade=" + avgGrade +
                ", friends=" + friends +
                '}';
    }
}
