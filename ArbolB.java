/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

/**
 *
 * @author GranCarlitos
 */
public class ArbolB {

    public NodoArbol raiz;

    public void abb() {
        NodoArbol raiz = new NodoArbol();
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    public void insertar(int a) {
        if (esVacio()) {
            NodoArbol nuevo = new NodoArbol();
            nuevo.dato = a;
            nuevo.hd = new ArbolB();
            nuevo.hi = new ArbolB();
            raiz = nuevo;
        } else {
            if (a > raiz.dato) {
                (raiz.hd).insertar(a);
            }
            if (a < raiz.dato) {
                (raiz.hi).insertar(a);
            }
        }
    }

    public void preOrder() {
        if (!esVacio()) {
            System.out.print(raiz.dato + ", ");
            raiz.hi.preOrder();
            raiz.hd.preOrder();
        }
    }

    public void inOrder() {
        if (!esVacio()) {
            raiz.hi.inOrder();
            System.out.print(raiz.dato + ", ");
            raiz.hd.inOrder();
        }
    }

    public void posOrder() {
        if (!esVacio()) {
            raiz.hd.posOrder();
            raiz.hi.posOrder();
            System.out.print(raiz.dato + ", ");

        }
    }

    public ArbolB buscar(int a) {
        ArbolB arbolito = null;
        if (!esVacio()) {
            if (a == raiz.dato) {
                return this;
            } else {
                if (a < raiz.dato) {
                    arbolito = raiz.hi.buscar(a);
                } else {
                    arbolito = raiz.hd.buscar(a);
                }
            }
        }
        return arbolito;
    }

    public boolean existe(int a) {
        if (!esVacio()) {
            if (a == raiz.dato) {
                return true;
            } else {
                if (a < raiz.dato) {
                    raiz.hi.existe(a);
                } else {
                    raiz.hd.existe(a);
                }
            }
        }
        return false;
    }

    public int cantidad() {
        if (esVacio()) {
            return 0;
        } else {
            return (1 + raiz.hd.cantidad() + raiz.hi.cantidad());
        }
    }

    public int altura() {
        if (esVacio()) {
            return 0;
        } else {
            return (1 + Math.max(((raiz.hi).altura()), ((raiz.hd).altura())));
        }
    }

    public int buscarMin() {
        ArbolB arbolActual = this;
        while (!arbolActual.raiz.hi.esVacio()) {
            arbolActual = arbolActual.raiz.hi;
        }
        int devuelvo = arbolActual.raiz.dato;
        arbolActual.raiz = null;
        return devuelvo;
    }

    public int buscarMan() {
        ArbolB arbolActual = this;
        while (!arbolActual.raiz.hd.esVacio()) {
            arbolActual = arbolActual.raiz.hd;
        }
        int devuelvo = arbolActual.raiz.dato;
        arbolActual.raiz = null;
        return devuelvo;
    }

    public boolean esHoja() {
        boolean hoja = false;
        if ((raiz.hi).esVacio() && (raiz.hd).esVacio()) {
            hoja = true;
        }
        return hoja;
    }

    public void eliminar(int a) {
        ArbolB paraEliminar = buscar(a);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.raiz = null;
            } else {
                if (!paraEliminar.raiz.hi.esVacio() && !paraEliminar.raiz.hd.esVacio()) {
                    paraEliminar.raiz.dato = paraEliminar.raiz.hd.buscarMin();
                } else {
                    if (paraEliminar.raiz.hi.esVacio()) {
                        paraEliminar.raiz = paraEliminar.raiz.hd.raiz;
                    } else {
                        paraEliminar.raiz = paraEliminar.raiz.hi.raiz;
                    }
                }
            }
        }
    }

    public void borradoCompleto() {
        this.raiz = null;
    }
}
