package lk.teachmeit.boilerplate.dto;

import lk.teachmeit.boilerplate.model.Item;
import lk.teachmeit.boilerplate.model.OrderBill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private Long id;
    private Integer qty;
    private Long itemID;
    private Long orderBillId;
}
