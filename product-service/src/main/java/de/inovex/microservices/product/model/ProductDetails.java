package de.inovex.microservices.product.model;

public class ProductDetails {

    private long id;
    private String description;

    public ProductDetails() {

    }

    public ProductDetails(final long id, final String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
