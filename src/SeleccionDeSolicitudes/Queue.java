package SeleccionDeSolicitudes;

public class Queue<T> {

    private Node<T> front;
    private Node<T> end;
    private int size;

    public Queue() {
        this.front = null;
        this.end = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public int getSize(){
        return size;
    }

    //agg al final de la cola encolar
    public void encolar(T data){

        Node<T> nuevo = new Node<>(data);
        if(isEmpty()){
            front = nuevo;

        }else {
            end.setNext(nuevo);
        }
        end = nuevo;
        size++;
    }

    //eliminar al inicio de la cola desencolar
    public T desencolar() {

        if (isEmpty()) {
            throw new RuntimeException("There are no elements in the queue ");
        }
        T data = front.getData();
        front = front.getNext();

        if (front == null) {
            end = null;
        }
        size --;
        return data;
    }

    public void printQueue() {
        Node<T> current = front;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    //Metodo principal, seleccionar solicitudes
    public Queue<Request> selectRequests(Queue<Request> pending , int minutes){

        Queue<Request> result = new Queue<>();

        if(minutes <= 0){    //si no hay timepo devuelvo una cola vacia
            return result;
        }

         minutes = pass(pending, result, minutes, Priority.HIGH);


         minutes = pass(pending, result, minutes, Priority.NORMALLY);

         return result;
    }

    //Metodo auxiliar para pasar por la cola y seleccionar solicitudes
    public int pass(Queue<Request> pending, Queue<Request> result, int minutes, Priority priority){

        int amount = pending.getSize();

        for(int i = 0; i < amount; i++) {
            Request current = pending.desencolar();

            if (current.getPriority() == priority && current.getDuration() <= minutes) {
                result.encolar(current);
                minutes = minutes - current.getDuration();
            } else {
                pending.encolar(current);
            }
        }
        return minutes;
    }

}
