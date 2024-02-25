package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.LLD.Constants.Enums.ItemType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Item {
    private Integer itemId;
    private ItemType itemType;
}
