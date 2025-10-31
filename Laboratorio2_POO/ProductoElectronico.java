
public class ProductoElectronico extends Producto {
    
    private int mesesGarantia;
    
    /**
     * Constructor parametrizado para productos electrónicos
     * @param codigo Identificador único del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param mesesGarantia Meses de garantía del producto electrónico
     * @throws IllegalArgumentException si los parámetros no cumplen las validaciones
     */
    public ProductoElectronico(String codigo, String nombre, double precio, int stock, int mesesGarantia){
    super(codigo, nombre, precio, stock); 
    this.mesesGarantia = mesesGarantia;
}
    
    /**
     * @return meses de garantía del producto
     */
    public int getMesesGarantia() {
        return mesesGarantia;
    }
    
    /**
     * Establece los meses de garantía del producto electrónico
     * @param mesesGarantia Meses de garantía
     * @throws IllegalArgumentException si los meses de garantía son negativos
     */
    public void setMesesGarantia(String mensaje) throws InventarioException{
        while(true){
    
        try{
            System.out.println(mensaje);
            int mesesT = Integer.parseInt(input.nextLine());

            if(mesesT < 0){
                throw  new InventarioException("Error: no puede ingresar meses negativos");
            }
           
        this.mesesGarantia = mesesT;
        break;
   }catch(NumberFormatException | InventarioException e){
                System.out.println(e.getMessage());
            
            }
        }
    }
    
   @Override
    public void getDetalleBase () {
        System.out.println("===Datos del producto electronico===");
        super.getDetalleBase();
        System.out.println("Meses de Garantia: " + getMesesGarantia());

    }
}