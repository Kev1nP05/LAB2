
public class ProductoAlimenticio extends Producto {
    
    private String fechaCaducidad;
    
    /**
     * Constructor parametrizado para productos alimenticios
     * @param codigo Identificador único del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param fechaCaducidad Fecha de caducidad en formato "YYYY-MM-DD"
     * @throws InventarioException si la fecha de caducidad ya pasó
     */
    public ProductoAlimenticio(String codigo, String nombre, double precio, int stock, String fechaCaducidad){
    super(codigo, nombre, precio, stock); 
    this.fechaCaducidad = fechaCaducidad;
}
    
    /**
     * @return fecha de caducidad del producto
     */
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
    
    /**
     * Establece la fecha de caducidad del producto alimenticio
     * @param fechaCaducidad Fecha en formato "YYYY-MM-DD"
     * @throws InventarioException si la fecha de caducidad ya pasó
     */
    public void setFechaCaducidad(String mensaje) throws InventarioException {
    while(true){
        try{
            System.out.println(mensaje);
            String fechaT = input.nextLine();

           
            if (!fechaT.matches("\\d{4}-\\d{2}-\\d{2}")) {
                throw new InventarioException("Error: Formato de fecha inválido. Use YYYY-MM-DD");
            }

          
            if (fechaT.compareTo(java.time.LocalDate.now().toString()) < 0) { 
                throw new InventarioException("El producto está caducado. Fecha: " + fechaT);
            }

            this.fechaCaducidad = fechaT;
            break;

        } catch(IllegalArgumentException | InventarioException e) {
            System.out.println(e.getMessage());
        }
    }
}
    
    /**
     * Método que muestra los detalles completos del producto alimenticio
     * @return String con todos los detalles del producto
     */
   @Override
public void getDetalleBase() {
    System.out.println("===Datos del producto alimenticio===");
    super.getDetalleBase();
    System.out.println("Fecha de caducidad: " + getFechaCaducidad());
    System.out.println("Información detallada:");
    System.out.println(getInfoDetallada());
}
}