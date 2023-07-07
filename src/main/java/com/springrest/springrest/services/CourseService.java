package com.springrest.springrest.services;

import com.springrest.springrest.entitities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse(long courseId);

    public String addCourse(Course course);

    public String deleteCourse(long courseId);

    public String updateCourse(Course course);
}
