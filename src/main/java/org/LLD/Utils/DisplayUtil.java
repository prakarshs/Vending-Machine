package org.LLD.Utils;

import lombok.Data;
import org.LLD.Constants.Enums.ItemOccupancy;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.ItemSpace;
import org.LLD.Entities.VendingSlot;
import org.LLD.Repositories.ItemSpaceRepository;
import org.LLD.Repositories.RowRepository;
import org.LLD.Repositories.SlotRepository;

import java.util.Map;

@Data
public class DisplayUtil {

    public void allSpacesType(ItemType itemType, ItemSpaceRepository itemSpaceRepository) {
        var spaceOfType = itemSpaceRepository.getItemSpaceMap().get(itemType);
        System.out.println("Item Spaces Of Type: " + itemType);
        for (Map.Entry<Integer, ItemSpace> itemSpaceEntry : spaceOfType.entrySet()) {

            System.out.println(itemSpaceEntry.getKey() + "," + itemSpaceEntry.getValue());
        }

    }

    public void allSlotsType(ItemType itemType, SlotRepository slotRepository) {
        var slotOfType = slotRepository.getSlotMap().get(itemType);
        System.out.println("Slots Of Type: " + itemType);
        for (Map.Entry<String, VendingSlot> slotEntry : slotOfType.entrySet()) {

            System.out.println(slotEntry.getKey() + "," + slotEntry.getKey());
        }

    }

    public void showRow(Character rowId, RowRepository rowRepository) {

        if (rowRepository.getVendingRowMap().containsKey(rowId)) {
            var rowWithId = rowRepository.getVendingRowMap().get(rowId);
            System.out.println("Here Are Details For Row: " + rowId);
            System.out.println("The Slots Are: ");
            for (Map.Entry<String, VendingSlot> slotEntry : rowWithId.getSlots().entrySet()) {

                System.out.println("Slot Index: " + slotEntry.getKey());
                System.out.println("Slot Id: " + slotEntry.getValue().getSlotId());
                System.out.println("Slot Type: " + slotEntry.getValue().getSlotType());
                System.out.println("Slot Quantity: " + slotEntry.getValue().getSlotQuantity());
                for (Map.Entry<Integer, ItemSpace> itemSpaceEntry : slotEntry.getValue().getItemSpaces().entrySet()) {
                    System.out.println("Item Space ID: " + itemSpaceEntry.getValue().getItemSpaceRefId());
                    System.out.println("Item Space Occupancy: " + itemSpaceEntry.getValue().getItemOccupancy());
                    if (itemSpaceEntry.getValue().getItemOccupancy() == ItemOccupancy.filled) {
                        System.out.println("Item At Space: " + itemSpaceEntry.getValue().getItem().getItemName() + ", " + itemSpaceEntry.getValue().getItem().getItemType());
                    }
                }
            }

        } else System.out.println("!----- Invalid Row ID -----!");

    }

    public void showSlot(String slotId, SlotRepository slotRepository) {
        boolean found = false;
        for (Map.Entry<ItemType,Map<String,VendingSlot>> slotEntry : slotRepository.getSlotMap().entrySet()){
            if(slotEntry.getValue().containsKey(slotId)){
                var slotEntryId = slotEntry.getValue().get(slotId);
                found = true;
                System.out.println("Slot Id: " + slotEntryId.getSlotId());
                System.out.println("Slot Type: " + slotEntryId.getSlotType());
                System.out.println("Slot Quantity: " + slotEntryId.getSlotQuantity());
                for (Map.Entry<Integer, ItemSpace> itemSpaceEntry : slotEntryId.getItemSpaces().entrySet()) {
                    System.out.println("Item Space ID: " + itemSpaceEntry.getValue().getItemSpaceRefId());
                    System.out.println("Item Space Occupancy: " + itemSpaceEntry.getValue().getItemOccupancy());
                    if (itemSpaceEntry.getValue().getItemOccupancy() == ItemOccupancy.filled) {
                        System.out.println("Item At Space: " + itemSpaceEntry.getValue().getItem().getItemName() + ", " + itemSpaceEntry.getValue().getItem().getItemType());
                    }
                }
            }
        }
        if(!found) System.out.println("!----- Invalid Slot ID -----!");

    }
}
