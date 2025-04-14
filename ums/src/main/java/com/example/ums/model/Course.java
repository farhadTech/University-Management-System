package com.example.ums.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
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
    private Set<Review> reviews = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "course_students",
            joinColumns = @JoinColumn(name = "course_id"), // refers to "course_id" column in "course_student" join table.
            inverseJoinColumns = @JoinColumn(name = "student_id") // refers to "student_id" column in "course_student" join table.
    )
    private Set<Student> students = new LinkedHashSet<>();

    // Adding convenience method for adding reviews
    public void addReview(Review tempReview) {
        if(reviews == null) {
            reviews = new LinkedHashSet<>();
        }
        reviews.add(tempReview);
    }
}

