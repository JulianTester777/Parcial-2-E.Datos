package DepuracionDelHistorial;

public class Stack<T>{

    private int size;
    private Node<T> top;

    public boolean isEmpty(){
        return top == null;
    }

    public void apilar(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        size++;

    }

    public T desapilar(){
        if(top == null){
            throw new RuntimeException("There are no elements in the stack ");
        }else{
            T data = top.getData();
            top = top.getNext();
            size--;
            return data;
        }
    }

    public T getTop(){
        if(top == null){
            throw new RuntimeException("There are no elements in the stack ");
        }else{
            return top.getData();
        }
    }

    public int getSize(){
        return size;
    }

    public void printStack(){
        Node<T> current = top;
        while(current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }


    public Stack<Operation> getLatestConfirmed(Stack<Operation> record , int n){

        Stack<Operation> result = new Stack<>();
        Stack<Operation> aux = new Stack<>();
        Stack<Operation> temporary = new Stack<>();

        int counter = 0;

        if(n <= 0){
            return result;
        }
        while(!record.isEmpty() && counter < n){

            Operation op = record.desapilar();
            aux.apilar(op);

            if(op.getState() == State.CONFIRMED) {
                temporary.apilar(op);
                counter++;
            }
        }
        while (!aux.isEmpty()){
            record.apilar(aux.desapilar());
        }
        while (!temporary.isEmpty()){
            result.apilar(temporary.desapilar());
        }
        return result;
    }

    public Stack<T> getSegment(Stack<T> original , int start , int end){
        Stack<T> result = new Stack<>();
        Stack<T> aux = new Stack<>();
        Stack<T> selected = new Stack<>();
        //Validar las posiciones
        if(start < 1){
            return result;
        }else if(start > end){
            return result;
        }else if(end > original.getSize()){
            return result;
        }
        int position = 1;
        //recorremos la pila original
        while(!original.isEmpty()){
            T current = original.desapilar();
            //guardamos para recuperar la pila original
            aux.apilar(current);
            //condiciones para escoger los seleccionados
            if(position >= start && position <= end){
                selected.apilar(current);
            }
            position++;}
        //pasar los seleccionados a el resultado
        while(!selected.isEmpty()){
            result.apilar(selected.desapilar());}
        //restaurar la pila orginal
        while(!aux.isEmpty()){
            original.apilar(aux.desapilar());
        }
        return result;
    }



}
