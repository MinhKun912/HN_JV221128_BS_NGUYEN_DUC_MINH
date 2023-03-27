package ra.bussiness;

import ra.bussinessIMP.Book;

import java.util.List;
import java.util.Scanner;

public interface IBook {
    void inputData(Scanner scanner , List<Book> book);
    void displayData();

}
