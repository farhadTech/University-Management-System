package com.example.ums.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"instructor", "reviews"})
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @Column(name = "credits", nullable = false)
    private int credits;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id") // refers to "course_id" column in "review" table
    private Set<Review> reviews;

    // Adding convenience method for adding reviews
    public void addReview(Review tempReview) {
        if(reviews == null) {
            reviews = new LinkedHashSet<>();
        }
        reviews.add(tempReview);
    }
}

