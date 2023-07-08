package com.springrest.springrest.controller;

import com.springrest.springrest.entitities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
     private CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to my Courses Application";
    }

    //get the courses

    @GetMapping("/courses")
    //alternative for above statement for MVC
    //@RequestMapping(path="/courses", method=RequestMethod.GET)

    public List<Course> getCourses(){
      return this.courseService.getCourses();
}
   @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){  //to insert dynamic courseID
        return this.courseService.getCourse(Long.parseLong(courseId));
    }
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
      return this.courseService.addCourse(course);
    }

//    @DeleteMapping("/courses/{courseId}")
//    public String deleteCourse(@PathVariable String courseId){
//        return this.courseService.deleteCourse(Long.parseLong(courseId));
//    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }
}
