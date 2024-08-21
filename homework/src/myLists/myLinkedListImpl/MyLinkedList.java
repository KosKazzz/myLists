package myLists.myLinkedListImpl;

import myLists.myList;

/**
 * Это класс реализует интерфейс {@link myList}. Представляет собой кастомную версию двусвязанного списка.Принимает в
 * качестве элелмента null.
 * @param <E> Тип элемента
 */

public class MyLinkedList<E> implements myList<E> {
    private int size;
    private Node<E> node;
    private Node<E> firstNode;
    private Node<E> lastNode;

    static class Node<E> {
        E element;
        Node<E> previousNode;
        Node<E> nextNode;

        Node(E e) {
            element = e;
        }
    }

    /** Добавляет элемент в конец списка. Релизует myList.add();
     * @param element  - добавляемый элемент
     * */
    public void add(E element) {
        if (size == 0) {
            firstNode = new Node<>(element);
            lastNode = firstNode;
        } else {
            node = new Node<>(element);
            lastNode.nextNode = node;
            node.previousNode = lastNode;
            lastNode = node;
        }
        size++;
    }

    /** Удаляет элемент из списка по узказнному индексу . Релизует myList.remove
     * @param  index - индекс удаляемого элемента
     * @throws IndexOutOfBoundsException();
     * */
    public E remove(int index) {
        if (index < 0 | index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        node.element = this.get(index);
        if (index == 0) {
            firstNode = firstNode.nextNode;
            firstNode.previousNode = null;
        }
        size--;
        return node.element;
    }

    /** Получает элемент из списка по узказнному индексу . Релизует myList.get
     * @param  index - индекс получаемого элемента
     * @throws IndexOutOfBoundsException();
     * */
    public E get(int index) {
        if (index < 0 | index > size) {
            throw new IndexOutOfBoundsException(index);
        }
        Node<E> node = firstNode;
        if (index == size - 1) {
            return lastNode.element;
        }
        if (index != 0 && index < size - 1) {
            for (int i = 1; i <= index; i++) {
                node = node.nextNode;
            }
        }
        return node.element;
    }

    /** Заменяет существующий элемент списка расположенный по индексу . Релизует myList.set.
     * @param  index - индекс заменяемого элемента
     * @param  element - новый элемент
     * @return элемент который заменили новым
     * @throws IndexOutOfBoundsException();
     * */
    public E set(int index, E element) {
        if (index < 0 | index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        Node<E> node = new Node<>(this.get(index));
        firstNode.element = element;
        if (index == size - 1) {
            lastNode.element = element;
        }
        if (index != 0 && index < size - 1) {
            Node<E> newNode = firstNode;
            for (int i = 1; i <= index; i++) {
                newNode = newNode.nextNode;
            }
            newNode.element = element;
        }
        return node.element;
    }

    /** Создает новый список из элементов существующего списка. Релизует myList.subList.
     * @param  startIndex - индекс элемента существующего списка, который станет первым в новом списке
     * @param  endIndex - индекс элемента существующего списка, который станет последним в новом списке
     * @return новый список из элементов существующего списка
     * @throws IndexOutOfBoundsException();
     * */
    public MyLinkedList<E> subList(int startIndex, int endIndex) {
        if ((startIndex < 0 | startIndex >= size) | (endIndex < 0 | endIndex >= size)) {
            throw new IndexOutOfBoundsException(startIndex + " " + endIndex);
        }
        MyLinkedList<E> result = new MyLinkedList<>();
        for (int i = startIndex; i < endIndex; i++) {
            result.add(this.get(i));
        }
        return result;
    }


    public int size() {
        return this.size;
    }
}
