package org.example.inditex.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * Product Entity
 */
@Data
@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {

    /**
     * Product Id
     */
    @Id
    @Column(name = "id_product")
    private int id;

    /**
     * Product Name
     */
    @Column(name = "name_product", length = 40)
    private String name;
}
