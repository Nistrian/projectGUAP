package mypac;

import java.util.LinkedList;
import java.util.ListIterator;

public class SortedIntegerList {

    private LinkedList<Integer> list;
    private boolean isRepeats;

    public SortedIntegerList(boolean repeats) {  //конструктор класса
        this.isRepeats = repeats;
        list = new LinkedList<>();
    }

    public void add(int value) { //метод добавления нового элемента
        if (list.isEmpty()) {  //если пусто, добавляем
            list.add(value);
            return;
        }

        if (value >= list.getLast()) {
            if (value == list.getLast()) { //если значение равно предыдущему, то
                if (isRepeats) {            //если разрешены повторы
                    list.addLast(value);    //добавляем в конец
                }
            }
            else {                          //если больше, то добавляем в конец
                list.addLast(value);
            }
            return;
        }

        ListIterator<Integer> it = list.listIterator();
        while(it.hasNext()) { //пока есть следующий элемент
            int tmp = it.next(); //его значение записываем в tmp
            if (value <= tmp) { //
                if (tmp == value) {  //если переданное значение == tmp
                    if (isRepeats) {   //если разрешены повторы, записываем значения
                        it.set(value);
                        it.add(tmp);
                    }
                }else { //если число меньше, тоже записываем
                    it.set(value);
                    it.add(tmp);
                }
                return;
            }
        }
    }

    public void remove(int value) { //метод для удаления элемента
        if (list.isEmpty())         //если список пустой, ничего не делаем
            return;

        if (list.getLast() == value) { //если последний элемент равен нужному значению, удаляем до тех пор, пока в списке есть это значение
            while (list.getLast() == value) {
                list.removeLast();
            }
            return;
        }

        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            int tmp = it.next();
            if (tmp > value) // если первый элемент списка больше, чем нужное нам значение, ничего не делаем
                return;
            if (value == tmp) { //если равно, удаляем
                it.remove();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int value : list) {
            str.append(value).append(" ");
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) //если обращаемся к текущему экземпляру, возвращаем true
            return true;
        if (obj == null || this.getClass() != obj.getClass()) //если список пуст или объекты принадлежат разным классам, возвращаем false
            return false;
        SortedIntegerList object = (SortedIntegerList) obj;
        if (list.size() != object.list.size()) //если списки разной длины, возвращаем false
            return false;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(object.list.get(i))) //если элемент одного списка не равен соответствующему элементу второго списка, возвращаем false
                return false;
        }
        return true;  //в остальных случаях возвращаем true
    }
}
