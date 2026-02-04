import java.util.Objects;

public class ProductoInformatico {

    private String codigo;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    private String marca;

    public ProductoInformatico() {}

    public ProductoInformatico(String codigo, String nombre, String categoria,
                               double precio, int stock, String marca) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0)
            this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0)
            this.stock = stock;
       }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "ProductoInformatico{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", marca='" + marca + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductoInformatico that = (ProductoInformatico) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}