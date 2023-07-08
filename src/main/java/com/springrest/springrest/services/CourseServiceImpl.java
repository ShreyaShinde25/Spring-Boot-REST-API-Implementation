package com.springrest.springrest.services;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entitities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
   private CourseDao courseDao;


    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
//        Course c=null;
//        for (Course course:list){
//            if(course.getId()==courseId){
//                c=course;
//                break;
//            }
//        }
        return courseDao.findById(courseId).orElse(null);
    }

    @Override
    public Course addCourse(Course course) {
//        String message="Courses Added!";
//        list.add(course);
         courseDao.save(course);
        return course;
    }


    @Override
    public Course updateCourse(Course newCourse) {
//        String message="Course is updated!";
//
//        boolean flag=false;
//        for(Course course:list){
//            if(course.getId()==newCourse.getId()){
//                flag=true;
//               course.setTitle(newCourse.getTitle());
//               course.setDescription(newCourse.getDescription());
//               break;
//            }
//        }
//        if(flag==false)
//            return errorMessage;
//        else
        courseDao.save(newCourse);
        return newCourse;
    }


    @Override
    public void deleteCourse(long parseLong) {
//        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
//    Course entity = courseDao.findById(parseLong);
        Course entity= courseDao.findById(parseLong).orElse(null);
        courseDao.delete(entity);
    }

    //    List<Course> list;
//    String errorMessage="Error: Not found!!";

    public CourseServiceImpl(CourseDao courseDao){
//        list=new ArrayList<>();
//        list.add(new Course(145,"Java Core Course","this course contains basics of Java"));
//        list.add(new Course(4343,"Spring boot course","Creating REST API using spring boot"));

        this.courseDao = courseDao;
    }





}
