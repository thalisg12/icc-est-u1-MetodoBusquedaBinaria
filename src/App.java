import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de personas: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Persona[] personas = new Persona[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Persona " + (i + 1));

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            personas[i] = new Persona(nombre, edad);
        }

        for (int i = 0; i < personas.length - 1; i++) {
            for (int j = 0; j < personas.length - i - 1; j++) {
                if (personas[j].edad > personas[j + 1].edad) {

                    Persona aux = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = aux;
                }
            }
        }

        System.out.println("\nPersonas ordenadas por edad:");
        for (Persona p : personas) {
            System.out.println(p);
        }

        System.out.print("\nIngrese la edad a buscar: ");
        int edad2 = scanner.nextInt();

        int bajo = 0;
        int alto = personas.length - 1;
        boolean encontrado = false;

        while (bajo <= alto) {
            int centro = (bajo + alto) / 2;

            for (int i = bajo; i <= alto; i++) {
                if (i == alto) {
                    System.out.print(personas[i].edad);
                } else {
                    System.out.print(personas[i].edad + " | ");
                }
            }
            System.out.println();
            System.out.println(
                    "bajo=" + bajo + " alto=" + alto + " centro=" + centro + " valorCentro=" + personas[centro].edad);

            if (personas[centro].edad == edad2) {
                System.out.println("¡Persona encontrada!");
                System.out.println("La persona con la edad " + edad2 + " es " + personas[centro].nombre);
                encontrado = true;
                break;
            } else if (personas[centro].edad < edad2) {
                System.out.println(" --> DERECHA");
                bajo = centro + 1;
            } else {
                System.out.println(" --> IZQUIERDA");
                alto = centro - 1;
            }
        }

        if (!encontrado) {
            System.out.println("\nNo se encontró una persona con edad " + edad2);
        }
    }
}
