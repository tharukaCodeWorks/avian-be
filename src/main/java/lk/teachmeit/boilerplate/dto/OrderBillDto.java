package lk.teachmeit.boilerplate.dto;

import lk.teachmeit.boilerplate.enums.OrderStatus;
import lk.teachmeit.boilerplate.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderBillDto {
    private Long id;
    private User orderedBy;
    private Date orderedAt;
    private OrderStatus orderStatus;
    private Date pendingDate;
    private Date dispatchedDate;
    private Date deliveredDate;
}
