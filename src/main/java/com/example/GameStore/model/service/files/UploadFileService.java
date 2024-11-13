package com.example.GameStore.model.service.files;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface UploadFileService {

    public String saveFile(MultipartFile file) throws IOException;

}
