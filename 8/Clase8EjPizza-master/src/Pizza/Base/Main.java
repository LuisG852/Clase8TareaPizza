package Pizza.Base;
import java.util.*;

import Pizza.Base.Especialidades.Especialidades;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mostrar el menú de pizzas disponibles
        System.out.println("Menú de Pizzas Disponibles:");
        System.out.println("1. Pepperoni");
        System.out.println("2. Hawaiiana");
        System.out.println("3. Vegetariana");
        System.out.println("4. Suprema");
        System.out.println("5. Blanca");
        System.out.print("Seleccione una pizza (1-5): ");
        int pizzaChoice = scanner.nextInt();

        String pizzaName = "";
        double pizzaPrice = 0;

        switch (pizzaChoice) {
            case 1:
                pizzaName = Especialidades.PEPPERONI_NAME;
                break;
            case 2:
                pizzaName = Especialidades.HAWAIIAN_NAME;
                break;
            case 3:
                pizzaName = Especialidades.VEGETARIAN_NAME;
                break;
            case 4:
                pizzaName = Especialidades.SUPREME_NAME;
                break;
            case 5:
                pizzaName = Especialidades.WHITE_NAME;
                break;
            default:
                System.out.println("Selección no válida. Saliendo del programa.");
                return;
        }

        // Mostrar el menú de tamaños de pizzas disponibles
        System.out.println("Tamaños de Pizzas Disponibles:");
        System.out.println("1. Pequeña");
        System.out.println("2. Mediana");
        System.out.println("3. Grande");
        System.out.print("Seleccione el tamaño de la pizza (1-3): ");
        int sizeChoice = scanner.nextInt();

        String pizzaSize = "";

        switch (sizeChoice) {
            case 1:
                pizzaSize = Pizza.SMALL_SIZE;
                break;
            case 2:
                pizzaSize = Pizza.MEDIUM_SIZE;
                break;
            case 3:
                pizzaSize = Pizza.LARGE_SIZE;
                break;
            default:
                System.out.println("Selección de tamaño no válida. Saliendo del programa.");
                return;
        }

        // Crear la pizza con el nombre, tamaño y precio seleccionados
        Especialidades selectedPizza = new Especialidades(pizzaName, pizzaSize);

        // Permitir al usuario agregar toppings extras
        boolean agregarToppings = true;
        while (agregarToppings) {
            System.out.println("Ingredientes extras disponibles:");
            System.out.println("1. Pepperoni - Precio adicional: Q" + Topping.PEPPERONI_PRICE);
            System.out.println("2. Piña - Precio adicional: Q" + Topping.PINEAPPLE_PRICE);
            System.out.println("3. Chile Dulce - Precio adicional: Q" + Topping.SWEET_PEPPER_PRICE);
            System.out.println("4. Cebolla - Precio adicional: Q" + Topping.ONION_PRICE);
            System.out.println("5. Queso - Precio adicional: Q" + Topping.CHEESE_PRICE);
            System.out.println("6. Champiñones - Precio adicional: Q" + Topping.MUSHROOMS_PRICE);
            System.out.println("7. Finalizar y cocinar la pizza");

            System.out.print("Seleccione un ingrediente extra (1-7): ");
            int toppingChoice = scanner.nextInt();

            if (toppingChoice < 1 || toppingChoice > 7) {
                System.out.println("Selección no válida. Saliendo de la selección de ingredientes.");
                break;
            }

            switch (toppingChoice) {
                case 1:
                    selectedPizza.addTopping(new Topping(Topping.PEPPERONI_NAME, Topping.PEPPERONI_PRICE));
                    break;
                case 2:
                    selectedPizza.addTopping(new Topping(Topping.PINEAPPLE_NAME, Topping.PINEAPPLE_PRICE));
                    break;
                case 3:
                    selectedPizza.addTopping(new Topping(Topping.SWEET_PEPPER_NAME, Topping.SWEET_PEPPER_PRICE));
                    break;
                case 4:
                    selectedPizza.addTopping(new Topping(Topping.ONION_NAME, Topping.ONION_PRICE));
                    break;
                case 5:
                    selectedPizza.addTopping(new Topping(Topping.CHEESE_NAME, Topping.CHEESE_PRICE));
                    break;
                case 6:
                    selectedPizza.addTopping(new Topping(Topping.MUSHROOMS_NAME, Topping.MUSHROOMS_PRICE));
                    break;
                case 7:
                    agregarToppings = false;
                    break;
            }
        }



        // Calcular el precio total de la pizza
        double totalPizzaPrice = selectedPizza.getPrice();
        for (Topping topping : selectedPizza.getToppings()) {
            totalPizzaPrice += topping.getPrice();
        }

        // Imprimir el total de la pizza

        System.out.println("El precio total de la pizza es: Q" + totalPizzaPrice);

        selectedPizza.prepare();
        scanner.close();
    }
}