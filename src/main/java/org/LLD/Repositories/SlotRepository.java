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
public class SlotRepository {
    private Map<ItemType,Map<Integer,VendingSlot>> slotMap = new HashMap<>();

    public SlotRepository(Map<ItemType,Map<Integer,VendingSlot>> slotMap){

        for(ItemType itemType : ItemType.values()){
            slotMap.put(itemType,new HashMap<>());
        }

        this.slotMap = slotMap;
    }
}
