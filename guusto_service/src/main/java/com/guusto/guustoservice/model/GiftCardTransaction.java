package com.guusto.guustoservice.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_transactions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GiftCardTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    @JoinColumn(name = "clientId")
    @ManyToOne
    private Client clientId;

    int quantity;
    private BigDecimal amount;
    private BigDecimal totalAmount;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
