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

    public void remove(T element) {
        //Checking head
        if (head == null) {
            return;
        }
        if (head.element.equals(element)) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null && !current.element.equals(element)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        previous.next = current.next;

    }

    public void showList() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.element + " ");
            currentNode = currentNode.next;
        }
    }
}
