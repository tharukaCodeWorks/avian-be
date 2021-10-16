package lk.teachmeit.boilerplate.dto;

import lk.teachmeit.boilerplate.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Long id;
    private String itemName;
    private ItemType itemType;
    private String itemImage;
    private String itemDescription;
    private Long qty;
    private Long unitPrice;
}
