package agrospot.services.impl.product;

import agrospot.dtos.request.ProductRequestDTO;
import agrospot.dtos.response.ProductResponseDTO;
import agrospot.models.ProductModel;
import agrospot.repositorys.ProductRepository;
import agrospot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public boolean createProduct(ProductRequestDTO productDto) {
        try{
            ProductModel productModel = new ProductModel(productDto.name(), productDto.description(), productDto.pathImage());
            productRepository.save(productModel);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductModel> products = productRepository.findAll();
        return products.stream().map(productModel -> new ProductResponseDTO(productModel.getName(),
                productModel.getDescription(),
                productModel.getPathImage(),
                productModel.getExternalId())).toList();
    }

    @Override
    public ProductResponseDTO getProductByExternalId(UUID externalId) {
        try{
            ProductModel product = productRepository.findByExternalId(externalId).orElseThrow();
            return new ProductResponseDTO(product.getName(), product.getDescription(), product.getPathImage(), product.getExternalId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteProductByExternalId(UUID externalId) {
        try{
            ProductModel product = productRepository.findByExternalId(externalId).orElseThrow();
            productRepository.delete(product);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
