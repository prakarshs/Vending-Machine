package org.LLD.Services;

import org.LLD.Constants.Enums.ItemType;

public interface VendingService {

    String createVendingMachine(String vendingMachineId, Integer numberOfRows, Integer numberOfSlots, Integer numberOfItemSpaces);

    String addItems(ItemType itemType, String itemName ,Integer quantity);

    void displayAllItemsType(ItemType itemType);

    void displayRow(Character rowId);
    void displaySlot(String slotId);

    void showAllEmptySpaces();

    void showRowEmptySpaces(Character rowId);
}
