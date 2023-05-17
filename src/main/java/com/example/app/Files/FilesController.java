package com.example.app.Files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/auth")
public class FilesController {
    @Autowired
    FilesStorageService storageService;

    @Autowired
    FileDBRepository fileDBRepository;

    @Autowired
    FileVerificacionRepository fileVerificacionRepository;

    @Autowired
    FileIncidenciaRepository fileIncidenciaRepository;

    @Autowired
    FileVehiculoRepository fileVehiculoRepository;

    @Autowired
    FIleResguardanteRepository fIleResguardanteRepository;

    @PostMapping("/upload")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("files") MultipartFile[] files, String vehiculo_id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save(file, vehiculo_id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/fotoFrente")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> fotoFrente(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save2(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/fotoDetras")
    //@PreAuthorize("hasRole()'USER' or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> fotoDetras(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save3(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/fotoDerecha")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> fotoDerecha(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save4(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/fotoIzquierda")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> fotoIzquierda(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save5(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/fotoMotor")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> fotoMotor(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save6(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }



    @PostMapping("/fotoInterior")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> fotoInterior(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save7(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/escaneoFactura")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> escaneoFactura(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save8(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/escaneoTarjetaC")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> escaneoTarjetaC(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save9(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/escaneoResguardo")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> escaneoResguardo(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save10(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/escaneoMatricula")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> escaneoMatricula(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save11(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/escaneoPoliza")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> escaneoPoliza(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save12(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/escaneoPoliza2")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> escaneoPoliza2(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save13(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/escaneoOVH")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> escaneoOVH(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save14(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/escaneoLicencia")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> escaneoLicencia(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save15(file, id);
                fileNames.add(file.getOriginalFilename());
             });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/fotoIncidencia")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> fotoIncidencia(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save16(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/escaneoVerificacion")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> escaneoVerificacion(@RequestParam("files") MultipartFile[] files, Long id) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                storageService.save17(file, id);
                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }



    @GetMapping("/files")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<FileDB>> getListFiles() {
        try {
            List<FileDB> files = fileDBRepository.findAll();

            return new ResponseEntity<>(files, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @DeleteMapping(path = "/files/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFiles(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileDBRepository.deleteById(filename.substring(0,36));
            storageService.delete(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/fotoFrente/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesFotoFrente(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete2(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/fotoDetras/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesFotoDetras(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete3(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/fotoDerecha/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesFotoDerecha(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete4(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/fotoIzquierda/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesFotoIzquierda(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete5(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/fotoMotor/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesFotoMotor(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete6(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/fotoInterior/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesFotoInterior(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete7(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/escaneoFactura/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesEscaneoFactura(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete8(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/escaneoTarjetaC/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesEscaneoTarjetaC(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete9(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/escaneoResguardo/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesEscaneoResguardo(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete10(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/escaneoMatricula/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesEscaneoMatricula(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete11(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/escaneoPoliza/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesEscaneoPoliza(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete12(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/escaneoPoliza2/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesEscaneoPoliza2(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete13(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/escaneoOVH/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesEscaneoOVH(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVehiculoRepository.deleteById(filename.substring(7,43));
            storageService.delete14(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/escaneoLicencia/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesEscaneoLicencia(@PathVariable("filename") String filename){
        String message = "";

        try {
            fIleResguardanteRepository.deleteById(filename.substring(10,46));
            storageService.delete15(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/fotoIncidencia/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesFotoIncidencia(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileIncidenciaRepository.deleteById(filename.substring(7,43));
            storageService.delete16(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @DeleteMapping(path = "/escaneoVerificacion/{filename:.+}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> deleteFilesEscaneoVerificacion(@PathVariable("filename") String filename){
        String message = "";

        try {
            fileVerificacionRepository.deleteById(filename.substring(7,43));
            storageService.delete17(filename);
            message = "Deleted the files successfully: " + filename;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to Delete files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    @GetMapping("/fotoFrente/{filename:.+}")
    public ResponseEntity<Resource> getFile2(@PathVariable String filename) {
        Resource file = storageService.load2(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/fotoDetras/{filename:.+}")
    public ResponseEntity<Resource> getFile3(@PathVariable String filename) {
        Resource file = storageService.load3(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/fotoDerecha/{filename:.+}")
    public ResponseEntity<Resource> getFile4(@PathVariable String filename) {
        Resource file = storageService.load4(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/fotoIzquierda/{filename:.+}")
    public ResponseEntity<Resource> getFile5(@PathVariable String filename) {
        Resource file = storageService.load5(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/fotoMotor/{filename:.+}")
    public ResponseEntity<Resource> getFile6(@PathVariable String filename) {
        Resource file = storageService.load6(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/fotoInterior/{filename:.+}")
    public ResponseEntity<Resource> getFile7(@PathVariable String filename) {
        Resource file = storageService.load7(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/escaneoFactura/{filename:.+}")
    public ResponseEntity<Resource> getFile8(@PathVariable String filename) {
        Resource file = storageService.load8(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/escaneoTarjetaC/{filename:.+}")
    public ResponseEntity<Resource> getFile9(@PathVariable String filename) {
        Resource file = storageService.load9(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/escaneoResguardo/{filename:.+}")
    public ResponseEntity<Resource> getFile10(@PathVariable String filename) {
        Resource file = storageService.load10(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/escaneoMatricula/{filename:.+}")
    public ResponseEntity<Resource> getFile11(@PathVariable String filename) {
        Resource file = storageService.load11(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/escaneoPoliza/{filename:.+}")
    public ResponseEntity<Resource> getFile12(@PathVariable String filename) {
        Resource file = storageService.load12(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/escaneoPoliza2/{filename:.+}")
    public ResponseEntity<Resource> getFile13(@PathVariable String filename) {
        Resource file = storageService.load13(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/escaneoOVH/{filename:.+}")
    public ResponseEntity<Resource> getFile14(@PathVariable String filename) {
        Resource file = storageService.load14(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/escaneoLicencia/{filename:.+}")
    public ResponseEntity<Resource> getFile15(@PathVariable String filename) {
        Resource file = storageService.load15(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/fotoIncidencia/{filename:.+}")
    public ResponseEntity<Resource> getFile16(@PathVariable String filename) {
        Resource file = storageService.load16(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/escaneoVerificacion/{filename:.+}")
    public ResponseEntity<Resource> getFile17(@PathVariable String filename) {
        Resource file = storageService.load17(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}