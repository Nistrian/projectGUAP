package mypac;

import ExceptionPack.MatrixException;

public class Matrix {
    protected final int[][] matrixData; //значение матриц
    protected final int rowSize;	 //количество строк
    protected final int columnSize;	 //количество столбцов

    public Matrix(int rowSize, int columnSize) { //конструктор
        if (rowSize <= 0 || columnSize <=0)  	   //если количество строк или столбцов меньше или равно 0, бросаем исключение
            throw new MatrixException("Incorrect row/column size");
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        matrixData = new int[rowSize][columnSize]; //создание нулевой матрицы
    }

    public void setElement(int row, int column, int value) { //изменение элемента
        if (row < 0 || row >= getRowSize() || column < 0 || column >= getColumnSize()) //если строк/столбцов < 0, или > чем в самой матрице 											//бросаем исключение
            throw new MatrixException("Set element is not possible. Row/column out if range"); 
        matrixData[row][column] = value; //в ином случае присваиваем значение
    }

    public int getElement(int row, int column) { //получение элемента
        if (row < 0 || row >= getRowSize() || column < 0 || column >= getColumnSize()) //если строк/столбцов < 0, или > чем в самой матрице
        										//бросаем исключение
            throw new MatrixException("Get element is not possible. Row/column out if range"); 
        return matrixData[row][column]; // в ином случае возвращаем элемент
    }

    public Matrix sum(Matrix sumMatrix) { //сложение матриц
        if (this.getColumnSize() != sumMatrix.getColumnSize() || this.getRowSize() != sumMatrix.getRowSize()) //если кол-во столбцов/строк
        									//первой не равно кол-ву второй матрицы бросаем исключение
            throw new MatrixException("Amount is not possible. The matrices must be the same size"); 

        Matrix result = new Matrix(sumMatrix.rowSize, sumMatrix.columnSize); //в ином случае создаем матрицу суммы

        for (int i = 0; i < sumMatrix.rowSize; i++) { 		//заполняем ее, складывая соответсвующие элементы двух матриц
            for (int j = 0; j < sumMatrix.columnSize; j++) {
                result.matrixData[i][j] = this.getElement(i, j) + sumMatrix.getElement(i, j);
            }
        }
        return result;
    }

    public Matrix product(Matrix prodMatrix) {  //умножение матриц
        if (this.getColumnSize() != prodMatrix.getRowSize()) //если кол-во столбцов первой матрицы не равно кол-ву строк второй, бросаем исключение
            throw new MatrixException("Multiplication is not possible. The number of columns must be equal to the number of rows");

        Matrix result = new Matrix(getRowSize(), prodMatrix.getColumnSize()); //иначе создаем матрицу произведения

        for (int i = 0; i < getRowSize(); i++) { //заполняем ее в соответствии с правилами умножения матриц
            for (int j = 0; j < prodMatrix.columnSize; j++) {
                int value = 0;
                for (int k = 0; k < prodMatrix.rowSize; k++) {
                    value += this.getElement(i, k) * prodMatrix.getElement(k, j);
                }
                result.setElement(i, j, value);
            }
        }
        return result;
    }

    public int getRowSize() { //получение количества строк матрицы
        return rowSize;
    }

    public int getColumnSize() { return columnSize;//получение количества столбцов матрицы
    }

    public boolean equals(Object obj) { //сравнение объектов
        if (obj == this) //если матрица сравнивается сама с собой, возвращаем true
            return true;
        if (!(obj instanceof Matrix)) //если объект не принадлежит классу Matrix, возвращаем false
            return false;
        Matrix matrix = (Matrix) obj;
        for (int i = 0; i < getRowSize(); i++) { 
            for (int j = 0; j < getRowSize(); j++) {
                if (getElement(i, j) != matrix.getElement(i, j)) //если соответствующие элементы не равны друг другу, матрицы не идентичны
                    return false;
            }
        }
        return true; //иначе идентичны
    }

    public String toString() { // вывод матрицы
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                str.append(matrixData[i][j]).append(" "); //добавляем каждый элемент, разделяя их пробелом
            }
            str.append("\n"); //новая строка
        }
        return str.toString(); //вывод
    }

}
