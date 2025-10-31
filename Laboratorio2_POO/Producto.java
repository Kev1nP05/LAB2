import java.util.Scanner;

public class Producto {
    
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private static int contadorProductos = 0;
    final Scanner input = new Scanner(System.in);
    
    public Producto(String codigo, String nombre, double precio,int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        contadorProductos++;
    }




    protected boolean soloLetras(String texto){
        return texto != null && !texto.isEmpty() && texto.matches("[a-zA-Z ]+");
    }
    
   
    public static int getContadorProductos() {
        return contadorProductos;
    }
    
    /**
     * @return código del producto
     */
    public String getCodigo() {
        return codigo;
    }
    
    
    public void setCodigo(String mensaje) {
        while(true){

            try{
            System.out.println(mensaje);
            String codigoT = input.nextLine();

            if(!soloLetras(codigoT)){
                throw new IllegalArgumentException("Error: solo ingrese letras");
            }
             
            this.codigo = codigoT;
            break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
    }
}
    
    /**
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del producto
     * @param nombre Nombre del producto
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    public void setNombre(String mensaje) {
        while(true){

            try{
            System.out.println(mensaje);
            String nombreT = input.nextLine();

            if(!soloLetras(nombreT)){
                throw new IllegalArgumentException("Error: solo ingrese letras");
            }
             
            this.nombre = nombreT;
            break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
    }
    }
    
    /**
     * @return precio del producto
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Establece el precio del producto
     * @param precio Precio del producto
     * @throws IllegalArgumentException si el precio es negativo
     */
    public void setPrecio(String mensaje)throws InventarioException{

         while(true){

            try{
            System.out.println(mensaje);
            double precioT = Double.parseDouble(input.nextLine());

            if(precioT < 0.0){
                throw new InventarioException("Error: no puede ingresar un precio negativo");
            }
            this.precio = precioT;
            break;

           }catch(NumberFormatException | InventarioException e){
                System.out.println(e.getMessage());
            
            }
    }
    }


    

      public int getStock() {
        return stock;
    }




    public void setStock(String mensaje) {
      while(true){

            try{
            System.out.println(mensaje);
            int stockT = Integer.parseInt(input.nextLine());

            if(stockT < 0){
                throw new IllegalArgumentException("Error: no puede ingresar un stock negativo");
            }
            this.stock = stockT;
            break;

           }catch(NumberFormatException e){
                System.out.println(e.getMessage());
            
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
    }
    }




     public void vender(int cantidad) throws StockInsuficienteException, IllegalArgumentException {
    // Validar cantidad positiva
    if (cantidad <= 0) {
        throw new IllegalArgumentException("La cantidad a vender debe ser positiva.");
    }
    
    // Validar stock suficiente
    if (cantidad > this.stock) {
        throw new StockInsuficienteException(
            "Stock insuficiente para " + this.nombre + 
            ". Disponibles: " + this.stock + 
            ", Solicitados: " + cantidad
        );
    }
    
    // Realizar la venta
    this.stock -= cantidad;
    System.out.println("Venta exitosa: " + cantidad + " unidades de " + this.nombre);
    System.out.println("Nuevo stock: " + this.stock);
}


public void vender() {
    try {
        vender(1); // Vender 1 unidad por defecto
    } catch (StockInsuficienteException | IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}


public String getInfoDetallada() {
    StringBuilder info = new StringBuilder();
    info.append("***********************\n");
    info.append("--- DETALLE PRODUCTO ---\n");
    info.append("ID: ").append(this.codigo).append("\n");
    info.append("Nombre: ").append(this.nombre).append("\n");
    
    // Lógica de categoría de precio refactorizada
    String categoriaPrecio;
    if(this.precio > 100) {
        categoriaPrecio = "ALTO";
    } else if (this.precio > 50 && this.precio <= 100) {
        categoriaPrecio = "MEDIO";
    } else {
        categoriaPrecio = "BAJO";
    }
    
    info.append("PRECIO (").append(categoriaPrecio).append("): ").append(this.precio).append("\n");
    info.append("Stock disponible: ").append(this.stock).append("\n");
    info.append("***********************");
    
    return info.toString();
}


protected void getDetalleBase() {
    System.out.println("Codigo: " + getCodigo());
    System.out.println("Nombre: " + getNombre());
    System.out.println("Precio: " + getPrecio());       
    System.out.println("Stock: " + getStock());   
}
}