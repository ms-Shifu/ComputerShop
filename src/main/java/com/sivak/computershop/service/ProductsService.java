package com.sivak.computershop.service;

import com.sivak.computershop.entities.Laptops;
import com.sivak.computershop.entities.Phones;
import com.sivak.computershop.entities.Products;
import com.sivak.computershop.entities.Tablets;
import com.sivak.computershop.repos.LaptopsRepo;
import com.sivak.computershop.repos.PhonesRepo;
import com.sivak.computershop.repos.TabletsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ProductsService {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private LaptopsRepo laptopsRepo;

    @Autowired
    private TabletsRepo tabletsRepo;

    @Autowired
    private PhonesRepo phonesRepo;

    public void saveProduct(Products product, MultipartFile file) throws IOException {

        File uploadsFile = new File(uploadPath);

        if (!uploadsFile.exists()) {
            uploadsFile.mkdir();
        }

        String uuidName = UUID.randomUUID().toString();
        String resultFileName = uuidName + "." + file.getOriginalFilename();

        if (product instanceof Laptops) {
           product.setFileName(resultFileName);

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            laptopsRepo.save((Laptops) product);
        }

        if (product instanceof Tablets) {
            product.setFileName(resultFileName);

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            tabletsRepo.save((Tablets) product);
        }

         if (product instanceof Phones) {
            product.setFileName(resultFileName);

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            phonesRepo.save((Phones) product);
        }
    }
}
