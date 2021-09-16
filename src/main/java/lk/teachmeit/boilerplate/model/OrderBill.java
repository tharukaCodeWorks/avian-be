package lk.teachmeit.boilerplate.model;

import lk.teachmeit.boilerplate.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class OrderBill {
    private @Id
    Long id;
    @OneToOne
    private User orderedBy;
    private Date orderedAt;
    private OrderStatus orderStatus;
    private Date pendingDate;
    private Date dispatchedDate;
    private Date deliveredDate;
}
