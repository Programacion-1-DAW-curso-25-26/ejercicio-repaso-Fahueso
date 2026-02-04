import java.util.*;

public class Inventario {

    private ArrayList<ProductoInformatico> productos = new ArrayList<>();

    public Inventario() {
    }


    public ArrayList<ProductoInformatico> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductoInformatico> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "productos=" + productos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inventario that = (Inventario) o;
        return Objects.equals(productos, that.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productos);
    }

    public boolean agregarProducto(ProductoInformatico p) {
        if (!productos.contains(p)) {
            productos.add(p);
            return true;
        }
        return false;
    }


    //falta por hacer
    public List<ProductoInformatico> buscarPorPrecio(double min, double max) {
        ArrayList<ProductoInformatico> productosCoindentes = new ArrayList<>();
        for (ProductoInformatico producto: productos){
            if ((producto.getPrecio()<=max) &&(producto.getPrecio()>=min)){
                productosCoindentes.add(producto);
            }
        }
        return productosCoindentes;
    }

    public boolean incrementarStock(String cod, int c) {
        boolean encontrado = false;
        for (ProductoInformatico pro : productos) {
            if (pro.getCodigo().equals(cod)){
                pro.setStock(pro.getStock()+c);
                encontrado =true;
            }
        }
        return encontrado;
    }

    public boolean decrementarStock(String cod, int c) {
        boolean encontrado = false;
        for (ProductoInformatico pro : productos) {
            if (pro.getCodigo().equals(cod)){
                if (pro.getStock()-c >= 0) {
                    pro.setStock(pro.getStock() - c);
                    encontrado = true;
                }
                else {
                    System.out.println("Stock insuficiente: abortando");
                }
            }
        }
        return encontrado;

    }

    public List<ProductoInformatico> ordenarPorPrecioAsc() {
        ArrayList<ProductoInformatico> clonOrdenado = new ArrayList<>(productos);
        Collections.sort(clonOrdenado, Comparator.comparingDouble(ProductoInformatico::getPrecio));
        return clonOrdenado;




    }



    public void listarTodos() {
        System.out.println("Listado de productos");
        System.out.println("--------------------");
        for (ProductoInformatico producto:productos){
            System.out.println(producto);
        }
        System.out.println("--------------------");

    }

    public void listarSinStock() {
        System.out.println("Listado de productos sin stock");
        System.out.println("------------------------------");
        for (ProductoInformatico producto:productos){
            if (producto.getStock()==0)
                System.out.println(producto);
        }
        System.out.println("------------------------------");
    }

    public List<ProductoInformatico> buscarPorNombre(String nombre) {
        ArrayList<ProductoInformatico> productosCoindentes = new ArrayList<>();
        for (ProductoInformatico producto: productos){
            if (producto.getNombre().equals(nombre)){
                productosCoindentes.add(producto);
            }
       }
        return productosCoindentes;
    }

    public List<ProductoInformatico> buscarPorCategoria(String cat) {
        ArrayList<ProductoInformatico> productosCoindentes = new ArrayList<>();
        for (ProductoInformatico producto: productos){
            if (producto.getCategoria().equals(cat)){
                productosCoindentes.add(producto);
            }
        }
        return productosCoindentes;
    }

    public void eliminarPorCodigo(String cod) {
        Iterator<ProductoInformatico> it = productos.iterator();
        while (it.hasNext()) {
            ProductoInformatico p = it.next();
            if (p.getCodigo().equals(cod)) {
                it.remove();
            }
        }

    }
    //metodos

}