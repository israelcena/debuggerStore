package com.store.api.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID orderCode = UUID.randomUUID();

    @CreationTimestamp
    private ZonedDateTime orderTime;

    @UpdateTimestamp
    private ZonedDateTime orderUpdated;

    @ManyToMany
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Customer customer;
}
