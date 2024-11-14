package com.restful.snackapi.security;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dmnbyasxu",
                "api_key", "648497256752256",
                "api_secret", "ECmMd2ARre9izCGuYf_6eoyQIcU"
        ));
    }

}
