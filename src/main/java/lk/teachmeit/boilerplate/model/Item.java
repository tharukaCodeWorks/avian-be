package lk.teachmeit.boilerplate.model;

import lk.teachmeit.boilerplate.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String itemName;
    private ItemType itemType;
    private String itemImage;
    private Long qty;
    private Long unitPrice;
    private String itemDescription;
}
