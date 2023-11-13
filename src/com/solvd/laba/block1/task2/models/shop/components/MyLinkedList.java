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
        Node<T> currentNode = head;

        while (currentNode != null) {
            currentNode = currentNode.next;
        }
        currentNode = newNode;
    }
}
