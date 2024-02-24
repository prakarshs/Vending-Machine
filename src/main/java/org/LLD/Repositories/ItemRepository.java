package org.LLD.Repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.Item;
import org.LLD.Entities.VendingSlot;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@Builder
public class ItemRepository {
    private Map<ItemType, Map<Integer, Item>> itemMap = new HashMap<>();

    public ItemRepository(Map<ItemType, Map<Integer, Item>> itemMap){
        for(ItemType itemType : ItemType.values()){
            itemMap.put(itemType,new HashMap<>());
        }

        this.itemMap = itemMap;
    }
}
