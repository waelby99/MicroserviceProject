package com.esprit.microservice.microserviceproject.controllers;

import com.esprit.microservice.microserviceproject.entities.Course;
import com.esprit.microservice.microserviceproject.services.ICourseServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseRestController {
    
private final ICourseServices iCourseServices;
    @PostMapping("/{id}")
    public Course addCourse(@RequestBody Course course,@PathVariable int id){
        return  iCourseServices.addCourse(course,id);
    }

    @GetMapping("/")
    public List<Course> getAllCourses(){
        return iCourseServices.retrieveAllCourses();
    }

    @PutMapping("/")
    public Course updateCourse(@RequestBody Course course){
        return  iCourseServices.updateCourse(course);
    }

    @GetMapping("/{id-course}")
    public Course getById(@PathVariable("id-course") Long numCourse){
        return iCourseServices.retrieveCourse(numCourse);}

    @DeleteMapping("/{id-course}")
    public void deleteById(@PathVariable("id-course") Long numCourse){
        iCourseServices.removeCourse(numCourse); }

    @GetMapping("/user/{id}")
    public List<Course> getMesCourses(@PathVariable int id) {
        return iCourseServices.mesCourses(id);
    }
}
