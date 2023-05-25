package com.example.homework19.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title most not be empty")
    @Column(columnDefinition = "not null unique")
 private String title;


    @Column(columnDefinition = "not null check(category='health' or category='education' or category='programming')")
 private String category;

  @Max(value = 300)
  @Column(columnDefinition ="varchar(300) String max 300 letters" )
 private String body;


@AssertFalse
@Column(columnDefinition = "not null boolean default false")
 private boolean isPublished;


}
