package com.exercise.Lab4.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;




}
