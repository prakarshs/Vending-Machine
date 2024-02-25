package org.LLD.Helper;

import lombok.Data;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.Item;
import org.LLD.Entities.ItemSpace;
import org.LLD.Entities.VendingSlot;
import org.LLD.Repositories.ItemSpaceRepository;
import org.LLD.Repositories.RowRepository;
import org.LLD.Repositories.SlotRepository;
import org.LLD.Repositories.VendingMachineRepository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class AutowireRepository {
    private Map<ItemType, Map<Integer, ItemSpace>> itemMapDefault = new LinkedHashMap<>();
    ItemSpaceRepository itemSpaceRepository = new ItemSpaceRepository(itemMapDefault);
    RowRepository rowRepository = new RowRepository();
    private Map<ItemType,Map<Integer, VendingSlot>> slotMapDefault = new LinkedHashMap<>();
    SlotRepository slotRepository = new SlotRepository(slotMapDefault);
    VendingMachineRepository vendingMachineRepository = new VendingMachineRepository();
}
