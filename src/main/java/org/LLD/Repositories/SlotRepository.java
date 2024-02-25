package org.LLD.Repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.Item;
import org.LLD.Entities.VendingSlot;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@Builder
public class SlotRepository {
    private Map<ItemType,Map<String,VendingSlot>> slotMap = new LinkedHashMap<>();

    public SlotRepository(Map<ItemType,Map<String,VendingSlot>> slotMap){

        for(ItemType itemType : ItemType.values()){
            slotMap.put(itemType,new LinkedHashMap<>());
        }
        this.slotMap = slotMap;
    }
}
