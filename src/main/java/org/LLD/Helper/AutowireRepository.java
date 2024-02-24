package org.LLD.Helper;

import lombok.Data;
import org.LLD.Repositories.ItemRepository;
import org.LLD.Repositories.RowRepository;
import org.LLD.Repositories.SlotRepository;
import org.LLD.Repositories.VendingMachineRepository;

@Data
public class AutowireRepository {
    ItemRepository itemRepository = new ItemRepository();
    RowRepository rowRepository = new RowRepository();
    SlotRepository slotRepository = new SlotRepository();
    VendingMachineRepository vendingMachineRepository = new VendingMachineRepository();
}
