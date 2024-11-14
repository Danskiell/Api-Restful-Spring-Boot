package com.restful.snackapi.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploadService {

    private final Cloudinary cloudinary;

    public ImageUploadService(@Value("${cloudinary.cloud_name}") String cloudName,
                              @Value("${cloudinary.api_key}") String apiKey,
                              @Value("${cloudinary.api_secret}") String apiSecret) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }

    public String uploadImage(MultipartFile file) throws IOException {
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap("public_id", "snack_api/images/" + file.getOriginalFilename(),
                        "resource_type", "auto"));

        if (uploadResult.containsKey("url")) {
            return uploadResult.get("url").toString();
        } else {
            throw new IOException("Erro ao fazer upload da imagem. Tente novamente.");
        }
    }
}
