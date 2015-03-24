package de.inovex.microservices.productdetails.model;

public class ProductDetails {

    private final long id;
    private final String description;

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
