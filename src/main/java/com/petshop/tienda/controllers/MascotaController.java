package com.petshop.tienda.controllers;

import com.petshop.tienda.models.Mascota;
import com.petshop.tienda.services.MascotaService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = {"http://localhost:4200"})
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    //Post
    @PostMapping
    public Mascota crearMascota(@RequestBody Mascota nuevaMascota) {
        return mascotaService.crearMascota(nuevaMascota);
    }

    //UploadFile
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Sin archivo para guardar";
        }
        try {
// Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            // Define the path where the file will be saved
            String pathSave = "C:/Users/sebas/OneDrive/Escritorio/Java/tienda/src/main/resources/images";
//            Path path = Paths.get("images" + File.separator + file.getOriginalFilename());
            Path path = Paths.get(pathSave + File.separator + file.getOriginalFilename());
            Files.write(path, bytes);

            return "You successfully uploaded '" + file.getOriginalFilename() + "'";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload '" + file.getOriginalFilename() + "'";
        }
    }

    // Get Uploaded File
    @GetMapping("/image/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws MalformedURLException {
        final String UPLOAD_DIR = "C:/Users/sebas/OneDrive/Escritorio/Java/tienda/src/main/resources/images";

        Path imagePath = Paths.get(UPLOAD_DIR).resolve(imageName);
        org.springframework.core.io.Resource resource = new UrlResource(imagePath.toUri());

        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Ajusta el tipo MIME según el tipo de imagen que manejas
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body((Resource) resource);
        } else {
            throw new RuntimeException("No se pudo cargar la imagen: " + imageName);
        }

    }

    //Get
    @GetMapping
    public List<Mascota> obtTodasMascotas() {
        return mascotaService.obtTodasMascotas();
    }

    //Get X id
    @GetMapping("/{id}")
    public Optional<Mascota> obtMascotaXId(@PathVariable("id") Long idMascota) {
        return mascotaService.obtMascotaXId(idMascota);
    }

    //Put
    @PutMapping("/{id}")
    public Mascota actMascota(@PathVariable("id") Long id, @RequestBody Mascota mascota) {
        return mascotaService.actMascota(id, mascota);
    }

}
