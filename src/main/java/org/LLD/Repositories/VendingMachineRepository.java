package org.LLD.Repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Entities.VendingMachineUnit;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendingMachineRepository {
    private Map<Integer, VendingMachineUnit> vendingMachineMap = new HashMap<>();
}
