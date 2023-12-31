package com.example.thebridge.services;

import com.example.thebridge.entities.Courses;
import com.example.thebridge.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //ou @Component
@Transactional
public class CoursesService {
    @Autowired
    CoursesRepository coursesRepository;

//----------------------CRUD--------------------------------------------------------------------------------------

    public Courses addCourses(Courses o){return coursesRepository.save(o);}

    public List<Courses> displayCourses(){ return (List<Courses>) coursesRepository.findAll();}

    public Courses displayCourses(long idCourses){return coursesRepository.findById(idCourses).get();}

    public Courses modifieCourses(Courses o){ return coursesRepository.save(o); }

    public void deleteCourses(long o){coursesRepository.deleteById(o);}

}
