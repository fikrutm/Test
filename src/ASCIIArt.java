/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author cocofan
 */
public class ASCIIArt {

    static Scanner input = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean cont = true;
        int size=10;
        String symbols="**";
        int choice;

        System.out.println("*******ASCII Art App**********");
        do {

            do {
                System.out.println("\n\n");
                System.out.println("************* MENU ****************");
                System.out.println(" 1 - change size.");
                System.out.println(" 2 - change symbol.");
                System.out.println(" 3 - triangle upward.");
                System.out.println(" 4 - triangle downward.");
                System.out.println(" 5 - diamond.");
                System.out.println(" 6 - rectangle.");
                System.out.println(" 7 - oval.");
                System.out.println(" 8 - quit program.");
                choice = input.nextInt();
            } while((choice < 1)||(choice > 8));

            switch(choice) {
                case 1: size = getSize();
                    break;
                case 2: symbols = getSymbols();
                    break;
                case 3: printTriangleUp(size, symbols);
                    break;
                case 4: printTriangleDown(size, symbols);
                    break;
                case 5: printDiamond(size, symbols);
                    break;
                case 6: printRectangle(size, symbols);
                    break;
                case 7: printOval(size, symbols);
                    break;
                case 8:cont = false;
            }

        } while(cont);

    }

    public static int getSize()
    {
        int size;
        do {
            System.out.println("\n\n");
            System.out.println("what size (number of rows from 1 to 25):  ");
            size = input.nextInt();
        }while((size < 1)||(size >25));
        return size;
    }

    public static String getSymbols() {
        String symbols;
        do {
            System.out.println("what symbols: (from 1 to 6 symbols)" );
            symbols = input.next();
        }while((symbols.length() < 1)||(symbols.length() > 6));
        return symbols;
    }

    public static void printSymbols(int blanks, int symbols, String symbolSet) {
        for(int i=0; i<blanks; i++) {
            System.out.print(" ");
        }

        for(int i=0; i<symbols; i++) {
            System.out.print(symbolSet);
        }
    }

    public static void printTriangleUp(int size, String symbolSet) {
        for(int i=1; i<size+1; i++)
        {
            printSymbols(size-i,i,symbolSet);
            System.out.println("");
        }
    }

    public static void printTriangleDown(int size, String symbolSet) {
        for(int i=1; i<size+1; i++)
        {
            printSymbols(i,size-i,symbolSet);
            System.out.println("");
        }
    }
    public static void printRectangle(int size, String symbolSet) {
        for(int i=1; i<size+1; i++)
        {
            printSymbols(0,size,symbolSet);
            System.out.println("");
        }
    }
    public static void printDiamond(int size, String symbolSet) {
        printTriangleUp(size/2, symbolSet);
        printTriangleDown(size/2, symbolSet);
    }
    public static void printOval(int size, String symbolSet) {
        int radius = size/2;
        for(int x=radius; x>0; x--)
        {
            int r = (int) Math.ceil(Math.sqrt(radius*radius - x*x));
            printSymbols(radius-r,r,symbolSet);
            System.out.println("");
        }
        for(int x=0; x<radius; x++)
        {
            int r = (int) Math.sqrt(radius*radius - x*x);
            printSymbols(radius-r,r,symbolSet);
            System.out.println("");
        }
    }
}
