package org.LLD;

import org.LLD.Constants.Enums.DisplayFilter;
import org.LLD.Constants.Enums.EmptySpaceFilter;
import org.LLD.Constants.Enums.ItemType;
import org.LLD.Services.VendingService;
import org.LLD.Services.VendingServiceIMPL;
import org.LLD.Constants.Commands;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {

        VendingService vendingService = new VendingServiceIMPL();

        Scanner scanner = new Scanner(System.in);

        boolean program = true;

        while (program){

            String[] input = scanner.nextLine().trim().split(" ");

            switch (input[0]){

                case Commands.CREATE_VENDING_MACHINE : {
                    System.out.println(vendingService.createVendingMachine(input[1],Integer.valueOf(input[2]),Integer.valueOf(input[3]),Integer.valueOf(input[4])));

                }
                break;
                case Commands.ADD_ITEMS : {
                    System.out.println(vendingService.addItems(ItemType.valueOf(input[1]), input[2], Integer.valueOf(input[3])));
                }
                break;
                case Commands.DISPLAY : {

                    if (input[1].equals(String.valueOf(DisplayFilter.all))){

                        vendingService.displayAllItemsType(ItemType.valueOf(input[2]));

                    } else if (input[1].equals(String.valueOf(DisplayFilter.row))) {

                        vendingService.displayRow(Character.valueOf(input[2].charAt(0)));

                    } else if (input[1].equals(String.valueOf(DisplayFilter.slot))) {

                        vendingService.displaySlot(input[2]);

                    } else if (input[1].equals(String.valueOf(DisplayFilter.empty_spaces))) {

                        if (input[2].equals(String.valueOf(EmptySpaceFilter.all))){

                            vendingService.showAllEmptySpaces();

                        } else if (input[2].equals(String.valueOf(EmptySpaceFilter.row))) {

                            vendingService.showRowEmptySpaces(input[3].charAt(0));

                        } else if (input[2].equals(String.valueOf(EmptySpaceFilter.slot))) {

                        }
                    }
                }
                break;
                default : {
                   System.out.println("!----- Invalid Command -----!");
                }

            }


        }

    }
}