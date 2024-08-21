package myLists.myArrayListImpl;

import myLists.myList;

/**
 * Это класс реализует интерфейс {@link myList}. Представляет собой кастомную версию ArrayList - гибкого массива .Принимает в
 * качестве элелмента null.
 *
 * @param <E> Тип элемента
 */
public class MyArrayList<E> implements myList<E> {

    private int size;
    private Object[] inner;
    E elementOfArr;

    public MyArrayList() {
        inner = new Object[10];
    }

    /**
     * Добавляет элемент в конец массива.При завершении свободных ячеек увеличиваетсвой размер
     * Релизует myList.add().
     *
     * @param element - добавляемый элемент
     */
    public void add(E element) {
        if (inner.length - size < 3) {
            inner = new Object[inner.length + 10];
        }
        if (inner[size] == null) {
            inner[size] = element;
        }
        size++;
    }
    /** Удаляет элемент из массива по узказнному индексу.При удалении из середины сдвигает элементы, не допуская null
     * в середине массива.
     * Релизует myList.remove
     * @param  index - индекс удаляемого элемента
     * @throws IndexOutOfBoundsException();
     * */
    public E remove(int index) {
        if (index < 0 | index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        elementOfArr = (E) inner[index];
        inner[index] = null;
        for (int i = index; i < size + 1; i++) {
            inner[i] = inner[i + 1];
        }
        size--;
        return elementOfArr;
    }
    /** Получает элемент из массива по узказнному индексу .
     * Релизует myList.get
     * @param  index - индекс получаемого элемента
     * @throws IndexOutOfBoundsException();
     * */
    public E get(int index) {
        if (index < 0 | index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        return (E) inner[index];
    }
    /** Заменяет существующий элемент массива расположенный по индексу . Релизует myList.set.
     * @param  index - индекс заменяемого элемента
     * @param  element - новый элемент
     * @return элемент который заменили новым
     * @throws IndexOutOfBoundsException();
     * */
    public E set(int index, E element) {
        if (index < 0 | index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        elementOfArr = (E) inner[index];
        inner[index] = element;
        return elementOfArr;
    }
    /** Создает новый массив из элементов существующего массива. Релизует myList.subList.
     * @param  startIndex - индекс элемента существующего массива, который станет первым в новом массиве
     * @param  endIndex - индекс элемента существующего массива, который станет последним в новом массиве
     * @return новый массив из элементов существующего массива
     * @throws IndexOutOfBoundsException();
     * */
    public MyArrayList<E> subList(int startIndex, int endIndex) {
        if ((startIndex < 0 | startIndex >= size) | (endIndex < 0 | endIndex >= size)) {
            throw new IndexOutOfBoundsException(startIndex + " " + endIndex);
        }
        MyArrayList<E> result = new MyArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
            result.add((E) inner[i]);
        }
        return result;
    }

    public int size() {
        return size;
    }
}
