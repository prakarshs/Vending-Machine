package org.LLD.Services;

import org.LLD.Constants.Enums.ItemOccupancy;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Entities.*;
import org.LLD.Helper.AutowireRepository;
import org.LLD.Helper.AutowireUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VendingServiceIMPL implements VendingService{

    AutowireRepository autowireRepository = new AutowireRepository();
    AutowireUtil autowireUtil = new AutowireUtil();
    @Override
    public String createVendingMachine(String vendingMachineId, Integer numberOfRows, Integer numberOfSlots, Integer numberOfItemSpaces) {
        Character vendingRowId = 'A';
        Integer itemSpaceIndex = 1;
        Integer slotIndex = 1;
        Integer vendingMachineIndex = 1;

        Map<Character, VendingRow> machineBuilt = new LinkedHashMap<>();
        for (int rows = 1; rows <= numberOfRows; rows++){
            Map<Integer, VendingSlot> rowBuilt = new LinkedHashMap<>();
            for (int slots = 1; slots <= numberOfSlots; slots++){
                Map<Integer, ItemSpace> slotBuilt = new LinkedHashMap<>();
                ItemType spaceType = ItemType.Namkeen;
                for (int itemSpaces = 1; itemSpaces <= numberOfItemSpaces; itemSpaces++){
                    ItemSpace itemSpace = ItemSpace.builder()
                            .itemSpaceRefId(vendingRowId +"_"+ slots +"_"+itemSpaces )
                            .itemOccupancy(ItemOccupancy.vacant)
                            .rowId(vendingRowId)
                            .slotId(slots)
                            .build();

                    if(rows == numberOfRows)spaceType = ItemType.Beverage;
                    if(rows == numberOfRows - 1)spaceType = ItemType.Condiments;
                    if(rows < numberOfRows -1 && slots%2 == 0)spaceType = ItemType.Sweet;
                    if(rows < numberOfRows -1 && slots%2 == 1)spaceType = ItemType.Namkeen;

                    autowireRepository.getItemSpaceRepository().getItemSpaceMap().get(spaceType).put(itemSpaceIndex,itemSpace);

                    slotBuilt.put(itemSpaces,itemSpace);

                    itemSpaceIndex++;
                }
                VendingSlot vendingSlot = VendingSlot.builder()
                        .itemSpaces(slotBuilt)
                        .slotId(vendingRowId +"_"+ slots)
                        .slotQuantity(numberOfItemSpaces)
                        .slotType(spaceType)
                        .build();
                rowBuilt.put(slots,vendingSlot);
                autowireRepository.getSlotRepository().getSlotMap().get(spaceType).put(slotIndex,vendingSlot);
                slotIndex++;
            }
            VendingRow vendingRow = VendingRow.builder()
                    .vendingRowId(vendingRowId)
                    .slots(rowBuilt)
                    .build();
            machineBuilt.put(vendingRowId,vendingRow);
            autowireRepository.getRowRepository().getVendingRowMap().put(vendingRowId,vendingRow);
            vendingRowId++;

        }
        VendingMachineUnit vendingMachineUnit = VendingMachineUnit.builder()
                .vendingMachineId(vendingMachineId)
                .rows(machineBuilt)
                .build();
        autowireRepository.getVendingMachineRepository().getVendingMachineMap().put(vendingMachineIndex,vendingMachineUnit);

//        var rowrepo = autowireRepository.getRowRepository().getVendingRowMap();
//
//        for (Map.Entry<Character, VendingRow> rowEntry : rowrepo.entrySet() ){
//            System.out.println("For Row: "+rowEntry.getKey());
//            for (Map.Entry<Integer,VendingSlot>slotEntry : rowEntry.getValue().getSlots().entrySet()){
//                System.out.println("For Slot: "+slotEntry.getKey() + " With reference: "+slotEntry.getValue().getSlotId());
//                for (Map.Entry<Integer,ItemSpace> spaceEntry: slotEntry.getValue().getItemSpaces().entrySet()){
//                    System.out.println("Itemspace: "+spaceEntry.getValue().getItemSpaceRefId() + ", "+ slotEntry.getValue().getSlotType());
//                }
//            }
//        }


        return "Vending Machine "+vendingMachineId  +" Has Been Created With "+ numberOfRows+" Rows And "+ numberOfSlots +" Slots; Each With Capacity "+numberOfItemSpaces;
    }

    @Override
    public String addItems(ItemType itemType, String itemName, Integer quantity) {

        List<ItemSpace> availableSpaces = autowireUtil.getFindingUtil().listEmptySpacesGivenTypeQuantity(itemType,quantity,autowireRepository.getItemSpaceRepository());

        if(availableSpaces!=null){
            availableSpaces.stream().forEach(itemSpace -> {
                Item item = Item.builder()
                        .itemName(itemName)
                        .itemType(itemType)
                        .build();
                itemSpace.setItem(item);
                itemSpace.setItemOccupancy(ItemOccupancy.filled);
            });
        }

        List<ItemSpace> availableSpaces2 = autowireUtil.getFindingUtil().listEmptySlotsGivenType(itemType,autowireRepository.getSlotRepository());

        return "Item "+itemName+" Of Type "+itemType+"  Added To "+availableSpaces.size()+" Spaces. Leftover Spaces: "+availableSpaces2.size();
    }
}
