package lk.teachmeit.boilerplate.dto;

import lk.teachmeit.boilerplate.enums.OrderStatus;
import lk.teachmeit.boilerplate.model.Item;
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
    private Long orderedById;
    private Date orderedAt;
    private Long itemId;
    private Long qty;
    private OrderStatus orderStatus;
}
