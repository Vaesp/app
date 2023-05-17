package com.example.app.Files;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import com.example.app.Repositories.ResguardanteRepository;
import com.example.app.Repositories.Tramites.VerificacionRepository;
import org.apache.commons.io.FilenameUtils;

import com.example.app.Repositories.Tramites.ReporteIncidenciasRepository;
import com.example.app.Repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements com.example.app.Files.FilesStorageService {
    @Autowired
    FileDBRepository fileDBRepository;

    @Autowired
    FileIncidenciaRepository fileIncidenciaRepository;

    @Autowired
    FileVehiculoRepository fileVehiculoRepository;

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Autowired
    ReporteIncidenciasRepository reporteIncidenciasRepository;

    @Autowired
    ResguardanteRepository resguardanteRepository;

    @Autowired
    FIleResguardanteRepository fIleResguardanteRepository;

    @Autowired
    FileVerificacionRepository fileVerificacionRepository;

    @Autowired
    VerificacionRepository verificacionRepository;

    private final Path root = Paths.get("../../files");
    private final Path root2 = Paths.get("../../files/fotoFrente");
    private final Path root3 = Paths.get("../../files/fotoDetras");
    private final Path root4 = Paths.get("../../files/fotoDerecha");
    private final Path root5 = Paths.get("../../files/fotoIzquierda");
    private final Path root6 = Paths.get("../../files/fotoMotor");
    private final Path root7 = Paths.get("../../files/fotoInterior");
    private final Path root8 = Paths.get("../../files/escaneoFactura");
    private final Path root9 = Paths.get("../../files/escaneoTarjetaC");
    private final Path root10 = Paths.get("../../files/escaneoResguardo");
    private final Path root11 = Paths.get("../../files/escaneoMatricula");
    private final Path root12 = Paths.get("../../files/escaneoPoliza");
    private final Path root13 = Paths.get("../../files/escaneoPoliza2");
    private final Path root14 = Paths.get("../../files/escaneoOVH");
    private final Path root15 = Paths.get("../../files/escaneoLicencia");
    private final Path root16 = Paths.get("../../files/fotoIncidencia");
    private final Path root17 = Paths.get("../../files/escaneoVerificacion");

    @Override
    public void init() {

        if (!Files.exists(root)) {
            try {
                Files.createDirectory(root);
                System.out.println(LocalDateTime.now() + " - Carpeta 'fileUploads' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'fileUploads' encontrada");
        }

        if (!Files.exists(root2)) {
            try {
                Files.createDirectory(root2);
                System.out.println(LocalDateTime.now() + " - Carpeta 'fotoFrente' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'fotoFrente' encontrada");
        }

        if (!Files.exists(root3)) {
            try {
                Files.createDirectory(root3);
                System.out.println(LocalDateTime.now() + " - Carpeta 'fotoDetras' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'fotoDetras' encontrada");
        }

        if (!Files.exists(root4)) {
            try {
                Files.createDirectory(root4);
                System.out.println(LocalDateTime.now() + " - Carpeta 'fotoDerecha' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'fotoDerecha' encontrada");
        }

        if (!Files.exists(root5)) {
            try {
                Files.createDirectory(root5);
                System.out.println(LocalDateTime.now() + " - Carpeta 'fotoIzquierda' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'fotoIzquierda' encontrada");
        }

        if (!Files.exists(root6)) {
            try {
                Files.createDirectory(root6);
                System.out.println(LocalDateTime.now() + " - Carpeta 'fotoMotor' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'fotoMotor' encontrada");
        }

        if (!Files.exists(root7)) {
            try {
                Files.createDirectory(root7);
                System.out.println(LocalDateTime.now() + " - Carpeta 'fotoInterior' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'fotoInterior' encontrada");
        }

        if (!Files.exists(root8)) {
            try {
                Files.createDirectory(root8);
                System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoFactura' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoFactura' encontrada");
        }

        if (!Files.exists(root9)) {
            try {
                Files.createDirectory(root9);
                System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoTarjetaC' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoTarjetaC' encontrada");
        }

        if (!Files.exists(root10)) {
            try {
                Files.createDirectory(root10);
                System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoResguardo' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoResguardo' encontrada");
        }

        if (!Files.exists(root11)) {
            try {
                Files.createDirectory(root11);
                System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoMatricula' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoMatricula' encontrada");
        }

        if (!Files.exists(root12)) {
            try {
                Files.createDirectory(root12);
                System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoPoliza' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoPoliza' encontrada");
        }

        if (!Files.exists(root13)) {
            try {
                Files.createDirectory(root13);
                System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoPoliza2' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoPoliza2' encontrada");
        }

        if (!Files.exists(root14)) {
            try {
                Files.createDirectory(root14);
                System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoOVH' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoOVH' encontrada");
        }

        if (!Files.exists(root15)) {
            try {
                Files.createDirectory(root15);
                System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoLicencia' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoLicencia' encontrada");
        }

        if (!Files.exists(root16)) {
            try {
                Files.createDirectory(root16);
                System.out.println(LocalDateTime.now() + " - Carpeta 'fotoIncidencia' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'fotoIncidencia' encontrada");
        }

        if (!Files.exists(root17)) {
            try {
                Files.createDirectory(root17);
                System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoVerificacion' creada");
            } catch (IOException e) {
                throw new RuntimeException(LocalDateTime.now() + " - Could not initialize folder for upload!");
            }
            System.out.println(LocalDateTime.now() + " - Carpeta 'escaneoVerificacion' encontrada");
        }

    }

    @Autowired
    TipoFileVehiculoRepository tipoFileVehiculoRepository;

    @Override
    public void save(MultipartFile file, String folio) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();
            String path = fileDB.getId() + "." + FilenameUtils.getExtension(filename);
            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.findByNoEconomico(folio));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(1L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }


    public void save2(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();
            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(1L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root2.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }


    public void save3(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);


            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(2L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root3.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save4(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(3L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root4.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save5(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(4L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root5.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }

    }


    public void save6(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(5L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root6.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save7(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(6L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root7.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save8(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(7L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root8.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save9(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(8L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root9.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save10(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(9L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root10.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save11(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(10L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root11.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save12(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(11L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root12.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save13(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(12L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root13.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save14(MultipartFile file, Long id) {

        try {
            FileVehiculo fileDB = new FileVehiculo();
            fileVehiculoRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = vehiculoRepository.getById(id).getNoEconomico().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVehiculo(vehiculoRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));
            fileDB.setTipoFileVehiculo(tipoFileVehiculoRepository.getById(13L));

            fileVehiculoRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root14.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save15(MultipartFile file, Long id) {

        try {
            FileResguardante fileDB = new FileResguardante();
            fIleResguardanteRepository.save(fileDB);


            String filename = file.getOriginalFilename();

            String ext = resguardanteRepository.getById(id).getNoLicencia().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setResguardante(resguardanteRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));

            fIleResguardanteRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root15.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }


    public void save16(MultipartFile file, Long id) {

        try {
            FileIncidencia fileDB = new FileIncidencia();
            fileIncidenciaRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = reporteIncidenciasRepository.getById(id).getFolio().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setReporteIncidencias(reporteIncidenciasRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));

            fileIncidenciaRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root16.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save17(MultipartFile file, Long id) {

        try {
            FileVerificacion fileDB = new FileVerificacion();
            fileVerificacionRepository.save(fileDB);

            String filename = file.getOriginalFilename();

            String ext = verificacionRepository.getById(id).getFolio().toString();
            String path = ext + "_" + fileDB.getId() + "." + FilenameUtils.getExtension(filename);

            fileDB.setName(path);
            fileDB.setVerificacion(verificacionRepository.getById(id));
            fileDB.setTimestamp(LocalDateTime.now().withNano(0));

            fileVerificacionRepository.save(fileDB);
            Files.copy(file.getInputStream(), this.root17.resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load2(String filename) {
        try {
            Path file = root2.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load3(String filename) {
        try {
            Path file = root3.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load4(String filename) {
        try {
            Path file = root4.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load5(String filename) {
        try {
            Path file = root5.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load6(String filename) {
        try {
            Path file = root6.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load7(String filename) {
        try {
            Path file = root7.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load8(String filename) {
        try {
            Path file = root8.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load9(String filename) {
        try {
            Path file = root9.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load10(String filename) {
        try {
            Path file = root10.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load11(String filename) {
        try {
            Path file = root11.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load12(String filename) {
        try {
            Path file = root12.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load13(String filename) {
        try {
            Path file = root13.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load14(String filename) {
        try {
            Path file = root14.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load15(String filename) {
        try {
            Path file = root15.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load16(String filename) {
        try {
            Path file = root16.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource load17(String filename) {
        try {
            Path file = root17.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void delete(String filename) {
        try {
            File path = new File(root + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete2(String filename) {
        try {
            Path file = root2.resolve(filename);
            //File path= new File(root2+"/"+filename);
            file.toFile().delete();
            //FileSystemUtils.deleteRecursively(root2.resolve(filename));
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete3(String filename) {
        try {
            File path = new File(root3 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete4(String filename) {
        try {
            File path = new File(root4 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete5(String filename) {
        try {
            File path = new File(root5 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete6(String filename) {
        try {
            File path = new File(root6 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete7(String filename) {
        try {
            File path = new File(root7 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete8(String filename) {
        try {
            File path = new File(root8 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete9(String filename) {
        try {
            File path = new File(root9 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete10(String filename) {
        try {
            File path = new File(root10 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete11(String filename) {
        try {
            File path = new File(root11 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete12(String filename) {
        try {
            File path = new File(root12 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete13(String filename) {
        try {
            File path = new File(root13 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete14(String filename) {
        try {
            File path = new File(root14 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete15(String filename) {
        try {
            File path = new File(root15 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete16(String filename) {
        try {
            File path = new File(root16 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete17(String filename) {
        try {
            File path = new File(root17 + "/" + filename);
            path.delete();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
        fileDBRepository.deleteAll();
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}