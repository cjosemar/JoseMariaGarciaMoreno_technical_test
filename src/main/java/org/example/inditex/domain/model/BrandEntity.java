package org.example.inditex.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * Brand Entity
 */
@Data
@Entity
@Table(name = "brands")
public class BrandEntity implements Serializable {
    /**
     * Brand Id.
     */
    @Id
    @Column(name = "id_brand")
    private int id;

    /**
     * Brand Name.
     */
    @Column(name = "name_brand", length = 20)
    private String name;
}
