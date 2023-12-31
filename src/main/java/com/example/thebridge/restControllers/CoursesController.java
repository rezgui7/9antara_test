package com.example.thebridge.restControllers;

import com.example.thebridge.entities.Courses;
import com.example.thebridge.entities.ImageData;
import com.example.thebridge.services.CoursesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    @PostMapping("/addCourses")
    public Courses addCourses(@RequestBody Courses o){return coursesService.addCourses(o);}

    @GetMapping("/displayCourses")
    public List<Courses> displayCourses(){ return (List<Courses>) coursesService.displayCourses();}

    @GetMapping("/displayCourse/{courseId}")
    public Courses displayCourse(@PathVariable("courseId") long idCourses){return coursesService.displayCourses((int)idCourses);}


    @PutMapping("/updateCourses")
    public Courses modifieCourses(@RequestBody Courses o){ return coursesService.modifieCourses(o); }


    @DeleteMapping("/deleteCourses/{courseId}")
    public void deleteCourses(@PathVariable("courseId") long courseId){coursesService.deleteCourses(courseId);}

//------------------------------Add with image----------------------------------------------------------
@PostMapping(value = {"/addNewCourse"},produces = {"text/plain","application/json"}, consumes= {"multipart/mixed", MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_OCTET_STREAM_VALUE})
public ResponseEntity<String> addNewCourse(@RequestPart("course") @Valid Courses course,
                                            @RequestPart("file") MultipartFile[] file){
    try{
        List<ImageData> images = uploadImage(file);
        course.setImages(images);
        coursesService.addCourses(course);
        return ResponseEntity.ok("File and JSON data received");
    } catch (Exception e ){
        System.out.println(e.getMessage());
        return null;
    }
}

    public List<ImageData> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        List<ImageData> imageDatas = new ArrayList<>();
        for (MultipartFile file: multipartFiles) {
            ImageData imageData = new ImageData(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageDatas.add(imageData);
        }


        return imageDatas;
    }
}
