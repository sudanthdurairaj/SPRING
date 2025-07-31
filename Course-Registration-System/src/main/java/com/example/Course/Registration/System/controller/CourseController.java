package com.example.Course.Registration.System.controller;

import com.example.Course.Registration.System.model.Course;
import com.example.Course.Registration.System.model.CourseRegistry;
import com.example.Course.Registration.System.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class CourseController {

    @Autowired
    CourseService courseservice;

    @GetMapping("courses")
    public List<Course> availableCourses()
    {
        return courseservice.availableCourses();
    }

    @GetMapping("courses/enrolled")
    public List<CourseRegistry> getAllCourseRegisteredStudents()
    {
        return courseservice.getAllCourseRegisteredStudents();
    }

    //this part is used to (frontend form part to get data from users)
    @PostMapping("courses/register")
    public String enrollCourse(@RequestParam("name") String name,
                               @RequestParam("emailId") String emailId,
                               @RequestParam("courseName") String courseName)
    {
        courseservice.enrollCourse(name,emailId,courseName);
        return "Congratulations! "+name+" Enrollment Successful for "+courseName;
    }

}
