package lk.teachmeit.boilerplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ItemType {
    private @Id
    Long id;
    private String itemTypeName;
    private String itemTypeImage;
}
