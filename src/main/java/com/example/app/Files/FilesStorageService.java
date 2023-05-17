package com.example.app.Files;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
public interface FilesStorageService {
    public void init();
    public void save(MultipartFile file, String folio);
    public void save2(MultipartFile file, Long id);
    public void save3(MultipartFile file, Long id);
    public void save4(MultipartFile file, Long id);
    public void save5(MultipartFile file, Long id);
    public void save6(MultipartFile file, Long id);
    public void save7(MultipartFile file, Long id);
    public void save8(MultipartFile file, Long id);
    public void save9(MultipartFile file, Long id);
    public void save10(MultipartFile file, Long id);
    public void save11(MultipartFile file, Long id);
    public void save12(MultipartFile file, Long id);
    public void save13(MultipartFile file, Long id);
    public void save14(MultipartFile file, Long id);
    public void save15(MultipartFile file, Long id);
    public void save16(MultipartFile file, Long id);
    public void save17(MultipartFile file, Long id);

    public Resource load(String filename);
    public Resource load2(String filename);
    public Resource load3(String filename);
    public Resource load4(String filename);
    public Resource load5(String filename);
    public Resource load6(String filename);
    public Resource load7(String filename);
    public Resource load8(String filename);
    public Resource load9(String filename);
    public Resource load10(String filename);
    public Resource load11(String filename);
    public Resource load12(String filename);
    public Resource load13(String filename);
    public Resource load14(String filename);
    public Resource load15(String filename);
    public Resource load16(String filename);
    public Resource load17(String filename);

    public void delete(String filename);
    public void delete2(String filename);
    public void delete3(String filename);
    public void delete4(String filename);
    public void delete5(String filename);
    public void delete6(String filename);
    public void delete7(String filename);
    public void delete8(String filename);
    public void delete9(String filename);
    public void delete10(String filename);
    public void delete11(String filename);
    public void delete12(String filename);
    public void delete13(String filename);
    public void delete14(String filename);
    public void delete15(String filename);
    public void delete16(String filename);
    public void delete17(String filename);
    public void deleteAll();
    public Stream<Path> loadAll();
}