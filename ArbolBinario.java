package arbolbinario;

public class ArbolBinario {

    public static void main(String[] args) {

        ArbolB arbol = new ArbolB();
        arbol.insertar(10);
        arbol.insertar(6);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(6);
        arbol.insertar(8);
        arbol.insertar(21);
        arbol.insertar(14);
        arbol.insertar(12);
        arbol.insertar(13);
        arbol.insertar(1);
        arbol.inOrder();
        System.out.println("");
        arbol.preOrder();
        System.out.println("");
        arbol.posOrder();
System.out.println("");
System.out.println("");


        arbol.eliminar(10);
        arbol.inOrder();
        System.out.println("");
        arbol.preOrder();
        System.out.println("");
        arbol.posOrder();
        
        arbol.borradoCompleto();
         arbol.inOrder();
        System.out.println("");
        arbol.preOrder();
        System.out.println("");
        arbol.posOrder();
        

    }

}
