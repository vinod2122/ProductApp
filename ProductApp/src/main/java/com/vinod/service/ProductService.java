package com.vinod.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vinod.model.Product;
import com.vinod.repo.ProductRepo;
import com.vinod.util.ImageUtil;

@Service
public class ProductService {
	@Autowired
	private ProductRepo prdRepo;
	public Product uploadImage(MultipartFile file) throws IOException {
		Product pImage = new Product();
		pImage.setName(file.getOriginalFilename());
		pImage.setType(file.getContentType());
		pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
		return prdRepo.save(pImage);
	}
	
	public byte[] downloadImage(String fileName){
        Optional<Product> imageData = prdRepo.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }

}
