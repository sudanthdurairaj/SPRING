package com.example.Course.Registration.System.service;

import com.example.Course.Registration.System.model.Course;
import com.example.Course.Registration.System.model.CourseRegistry;
import com.example.Course.Registration.System.repository.CourseRegistryRepo;
import com.example.Course.Registration.System.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService
{
    @Autowired
    CourseRepo courserepo;
    public List<Course> availableCourses()
    {
        return courserepo.findAll();
    }

    @Autowired
    CourseRegistryRepo courseregistryrepo;
    public List<CourseRegistry> getAllCourseRegisteredStudents()
    {
        return courseregistryrepo.findAll();
    }

    public void enrollCourse(String name, String emailId, String courseName)
    {
        CourseRegistry courseregistry = new CourseRegistry(name,emailId,courseName);
        courseregistryrepo.save(courseregistry);
    }
}
