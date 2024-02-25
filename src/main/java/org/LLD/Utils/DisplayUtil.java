package org.LLD.Utils;

import lombok.Data;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.ItemSpace;
import org.LLD.Entities.VendingSlot;
import org.LLD.Repositories.ItemSpaceRepository;
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
}
