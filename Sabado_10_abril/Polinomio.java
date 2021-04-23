public class Polinomio {
    Nodo pol;

    public Polinomio() {
        pol = null;
    }

    boolean ingresarTermino(float c, int e) {
        Nodo nuevo = new Nodo(c, e);
        if (pol == null) {
            pol = nuevo;
            return true;
        } else {
            Nodo p = pol, q = null;
            while (p != null && e < p.exp) {
                q = p;
                p = p.sig;
            }
            if (q == null) {
                nuevo.sig = pol;
                pol = nuevo;
                return true;
            } else {
                if (p != null)
                    if (p.exp == e)
                        return false;
                    else {
                        q.sig = nuevo;
                        nuevo.sig = p;
                        return true;
                    }
                else {
                    q.sig = nuevo;
                    return true;
                }
            }
        }
    }

    float evaluarPolinomio(float x) {
        float valorPol = 0;
        Nodo aux = pol;
        while (aux != null) {
            valorPol += aux.coef * Math.pow(x, aux.exp);
            aux = aux.sig;
        }
        return valorPol;
    }

    String mostrarPolinomio() {
        String salida = "";
        Nodo aux = pol;
        while (aux != null) {
            if (aux != pol)
                if (aux.coef > 0)
                    salida += "+";
            if (aux.exp == 0)
                salida += aux.coef;
            else
                salida += aux.coef + "X^" + aux.exp;
            aux = aux.sig;
        }
        return salida;
    }

    // p1.sumarPolinomios(p2,p3);
    void sumarPolinomios(Polinomio p2, Polinomio p3) {
        Nodo aux1 = pol, aux2 = p2.pol;
        while (aux1 != null && aux2 != null) {
            if (aux1.exp > aux2.exp) {
                p3.ingresarTermino(aux1.coef, aux1.exp);
                aux1 = aux1.sig;
            } else if (aux1.exp < aux2.exp) {
                p3.ingresarTermino(aux2.coef, aux2.exp);
                aux2 = aux2.sig;
            } else {
                p3.ingresarTermino(aux1.coef + aux2.coef, aux1.exp);
                aux1 = aux1.sig;
                aux2 = aux2.sig;
            }
        }
        while (aux1 != null) {
            p3.ingresarTermino(aux1.coef, aux1.exp);
            aux1 = aux1.sig;
        }
        while (aux2 != null) {
            p3.ingresarTermino(aux2.coef, aux2.exp);
            aux2 = aux2.sig;
        }
    }

    // p1.derivada(p2);
    void derivadaPol(Polinomio p2) {
        Nodo aux = p2.pol;
        while (aux != null) {
            
        }
        System.out.println("Plinomio"+p2.pol);
    }

    // p2 = p3.derivada(p1);
    Polinomio derivada(Polinomio p) {
        return p;
    }
}
