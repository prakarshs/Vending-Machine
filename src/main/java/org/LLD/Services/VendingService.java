package org.LLD.Services;

import org.LLD.Constants.Enums.ItemType;

public interface VendingService {

    String createVendingMachine(String vendingMachineId, Integer numberOfRows, Integer numberOfSlots, Integer numberOfItemSpaces);

    String addItems(ItemType itemType, Integer quantity);
}
