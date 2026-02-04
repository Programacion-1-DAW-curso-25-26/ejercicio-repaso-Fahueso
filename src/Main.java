import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion;

        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = leerEntero(sc);

            switch (opcion) {

                case 1:
                    anadirProducto(sc, inventario);
                    break;

                case 2:
                    buscarPorNombre(sc, inventario);
                    break;

                case 3:
                    buscarPorCategoria(sc, inventario);
                    break;

                case 4:
                    buscarPorPrecio(sc, inventario);
                    break;

                case 5:
                    incrementarStock(sc, inventario);
                    break;

                case 6:
                    decrementarStock(sc, inventario);
                    break;

                case 7:
                    inventario.listarTodos();
                    break;

                case 8:
                    inventario.listarSinStock();
                    break;

                case 9:
                    mostrarInventarioOrdenadoPorPrecioAsc(inventario);
                    break;
                case 10:
                    eliminarInventarioPorCodigo(sc,inventario);
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println();

        } while (opcion != 0);

        sc.close();
    }




    // ---------------------------------------
    // MENÚ
    // ---------------------------------------
    private static void mostrarMenu() {
        System.out.println("--------- INVENTARIO TIENDA ---------");
        System.out.println("1. Añadir producto");
        System.out.println("2. Buscar por nombre");
        System.out.println("3. Buscar por categoría");
        System.out.println("4. Buscar por rango de precios");
        System.out.println("5. Incrementar stock");
        System.out.println("6. Decrementar stock");
        System.out.println("7. Listar inventario completo");
        System.out.println("8. Listar productos sin stock");
        System.out.println("9. Mostrar inventario ordenado por precio (asc)");
        System.out.println("10. Eliminar por codigo");

        System.out.println("0. Salir");
        System.out.println("--------------------------------------");
    }

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Introduce un número válido: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // ---------------------------------------
    // OPCIÓN 1: Añadir producto
    // ---------------------------------------
    private static void anadirProducto(Scanner sc, Inventario inv) {
        sc.nextLine();
        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Categoría: ");
        String categoria = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();

        System.out.print("Stock: ");
        int stock = sc.nextInt();
        sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        ProductoInformatico p = new ProductoInformatico(codigo, nombre, categoria, precio, stock, marca);

        if (inv.agregarProducto(p))
            System.out.println("Producto añadido correctamente.");
        else
            System.out.println("ERROR: código duplicado o inválido.");
    }

    // ---------------------------------------
    // OPCIÓN 2: Buscar por nombre
    // ---------------------------------------
    private static void buscarPorNombre(Scanner sc, Inventario inv) {
        sc.nextLine();
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();

        List<ProductoInformatico> lista = inv.buscarPorNombre(nombre);
        for (ProductoInformatico p : lista) {
            System.out.println(p);
        }
    }

    // ---------------------------------------
    // OPCIÓN 3: Buscar por categoría
    // ---------------------------------------
    private static void buscarPorCategoria(Scanner sc, Inventario inv) {
        sc.nextLine();
        System.out.print("Categoría exacta: ");
        String cat = sc.nextLine();

        List<ProductoInformatico> lista = inv.buscarPorCategoria(cat);
        for (ProductoInformatico p : lista) {
            System.out.println(p);
        }
    }

    // ---------------------------------------
    // OPCIÓN 4: Buscar por precio
    // ---------------------------------------
    private static void buscarPorPrecio(Scanner sc, Inventario inv) {
        System.out.print("Precio mínimo: ");
        double min = sc.nextDouble();

        System.out.print("Precio máximo: ");
        double max = sc.nextDouble();

        List<ProductoInformatico> lista = inv.buscarPorPrecio(min, max);
        for (ProductoInformatico p : lista) {
            System.out.println(p);
        }
    }

    // ---------------------------------------
    // OPCIÓN 5: Incrementar stock
    // ---------------------------------------
    private static void incrementarStock(Scanner sc, Inventario inv) {
        sc.nextLine();
        System.out.print("Código: ");
        String cod = sc.nextLine();

        System.out.print("Cantidad a añadir: ");
        int c = sc.nextInt();

        if (inv.incrementarStock(cod, c))
            System.out.println("Stock actualizado.");
        else
            System.out.println("ERROR: no se pudo actualizar.");
    }

    // ---------------------------------------
    // OPCIÓN 6: Decrementar stock
    // ---------------------------------------
    private static void decrementarStock(Scanner sc, Inventario inv) {
        sc.nextLine();
        System.out.print("Código: ");
        String cod = sc.nextLine();

        System.out.print("Cantidad a restar: ");
        int c = sc.nextInt();

        if (inv.decrementarStock(cod, c))
            System.out.println("Stock actualizado.");
        else
            System.out.println("ERROR: stock insuficiente o código no válido.");
    }

    // ---------------------------------------
    // OPCIÓN 9: Mostrar ordenado por precio asc
    // ---------------------------------------
    private static void mostrarInventarioOrdenadoPorPrecioAsc(Inventario inv) {
        List<ProductoInformatico> lista = inv.ordenarPorPrecioAsc();

        if (lista == null || lista.isEmpty()) {
            System.out.println("Inventario vacío.");
        } else {
            for (ProductoInformatico p : lista) {
                System.out.println(p);
            }
        }
    }

    private static void eliminarInventarioPorCodigo(Scanner sc,Inventario inv) {
        sc.nextLine();
        System.out.print("Código: ");
        String cod = sc.nextLine();

        if(inv.eliminarPorCodigo(cod)){
            System.out.println("Producto eliminado.");
        }else{
            System.out.println("Código no válido");
        }

    }
}