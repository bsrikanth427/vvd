package com.ae.visuavid.repository;

import com.ae.visuavid.domain.OrderEntity;
import com.ae.visuavid.repository.custom.OrderRepositoryCustom;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID>, OrderRepositoryCustom {
    public List<OrderEntity> findByAdminMediaId(UUID adminMediaId);

    Optional<OrderEntity> findByOrderId(String orderId);

    Optional<List<OrderEntity>> findByRazorPayOrderId(String razorPayOrderId);

    public Optional<List<OrderEntity>> findByUserId(UUID fromString);
}
