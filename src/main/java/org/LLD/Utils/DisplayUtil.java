package org.LLD.Utils;

import lombok.Data;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.ItemSpace;
import org.LLD.Repositories.ItemSpaceRepository;
import org.LLD.Repositories.SlotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class DisplayUtil {

    public void allSpacesType(ItemType itemType, ItemSpaceRepository itemSpaceRepository){
        var spaceOfType = itemSpaceRepository.getItemSpaceMap().get(itemType);
        Integer count = 0;
        for (Map.Entry<Integer,ItemSpace> itemSpaceEntry: spaceOfType.entrySet()){
            count++;
            System.out.println(itemSpaceEntry.getKey()+","+itemSpaceEntry.getValue().getItemSpaceRefId());
        }
        System.out.println(count);
    }

    public void allSlotsType(ItemType itemType, SlotRepository slotRepository) {

        var slotOfType = slotRepository.getSlotMap().get(itemType);
        System.out.println(slotOfType);

    }
}
