package mypac;

import ExceptionPack.MatrixException;

public class SquareMatrix extends Matrix { //наследуемся от Matrix
    private int size;

    @Override 
    public SquareMatrix sum(Matrix sumMatrix) {
        if (this.size != sumMatrix.columnSize || this.size != sumMatrix.rowSize) //если размер квадратной матрицы не соответствует размеру 
        									    //второй матрицы, бросаем исключение
            throw new MatrixException("");
        SquareMatrix result = new SquareMatrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.matrixData[i][j] = this.matrixData[i][j] + sumMatrix.matrixData[i][j]; //сложение соответствующих элементов
            }
        }
        return result;
    }

    public SquareMatrix(int size) { //конструктор квадратных матриц
        super(size, size); //обращаемся к экземпляру родительского класса 
        for (int i = 0; i < rowSize; i++) { //заполняем единицами
            matrixData[i][i] = 1;
        }
        this.size = size;
    }

}
