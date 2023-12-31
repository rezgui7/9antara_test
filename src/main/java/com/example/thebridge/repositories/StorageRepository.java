package com.example.thebridge.repositories;

import com.example.thebridge.entities.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Long> {


    Optional<ImageData> findByName(String fileName);

//    @Query("select i from ImageData i where i.toolOffer.idToolOffer=?1")
//    Optional<ImageData> findim(long idTool);


}
