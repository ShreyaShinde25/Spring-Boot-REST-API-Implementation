package com.springrest.springrest.services;

import com.springrest.springrest.entitities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;
    String errorMessage="Error: Not found!!";

    public CourseServiceImpl(){
        list=new ArrayList<>();
        list.add(new Course(145,"Java Core Course","this course contains basics of Java"));
        list.add(new Course(4343,"Spring boot course","Creating REST API using spring boot"));

    }

    @Override
    public String addCourse(Course course) {
        String message="Courses Added!";
        list.add(course);
        return message;
    }

    @Override
    public String deleteCourse(long courseId) {
        boolean flag=false;
        String message="Successfully Deleted the course!";
        for (Course course:list){
            if(course.getId()==courseId){
                flag=true;
                list.remove(course);
                break;
            }
        }
        if (flag==true)
          return message;
        else return errorMessage;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c=null;
        for (Course course:list){
            if(course.getId()==courseId){
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public String updateCourse(Course newCourse) {
        String message="Course is updated!";

        boolean flag=false;
        for(Course course:list){
            if(course.getId()==newCourse.getId()){
                flag=true;
               course.setTitle(newCourse.getTitle());
               course.setDescription(newCourse.getDescription());
               break;
            }
        }
        if(flag==false)
            return errorMessage;
        else
            return message;
    }
}
