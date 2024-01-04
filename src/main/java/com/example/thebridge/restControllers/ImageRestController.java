package com.example.thebridge.restControllers;

import com.example.thebridge.entities.ImageData;
import com.example.thebridge.services.CoursesService;
import com.example.thebridge.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/image")
public class ImageRestController {
    @Autowired
    private StorageService service;

    @Autowired
    private CoursesService coursesService;

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<?> uploadImage(@RequestParam long idTool,@RequestPart("image") MultipartFile file) throws IOException, IOException {
//        String uploadImage = service.uploadImage(idTool, file);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(uploadImage);
//    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData=service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
    @GetMapping("/getall")
    public List<ImageData> displayToolOffers(){ return (List<ImageData>) service.displayToolOffers();}
//    @GetMapping("/displayImages")
//    public List<ImageData> displayImages(){ return (List<ImageData>) service.displayImages();}



}
