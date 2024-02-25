package org.LLD.Utils;

import lombok.Data;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.ItemSpace;
import org.LLD.Entities.VendingRow;
import org.LLD.Entities.VendingSlot;
import org.LLD.Repositories.ItemSpaceRepository;
import org.LLD.Repositories.RowRepository;
import org.LLD.Repositories.SlotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class DisplayUtil {

    public void allSpacesType(ItemType itemType, ItemSpaceRepository itemSpaceRepository){
        var spaceOfType = itemSpaceRepository.getItemSpaceMap().get(itemType);
        System.out.println("Item Spaces Of Type: "+itemType);
        for (Map.Entry<Integer,ItemSpace> itemSpaceEntry: spaceOfType.entrySet()){

            System.out.println(itemSpaceEntry.getKey()+","+itemSpaceEntry.getValue());
        }

    }

    public void allSlotsType(ItemType itemType, SlotRepository slotRepository) {
        var slotOfType = slotRepository.getSlotMap().get(itemType);
        System.out.println("Slots Of Type: "+itemType);
        for (Map.Entry<Integer, VendingSlot> slotEntry: slotOfType.entrySet()){

            System.out.println(slotEntry.getKey()+","+slotEntry.getKey());
        }

    }

    public void showRow(Character rowId, RowRepository rowRepository) {

        if(rowRepository.getVendingRowMap().containsKey(rowId)){
            var rowWithId = rowRepository.getVendingRowMap().get(rowId);
            System.out.println("Here Are Details For Row: "+rowId);
            System.out.println("The Slots Are: ");
            for (Map.Entry<Integer,VendingSlot> slotEntry : rowWithId.getSlots().entrySet()){

               System.out.println("Slot Index: "+slotEntry.getKey());
               System.out.println("Slot Id: "+slotEntry.getValue().getSlotId());
               System.out.println("Slot Type: "+slotEntry.getValue().getSlotType());
               System.out.println("Slot Quantity: "+slotEntry.getValue().getSlotQuantity());
               for (Map.Entry<Integer,ItemSpace> itemSpaceEntry : slotEntry.getValue().getItemSpaces().entrySet()){
                   System.out.println("Item Space ID: "+itemSpaceEntry.getValue().getItemSpaceRefId());
                   System.out.println("Item Space Occupancy: "+itemSpaceEntry.getValue().getItemOccupancy());
                   System.out.println("Item At Space: "+itemSpaceEntry.getValue().getItem().getItemName()", "+itemSpaceEntry.getValue().getItem().getItemType());
               }
            }

        }
        else System.out.println("!----- Invalid Row ID -----!");

    }
}
