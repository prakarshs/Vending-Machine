package org.LLD.Repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Entities.Item;
import org.LLD.Entities.VendingRow;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RowRepository {
    private Map<Integer, VendingRow> vendingRowMap = new HashMap<>();
}
