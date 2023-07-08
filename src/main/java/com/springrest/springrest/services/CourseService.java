package com.springrest.springrest.services;

import com.springrest.springrest.entitities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse(long courseId);

    public Course addCourse(Course course);

    public void deleteCourse(long parseLong);

    public Course updateCourse(Course course);
}
