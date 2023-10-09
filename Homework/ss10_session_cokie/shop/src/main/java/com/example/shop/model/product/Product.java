package com.example.shop.model.product;

import javax.persistence.*;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;
    private String name;
    private String image;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    private float price;
    private long quantity;
    private short discount;

    public Product() {
    }

    public Product(long id, String name, String image, String description, float price, long quantity, short discount) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if (Float.compare(product.getPrice(), getPrice()) != 0) return false;
        if (getQuantity() != product.getQuantity()) return false;
        if (getDiscount() != product.getDiscount()) return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        if (getImage() != null ? !getImage().equals(product.getImage()) : product.getImage() != null) return false;
        return getDescription() != null ? getDescription().equals(product.getDescription()) : product.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getPrice() != +0.0f ? Float.floatToIntBits(getPrice()) : 0);
        result = 31 * result + (int) (getQuantity() ^ (getQuantity() >>> 32));
        result = 31 * result + (int) getDiscount();
        return result;
    }
}
