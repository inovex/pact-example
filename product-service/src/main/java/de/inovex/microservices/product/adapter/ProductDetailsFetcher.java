package de.inovex.microservices.product.adapter;

import de.inovex.microservices.product.model.ProductDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class ProductDetailsFetcher {

    public ProductDetails fetchDetails(URI productDetailsUri) {
        return new RestTemplate().getForObject(productDetailsUri,
                ProductDetails.class);


    }

}
