package de.inovex.microservices.product.model;

public class Product {

    private final long id;

    private final String name;
    private final String description;

    public Product(final long id, final String name, final ProductDetails details) {
        this.id = id;
        this.name = name;
        this.description = details.getDescription();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
