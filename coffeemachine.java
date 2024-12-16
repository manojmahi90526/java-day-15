import java.util.Scanner;

class CoffeeMachine {
    int water;
     int milk;
     int coffeeBeans;
     int cups;
     int money;

    public CoffeeMachine() {
        this.water = 0;
        this.milk = 0;
        this.coffeeBeans = 0;
        this.cups = 0;
        this.money = 0;
    }

    public void displayMenu() {
        System.out.println("*****************************");
        System.out.println("Coffee Machine Menu:");
        System.out.println("1. Fill");
        System.out.println("2. Buy");
        System.out.println("3. Remaining");
        System.out.println("4. Take");
        System.out.println("5. Exit");
        System.out.println("*******************************");
    }

    public void buyCoffee() {
        System.out.println("What would you like to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
                    water -= 250;
                    coffeeBeans -= 16;
                    cups -= 1;
                    money += 4;
                    System.out.println("Here is your espresso. Enjoy!");
                } else {
                    System.out.println("Sorry, not enough resources to make espresso.");
                }
                break;
            case 2:
                if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 1) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    cups -= 1;
                    money += 7;
                    System.out.println("Here is your latte. Enjoy!");
                } else {
                    System.out.println("Sorry, not enough resources to make latte.");
                }
                break;
            case 3:
                if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 1) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    cups -= 1;
                    money += 6;
                    System.out.println("Here is your cappuccino. Enjoy!");
                } else {
                    System.out.println("Sorry, not enough resources to make cappuccino.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
        }
    }

    public void fillResources() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much water do you want to add?");
        water += scanner.nextInt();
        System.out.println("How much milk do you want to add?");
        milk += scanner.nextInt();
        System.out.println("How much coffee beans do you want to add?");
        coffeeBeans += scanner.nextInt();
        System.out.println("How many cups do you want to add?");
        cups += scanner.nextInt();
    }

    public void takeMoney() {
        System.out.println("I take from you $" + money);
        money = 0;
    }

    public void displayRemainingResources() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}
class Main{
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            coffeeMachine.displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    coffeeMachine.fillResources();
                    break;
                case 2:
                    coffeeMachine.buyCoffee();
                    break;
                case 3:
                    coffeeMachine.displayRemainingResources();
                    break;
                case 4:
                    coffeeMachine.takeMoney();
                    break;
                case 5:
                    System.out.println("Exiting Have A Nice Day...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}