package main.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class GoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    private BigInteger code;

    private String category;

    public GoodEntity() {
    }

    public GoodEntity(String name, BigInteger code, String category) {
        this.name = name;
        this.code = code;
        this.category = category;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCode() {
        return code;
    }

    public void setCode(BigInteger code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public GoodEntity updateGood(String name, BigInteger code, String category) {
        if (name != null) { this.setName(name); }
        if (code != null) { this.setCode(code); }
        if (category != null) { this.setCategory(category); }
        return this;
    }
}
