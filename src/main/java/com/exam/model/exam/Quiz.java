package com.exam.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "qId")
    private Long qId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private boolean active=false;


    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    /*@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private Set<Question> questionSet= new HashSet<>();*/

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Question> question= new HashSet<>();

}
