package agrospot.services;

import agrospot.dtos.request.ProductRequestDTO;
import agrospot.dtos.response.ProductResponseDTO;
import agrospot.models.ProductModel;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    boolean createProduct(ProductRequestDTO productDto);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductByExternalId(UUID externalId);
    boolean deleteProductByExternalId(UUID externalId);
}
