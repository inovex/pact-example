package de.inovex.microservices.product;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.ConsumerPactTest;
import au.com.dius.pact.model.PactFragment;
import de.inovex.microservices.product.adapter.ProductDetailsFetcher;
import de.inovex.microservices.product.model.ProductDetails;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class ProductDetailsServiceConsumerTest extends ConsumerPactTest {

    @Override
    protected PactFragment createFragment(ConsumerPactBuilder.PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        return builder.uponReceiving("a request for product details")
                .path("/productdetails/1")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body("{\"id\":1,\"description\":\"This is the description for product 1\"}")
                .toFragment();

    }

    @Override
    protected String providerName() {
        return "Product_Details_Service";
    }

    @Override
    protected String consumerName() {
        return "Product_Service";
    }

    @Override
    protected void runTest(String url) {
        URI productDetailsUri = URI.create(String.format("%s/%s/%s", url, "productdetails", 1));

        ProductDetailsFetcher productDetailsFetcher = new ProductDetailsFetcher();
        ProductDetails productDetails =  productDetailsFetcher.fetchDetails(productDetailsUri);
        assertEquals(productDetails.getId(), 1);
    }
}
