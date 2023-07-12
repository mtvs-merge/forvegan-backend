package com.ohgiraffers.forepeproject.category.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Category")
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @Column
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int categoryNum;

    @Column
    private String categoryName;
}
