package lk.teachmeit.boilerplate.model;

import lk.teachmeit.boilerplate.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderTracking {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private OrderBill orderBill;
    private OrderStatus orderStatus;
    private Date date;
}
