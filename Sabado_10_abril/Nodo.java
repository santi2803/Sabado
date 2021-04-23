public class Nodo {
    float coef;
    int exp;
    Nodo sig;

    public Nodo(float c, int e) {
        coef = c;
        exp = e;
        sig = null;
    }
}