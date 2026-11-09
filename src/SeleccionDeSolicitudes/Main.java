package SeleccionDeSolicitudes;

public class Main {
    public static void main(String[] args) {


        // Crear la cola de solicitudes pendientes
        Queue<Request> pending = new Queue<>();

        // Agregar las solicitudes del ejemplo del profesor
        pending.encolar(new Request("S1", Priority.NORMALLY, 10));
        pending.encolar(new Request("S2", Priority.HIGH, 30));
        pending.encolar(new Request("S3", Priority.HIGH, 15));
        pending.encolar(new Request("S4", Priority.NORMALLY, 5));


        Queue<Request> aux = new Queue<>();


        Queue<Request> result = aux.selectRequests(pending, 25);

        // Mostrar las solicitudes seleccionadas
        System.out.println("Solciitudes seleccionada :");
        result.printQueue();


        // Mostrar las solicitudes que quedaron pendientes
        System.out.println(" Solicitudes pendientes :");
        pending.printQueue();



    }
}

