package ru.itis.semestrovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrovka.models.FileInfo;

import java.util.Optional;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
   // FileInfo findOneByStorageFileName(String storageFileName);

    FileInfo findByUrl(String url);

    Optional<FileInfo> findOneByUserId(Long user_id);
}
