package DepuracionDelHistorial;


public class Main {
    public static void main(String[] args) {

//Prueba metodo getLatestConfirmed
        Stack<Operation> record = new Stack<>();

        record.apilar(new Operation("01", State.CANCELLED));
        record.apilar(new Operation("02", State.CONFIRMED));
        record.apilar(new Operation("03", State.CONFIRMED));
        record.apilar(new Operation("04", State.CANCELLED));
        record.apilar(new Operation("05", State.CONFIRMED));



        System.out.println("Historial antes de depurar");
        record.printStack();


        Stack <Operation> aux = new Stack<>();
        Stack <Operation> result = aux.getLatestConfirmed(record , 2);
        System.out.println("Resultado n = 2" );
        result.printStack();

        System.out.println("Historial después de depurar");
        record.printStack();


//prueba metodo getSegment
        Stack<String> original = new Stack<>();

        original.apilar("A1");
        original.apilar("A2");
        original.apilar("A3");
        original.apilar("A4");
        original.apilar("A5");
        original.apilar("A6");

        System.out.println("Pila original:");
        original.printStack();

        System.out.println("Segmento desde la posición 2 hasta la posición 4:");
        original.getSegment(original, 2, 4).printStack();

        System.out.println("Pila original después de obtener el segmento:");
        original.printStack();
    }
}