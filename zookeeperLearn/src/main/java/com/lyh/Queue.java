package com.lyh;

/**
 * Created by lvyanghui
 * 2019/3/8 12:38
 */
public class Queue<E> {

    private int front;

    private int rear;

    private int max_size = 16;

    private Object[] data;

    public Queue(){
        this(10);
    }

    public Queue(int size){
        if(size < 0){
            throw new IllegalArgumentException("队列初始化失败，原因是："+size);

        }
        this.max_size = size;
        front = rear = 0;
        data = new Object[max_size];
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public boolean add(E e){

        if(rear == max_size){
            throw new RuntimeException("");
        }else{
            data[rear++] = e;
            return true;
        }
    }

    public E peek(){
        if(isEmpty()){
            return null;
        }else{
            return (E)data[front];
        }
    }

    public E poll(){
        if(isEmpty()){
            throw new RuntimeException("");
        }else{
            E e = (E)data[front];
            data[front++]=null;
            return e;
        }
    }

    public int length(){
        return rear - front;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.add("h");
        queue.add("e");
        queue.add("l");
        queue.add("l");
        queue.add("o");
        int length = queue.length();
        for(int i=0;i<length;i++){
            System.out.println(queue.poll());
        }
        System.out.println(queue.front);
    }
}
