package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.ItemType;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendingSlot {
    private String slotId;
    private Integer slotQuantity;
    private ItemType slotType;
    private Map<Integer, ItemSpace> itemSpaces;
}
