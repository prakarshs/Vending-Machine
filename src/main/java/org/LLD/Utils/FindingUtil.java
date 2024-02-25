package org.LLD.Utils;

import lombok.Data;
import org.LLD.Constants.Enums.ItemOccupancy;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.ItemSpace;
import org.LLD.Entities.VendingSlot;
import org.LLD.Repositories.SlotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class FindingUtil {
    public List<ItemSpace> findEmptySlotsGivenTypeQuantity(ItemType itemType, Integer quantity, SlotRepository slotRepository) {
        List<ItemSpace> freeSpaces = new ArrayList<>();
        if(slotRepository.getSlotMap().containsKey(itemType)){
           var slotsOfType = slotRepository.getSlotMap().get(itemType);

           for (Map.Entry<Integer,VendingSlot> slotTypeEntry : slotsOfType.entrySet()){

               for (Map.Entry<Integer, ItemSpace> spaceEntry : slotTypeEntry.getValue().getItemSpaces().entrySet()){
                   if (spaceEntry.getValue().getItemOccupancy().equals(ItemOccupancy.vacant)){
                       freeSpaces.add(spaceEntry.getValue());
                   }
               }
           }
           if (freeSpaces.size() < quantity){
               System.out.printf("!----- Not Enough Space. %d Items Left -----!",(quantity-freeSpaces.size()));
           }
        }
        else{
            System.out.println("!----- Item Type Invalid. Try WIth A Different ItemType. -----!");
        }
    return freeSpaces;
    }
}
