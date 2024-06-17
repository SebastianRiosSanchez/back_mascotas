package com.petshop.tienda.controllers;

import com.petshop.tienda.models.Mascota;
import com.petshop.tienda.services.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = {"http://localhost:4200"})
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    private static final String UPLOAD_DIR = "C:/Users/sebas/OneDrive/Escritorio/Java/tienda/src/main/resources/images/";

    //Post
    @PostMapping
    public Mascota crearMascota(@RequestBody Mascota nuevaMascota) {
        return mascotaService.crearMascota(nuevaMascota);
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

    //UploadFile
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload.";
        }
        try {
            // Obtener el nombre del archivo original
            String fileName = file.getOriginalFilename();

            // Crear el directorio si no existe
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Guardar el archivo en el directorio especificado
            File destFile = new File(UPLOAD_DIR + fileName);
            file.transferTo(destFile);
            return "File uploaded successfully: " + fileName;

        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file.";
        }
    }

}
