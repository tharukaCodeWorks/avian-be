package lk.teachmeit.boilerplate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockItemDto {
    private Long id;
    private Long itemId;
    private Integer qty;
    private Long grnId;
}
