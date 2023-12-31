package com.example.thebridge.repositories;

import com.example.thebridge.entities.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends CrudRepository<Courses,Long> {
}
