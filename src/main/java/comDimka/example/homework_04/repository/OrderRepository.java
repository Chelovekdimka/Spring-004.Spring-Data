package comDimka.example.homework_04.repository;

import comDimka.example.homework_04.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
