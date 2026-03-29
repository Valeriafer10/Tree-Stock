public class ArbolInventario {
    Producto raiz;

    // Método para insertar (recursivo)
    public Producto insertar(Producto raiz, int id, String nombre) {
        if (raiz == null) {
            return new Producto(id, nombre);
        }

        if (id < raiz.id) {
            raiz.izquierdo = insertar(raiz.izquierdo, id, nombre);
        } else if (id > raiz.id) {
            raiz.derecho = insertar(raiz.derecho, id, nombre);
        }

        return raiz;
    }

    // Método público para insertar
    public void insertar(int id, String nombre) {
        raiz = insertar(raiz, id, nombre);
    }

    // Recorrido Inorden (ordenado)
    public void inorden(Producto raiz) {
        if (raiz != null) {
            inorden(raiz.izquierdo);
            System.out.println("ID: " + raiz.id + " | Nombre: " + raiz.nombre);
            inorden(raiz.derecho);
        }
    }

    public void mostrarInventario() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
        } else {
            inorden(raiz);
        }
    }

    // Buscar producto
    public Producto buscar(Producto raiz, int id) {
        if (raiz == null || raiz.id == id) {
            return raiz;
        }

        if (id < raiz.id) {
            return buscar(raiz.izquierdo, id);
        } else {
            return buscar(raiz.derecho, id);
        }
    }

    public void buscar(int id) {
        Producto encontrado = buscar(raiz, id);

        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado.nombre);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}