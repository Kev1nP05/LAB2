import java.util.Scanner;

public class Menu {
    
      private final Scanner input = new Scanner(System.in);
     
       public void iniciar(){
    int opcion;
    do {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE INVENTARIO ===");
        System.out.println("1. Registrar Producto Electronico");
        System.out.println("2. Registrar Producto Alimenticio");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Mostrar estadisticas del sistema");
        System.out.println("5. Vender producto");
        System.out.println("6. Mostrar información detallada de productos");
        System.out.println("7. Salir del programa");
        System.out.println("=========================================");
        
        opcion = leerEntero("Seleccione una opcion: ");
        
        switch (opcion) {
            case 1 -> registrarProductoElectronico();
            case 2 -> registrarProductoAlimenticio();
            case 3 -> mostrarTodosProductos();
            case 4 -> mostrarEstadisticas();
            case 5 -> venderProducto();
            case 6 -> mostrarInfoDetallada();
            case 7 -> System.out.println("¡Gracias por usar el sistema de inventario!");
            default -> System.out.println("Error: opcion invalida -> (1-7).");
        }
    } while (opcion != 7);
}
    /**
     * Registrar un nuevo producto electrónico 
     */
    private void registrarProductoElectronico() {
    System.out.println("\n=== REGISTRO DE PRODUCTO ELECTRÓNICO ===");
     
    try {
       
        ProductoElectronico producto = new ProductoElectronico("","",0.0, 0, 0);

        producto.setCodigo("Ingrese el codigo del producto: ");
        producto.setNombre("Ingrese el nombre del producto: ");
        producto.setPrecio("Ingrese el precio del producto: ");
        producto.setStock("Ingrese el stock inicial: "); 
        producto.setMesesGarantia("Ingrese los meses de garantía: ");
        
        System.out.println("\nProducto electronico registrado correctamente!");
        producto.getDetalleBase();
        
    } catch (InventarioException e) {
        System.out.println("Error de negocio: " + e.getMessage());
    } catch (IllegalArgumentException e) {
        System.out.println("Error de validacion: " + e.getMessage());
    }
}
    
    /**
     * Registra un nuevo producto alimenticio en el sistema
     */
   private void registrarProductoAlimenticio() {
    System.out.println("\n=== REGISTRO DE PRODUCTO ALIMENTICIO ===");
    
    try {
        
        ProductoAlimenticio productoA = new ProductoAlimenticio("", "", 0.0, 0, "");
        
        productoA.setCodigo("Ingrese el codigo del producto: ");
        productoA.setNombre("Ingrese el nombre del producto: ");
        productoA.setPrecio("Ingrese el precio del producto: ");
        productoA.setStock("Ingrese el stock inicial: "); 
        productoA.setFechaCaducidad("Ingrese la fecha de caducidad (YYYY-MM-DD): ");
    
        System.out.println("\nProducto alimenticio registrado correctamente!");
        productoA.getDetalleBase();
        
    } catch (InventarioException e) {
        System.out.println("Error de negocio: " + e.getMessage());
    } catch (IllegalArgumentException e) {
        System.out.println("Error de validacion: " + e.getMessage());
    }
}
    
    /**
     * Muestra todos los productos registrados en el sistema
     */
    private  void mostrarTodosProductos() {
        System.out.println("\n=== LISTA DE PRODUCTOS REGISTRADOS ===");
        
        // En una implementación real, aquí iría la lógica para obtener productos de una base de datos
        // Por ahora mostramos solo el contador
        int totalProductos = Producto.getContadorProductos();
        
        if (totalProductos == 0) {
            System.out.println("No hay productos registrados en el sistema.");
        } else {
            System.out.println("Total de productos creados: " + totalProductos);
            
        }
    }
    
    /**
     * Muestra estadísticas del sistema
     */
    private  void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS DEL SISTEMA ===");
        System.out.println("Total de productos registrados: " + Producto.getContadorProductos());
        System.out.println("Sistema funcionando correctamente ");
    }


    /**
 * Método para vender productos con control de stock
 */
private void venderProducto() {
    System.out.println("\n=== VENTA DE PRODUCTOS ===");
    
    try {
        // En un sistema real, aquí buscarías productos existentes
        // Por ahora simulamos con un producto temporal
        
        System.out.println("Para realizar una venta, primero necesitamos información del producto:");
        
        // Crear producto temporal para la demostración
        ProductoElectronico productoTemp = new ProductoElectronico("", "", 0.0, 0, 0);
        productoTemp.setCodigo("Ingrese el código del producto a vender: ");
        productoTemp.setNombre("Ingrese el nombre del producto: ");
        productoTemp.setPrecio("Ingrese el precio del producto: ");
        productoTemp.setStock("Ingrese el stock disponible: ");
        productoTemp.setMesesGarantia("Ingrese meses de garantía: ");
        
        System.out.println("\nProducto configurado:");
        productoTemp.getDetalleBase();
        
        // Solicitar cantidad a vender
        int cantidad = leerEntero("\nIngrese la cantidad a vender: ");
        
        // Intentar realizar la venta
        productoTemp.vender(cantidad);
        
    } catch (StockInsuficienteException e) {
        System.out.println("Error de stock: " + e.getMessage());
    } catch (IllegalArgumentException e) {
        System.out.println("Error en los datos: " + e.getMessage());
    } catch (InventarioException e) {
        System.out.println("Error del sistema: " + e.getMessage());
    }
}

private void mostrarInfoDetallada() {
    System.out.println("\n=== INFORMACIÓN DETALLADA DE PRODUCTOS ===");
    
    try {
        // Crear productos de ejemplo para demostrar la nueva funcionalidad
        ProductoElectronico electronico = new ProductoElectronico(
            "ELEC-001", "Laptop Gaming", 1200.00, 15, 24
        );
        
        ProductoAlimenticio alimenticio = new ProductoAlimenticio(
            "ALIM-001", "Yogurt Natural", 3.50, 50, "2024-12-31"
        );
        
        System.out.println("\n--- Producto Electrónico ---");
        System.out.println(electronico.getInfoDetallada());
        
        System.out.println("\n--- Producto Alimenticio ---");
        System.out.println(alimenticio.getInfoDetallada());
        
        // Demostración de ventas con diferentes casos
        System.out.println("\n--- DEMOSTRACIÓN DE VENTAS ---");
        
        // Venta exitosa
        System.out.println("\n1. Venta exitosa (5 unidades de laptop):");
        electronico.vender(5);
        
        // Intentar vender cantidad negativa
        System.out.println("\n2. Intentar vender cantidad negativa:");
        try {
            electronico.vender(-2);
        } catch (IllegalArgumentException e) {
            System.out.println("Correctamente capturado: " + e.getMessage());
        }
        
        // Intentar vender más del stock disponible
        System.out.println("\n3. Intentar vender más del stock disponible:");
        try {
            electronico.vender(20);
        } catch (StockInsuficienteException e) {
            System.out.println("Correctamente capturado: " + e.getMessage());
        }
        
    } catch (InventarioException e) {
        System.out.println("Error: " + e.getMessage());
    }
}


    
    /**
     * Lee un número entero desde la consola con validación
     * @param mensaje Mensaje a mostrar al usuario
     * @return Número entero válido
     */
    private  int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo puede ingresar numeros enteros.");
            }
        }
    }

}
    


