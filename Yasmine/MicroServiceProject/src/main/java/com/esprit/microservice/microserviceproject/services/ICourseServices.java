package com.esprit.microservice.microserviceproject.services;



import com.esprit.microservice.microserviceproject.entities.Course;

import java.util.List;

public interface ICourseServices {

    List<Course> retrieveAllCourses();

    Course  addCourse(Course  course,int id);

    Course updateCourse(Course course);
    List<Course> mesCourses(int id);

    Course retrieveCourse(Long numCourse);

    void removeCourse(Long numCourse);
    }


