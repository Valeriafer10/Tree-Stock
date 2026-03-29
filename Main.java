import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolInventario arbol = new ArbolInventario();
        int opcion;

        do {
            System.out.println("\n=== TREE-STOCK ===");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    arbol.insertar(id, nombre);
                    System.out.println("Producto registrado correctamente.");
                    break;

                case 2:
                    System.out.println("\nInventario (ordenado):");
                    arbol.mostrarInventario();
                    break;

                case 3:
                    System.out.print("Ingrese ID a buscar: ");
                    int buscarId = scanner.nextInt();
                    arbol.buscar(buscarId);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}