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
public class VendingRow {
    private Character vendingRowId;
    private Map<Integer, VendingSlot> slots;
}
