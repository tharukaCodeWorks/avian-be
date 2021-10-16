package lk.teachmeit.boilerplate.dto;

import lk.teachmeit.boilerplate.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderTrackingDto {
    private long id;
    private Long orderBillId;
    private OrderStatus orderStatus;
    private Date date;
}
