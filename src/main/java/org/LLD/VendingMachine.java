package org.LLD;

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
                default : {
                   System.out.println("!----- Invalid Command -----!");
                }

            }


        }

    }
}