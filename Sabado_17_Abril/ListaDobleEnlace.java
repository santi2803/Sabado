public class ListaDobleEnlace {
    Nodo lista;

    public ListaDobleEnlace() {
        lista = null;
    }

    void ingresarDatos(int x) {
        Nodo nuevo = new Nodo(x);
        if (lista == null) {
            lista = nuevo;
            lista.izq = lista;
            lista.der = lista;
        } else {
            Nodo p = lista;
            if (x < p.info) {
                nuevo.der = p;
                nuevo.izq = p.izq;
                p.izq.der = nuevo;
                p.izq = nuevo;
                lista = nuevo;
            } else {
                p = lista.der;
                while (p != lista && x > p.info)
                    p = p.der;
                nuevo.der = p;
                nuevo.izq = p.izq;
                p.izq.der = nuevo;
                p.izq = nuevo;
            }
        }
    }

    String mostrarDatos() {
        String salida = "";
        Nodo aux;
        if (lista != null) {
            salida += lista.info + "  ";
            aux = lista.der;
            while (aux != lista) {
                salida += aux.info + "  ";
                aux = aux.der;
            }
        }
        return salida;
    }

    int sumarDatos() {
        int suma = 0;
        Nodo aux;
        if (lista != null) {
            suma += lista.info;
            aux = lista.der;
            while (aux != lista) {
                suma += aux.info;
                aux = aux.der;
            }
        }
        return suma;
    }

    boolean retirarDato(int x) {
        if (lista == null)
            return false;
        else {
            if (x == lista.info) {
                if (lista.der == lista) {
                    lista = null;
                } else {
                    lista.izq.der = lista.der;
                    lista.der.izq = lista.izq;
                    lista = lista.der;
                }
                return true;
            } else {
                Nodo aux = lista.der;
                while (aux != lista && x != aux.info)
                    aux = aux.der;
                if (aux == lista)
                    return false;
                else {
                    aux.der.izq = aux.izq;
                    aux.izq.der = aux.der;
                    return true;
                }
            }
        }
    }

    int contarDatos() {
        int contador = 0;
        Nodo aux;
        if (lista != null) {            
            contador++;
            aux = lista.der;
            while (aux != lista) {
                contador++;
                aux = aux.der;
            }
        }

        return contador;
    }
}