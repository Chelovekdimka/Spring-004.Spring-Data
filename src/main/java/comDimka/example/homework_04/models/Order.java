package comDimka.example.homework_04.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private long orderId;
    @Basic
    @Column(name = "orderNumber")
    private String orderNumber;
    @Basic
    @Column(name = "totalAmount")
    private double totalAmount;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Order() {
    }

    public Order(String orderNumber, double totalAmount, User user) {
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
        this.user = user;
    }
}