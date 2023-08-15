package co.pragra.pragracofeetime.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TABLE_CUSTOMER")
@Data

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private Integer id;
    @Column(nullable = false)
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String phone;

}
