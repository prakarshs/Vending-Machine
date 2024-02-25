package org.LLD.Utils;

import lombok.Data;
import org.LLD.Constants.Enums.ItemOccupancy;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.ItemSpace;
import org.LLD.Entities.VendingSlot;
import org.LLD.Repositories.ItemSpaceRepository;
import org.LLD.Repositories.SlotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class FindingUtil {
    public List<ItemSpace> listEmptySpacesGivenType(ItemType itemType, ItemSpaceRepository itemSpaceRepository) {
        List<ItemSpace> freeSpaces = new ArrayList<>();
        if(itemSpaceRepository.getItemSpaceMap().containsKey(itemType)){
           var spacesOfType = itemSpaceRepository.getItemSpaceMap().get(itemType);

               for (Map.Entry<Integer, ItemSpace> spaceEntry : spacesOfType.entrySet()){
                   if (spaceEntry.getValue().getItemOccupancy().equals(ItemOccupancy.vacant)){
                       freeSpaces.add(spaceEntry.getValue());
                   }
               }
        }
        else{
            System.out.println("!----- Item Type Invalid. Try WIth A Different ItemType. -----!");
            return null;
        }
    return freeSpaces;
    }

    public List<ItemSpace> listEmptySpacesGivenTypeQuantity(ItemType itemType, Integer quantity, ItemSpaceRepository spaceRepository) {
        List<ItemSpace> freeSpaces = new ArrayList<>();
        Integer count = 0;
        if(spaceRepository.getItemSpaceMap().containsKey(itemType)){
           Map<Integer,ItemSpace> spacesOfType = spaceRepository.getItemSpaceMap().get(itemType);

           for (Map.Entry<Integer,ItemSpace> itemSpaceEntry : spacesOfType.entrySet()){

                   if (itemSpaceEntry.getValue().getItemOccupancy().equals(ItemOccupancy.vacant)){
                       count++;
                       if(count <= quantity) {
                           freeSpaces.add(itemSpaceEntry.getValue());
                       }
                       else break;
               }
           }
           if (freeSpaces.size() < quantity){
               System.out.printf("!----- Not Enough Space. %d Items Left -----!\n",(quantity-freeSpaces.size()));
           }
        }
        else{
            System.out.println("!----- Item Type Invalid. Try WIth A Different ItemType. -----!");
            return null;
        }
    return freeSpaces;
    }
}
