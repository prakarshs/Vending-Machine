package org.LLD.Utils;

import lombok.Data;
import org.LLD.Constants.Enums.ItemOccupancy;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.ItemSpace;
import org.LLD.Entities.VendingSlot;
import org.LLD.Repositories.ItemSpaceRepository;
import org.LLD.Repositories.RowRepository;
import org.LLD.Repositories.SlotRepository;

import java.util.List;
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

    public void allEmptySpaces(ItemSpaceRepository itemSpaceRepository) {

        for (Map.Entry<ItemType, Map<Integer,ItemSpace>> itemSpaceEntry : itemSpaceRepository.getItemSpaceMap().entrySet()){
            System.out.println("For Item Type: "+itemSpaceEntry.getKey()+" These Are The Empty Spaces");
            boolean flag = false;
            for (Map.Entry<Integer,ItemSpace> spaceEntry : itemSpaceEntry.getValue().entrySet()){

              if (spaceEntry.getValue().getItemOccupancy().equals(ItemOccupancy.vacant)){
                  flag = true;
                  System.out.println("Item Space ID: "+spaceEntry.getValue().getItemSpaceRefId());
                  System.out.println("Item Space ID: "+spaceEntry.getValue().getItemOccupancy());
                }
            }
            if(!flag) System.out.println("No Free Spaces For "+itemSpaceEntry.getKey());
        }
    }

    public void rowEmptySpaces(Character rowId,RowRepository rowRepository) {
        if(rowRepository.getVendingRowMap().containsKey(rowId)){
            var rowWithId = rowRepository.getVendingRowMap().get(rowId);
            for (Map.Entry<String,VendingSlot> slotEntry : rowWithId.getSlots().entrySet()){
                System.out.println("For Slot "+slotEntry.getKey()+" Of Type "+slotEntry.getValue().getSlotType()+" These Spaces Are Vacant: ");
                boolean flag = false;
                for (Map.Entry<Integer,ItemSpace> spaceEntry : slotEntry.getValue().getItemSpaces().entrySet()){

                    if(spaceEntry.getValue().getItemOccupancy().equals(ItemOccupancy.vacant)){
                        flag = true;
                        System.out.println("ItemSpace Id: "+spaceEntry.getValue().getItemSpaceRefId());
                        System.out.println("ItemSpace Id: "+spaceEntry.getValue().getItemOccupancy());
                    }
                }
                if(!flag) System.out.println("No Free Spaces In Slot "+slotEntry.getKey());
            }
        }
        else System.out.println("!----- Invalid Row ID -----!");



    }

    public void typeEmptySpaces(List<ItemSpace> emptySpaces) {
        if(!emptySpaces.isEmpty()) {
            emptySpaces.stream().forEach(itemSpace -> {

                System.out.println("Item Space: " + itemSpace.getItemSpaceRefId());

            });
        }
        else System.out.println("No Empty Spaces Left For Item.");

    }

    public void slotEmptySpaces(String slotId, SlotRepository slotRepository) {
        boolean found = false;
        boolean flag = false;
        System.out.println("For Slot "+slotId+": ");
        for (Map.Entry<ItemType,Map<String,VendingSlot>> slotEntry : slotRepository.getSlotMap().entrySet()){

            if (slotEntry.getValue().containsKey(slotId)){
                found = true;
                var slotWithId = slotEntry.getValue().get(slotId);
                for (Map.Entry<Integer,ItemSpace> spaceEntry : slotWithId.getItemSpaces().entrySet()){
                    if (spaceEntry.getValue().getItemOccupancy().equals(ItemOccupancy.vacant)){
                        flag = true;
                        System.out.println("ItemSpace Id: "+spaceEntry.getValue().getItemSpaceRefId());
                    }

                }
            }
        }
        if(!found) System.out.println("!----- Invalid Slot ID -----!");
        if(!flag)  System.out.println(" No vacant Spaces In Slot "+slotId);
    }
}
