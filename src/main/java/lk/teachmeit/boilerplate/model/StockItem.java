package lk.teachmeit.boilerplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class StockItem {
    private @Id
    Long id;
    @OneToOne
    private Item item;
    private Integer qty;
    @OneToOne
    private Grn grn;
}
