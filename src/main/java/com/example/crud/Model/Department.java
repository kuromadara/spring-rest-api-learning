package com.example.crud.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;
    private String address;

    @Column(name = "is_deleted")
    private String isDeleted = "false";


    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean isDeleted() {
        return isDeleted.equals("true");
    }

}
