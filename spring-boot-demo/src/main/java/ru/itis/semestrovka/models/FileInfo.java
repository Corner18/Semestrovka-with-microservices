package ru.itis.semestrovka.models;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.File;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder()
@Slf4j
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // название файла в хранилище

    @Transient
    private String storageFileName;

    @Transient
    private File sourceFile;

    // название файла оригинальное
    private String originalFileName;
    // размер файла
    private Long size;
    // тип файла (MIME)
    private String type;
    // по какому URL можно получить файл
    private String url;
    // айди юзхера
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PostLoad
    public void loadFile() {
        // persistent(path) -> transient(sourceFile, fileName)
        sourceFile = new File(url);
        storageFileName = sourceFile.getName();
        log.info("Load file for " + storageFileName);
    }

    @PreUpdate
    public void updateFileInformation() {
        // transient(sourceFile) -> persistent(path, size)
        this.url = sourceFile.getPath();
        this.size = sourceFile.length();
        this.storageFileName = sourceFile.getName();
        log.info("Update file information for " + storageFileName);
    }

}
