package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.ItemOccupancy;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemSpace {
    private String itemSpaceRefId;
    private Character rowId;
    private Integer slotId;
    private ItemOccupancy itemOccupancy;
}
