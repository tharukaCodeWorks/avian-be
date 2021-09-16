package lk.teachmeit.boilerplate.dto;

import lk.teachmeit.boilerplate.model.ItemType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ItemTypeDto {
    private @Id
    Long id;
    private String itemTypeName;
    private MultipartFile itemTypeImageMultipart;
}
