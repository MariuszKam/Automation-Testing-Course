package com.solvd.laba.block1.task2.models.shop.components;

public class MyLinkedList<T> {
    private Node<T> head;

    private static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
            this.next = null;
        }
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        //Checking head
        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void showList() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.element + " ");
            currentNode = currentNode.next;
        }
    }
}
