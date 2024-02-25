package org.LLD.Repositories;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.ItemSpace;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@Builder
public class ItemSpaceRepository {
    private Map<ItemType, Map<Integer, ItemSpace>> itemSpaceMap = new HashMap<>();

    public ItemSpaceRepository(Map<ItemType, Map<Integer, ItemSpace>> itemSpaceMap){
        for(ItemType itemType : ItemType.values()){
            itemSpaceMap.put(itemType,new HashMap<>());
        }

        this.itemSpaceMap = itemSpaceMap;
    }
}
