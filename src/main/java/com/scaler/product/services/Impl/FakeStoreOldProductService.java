//package com.scaler.product.services.Impl;
//
//public class FakeStoreOldProductService {
//
//    @Autowired
//    private RestTemplateBuilder restTemplateBuilder;
//
//    @Override
//    public ProductDTO getProductById(int pId) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        try {
//            Product product = restTemplate.getForObject("https://fakestoreapi.com/products/" + pId, Product.class);
//            if (product == null) {
//                throw new NullPointerException("Product is null");
//            }
//            ProductMapper mapper = new ProductMapper();
//            return mapper.toDTO(product);
//        } catch (RuntimeException ex) {
//            System.out.println("GET PRODUCT BY ID API EXCEPTION : " + ex.getMessage());
//        }
//        return null;
//    }
//
//
//    @Override
//    public List<ProductDTO> getAllProducts() {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        try {
//            ResponseEntity<List<Product>> productList = restTemplate.exchange("https://fakestoreapi.com/products", HttpMethod.GET, null,
//                    new ParameterizedTypeReference<List<Product>>() {
//                    });
//            System.out.println("Products response -->" + Objects.requireNonNull(productList.getBody()).size());
//            if (!productList.hasBody()) {
//                throw new RuntimeException("Get products response is null");
//            }
//            ProductMapper mapper = new ProductMapper();
//            return mapper.toDTOList(productList.getBody());
//        } catch (RuntimeException ex) {
//            System.out.println("Unable to call get products :  " + ex.getMessage());
//        }
//        return null;
//    }
//}
