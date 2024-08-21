package myLists;

/**
 * Параметризованный интерфейс, определяет минимальный набор методов необходимых для реализации
 * @param <E> - Тип элемента
 */
public interface myList<E> {
    void add(E element);

    E remove(int index);

    E get(int index);

    E set(int index, E element);

    myList<E> subList(int startIndex, int endIndex);
    /** Определяет размер  списка */
    int size();

}
