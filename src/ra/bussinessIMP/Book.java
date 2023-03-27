package ra.bussinessIMP;

import ra.bussiness.IBook;

import java.util.List;
import java.util.Scanner;

public class Book implements IBook,Comparable<Book> {
    private int ID;
    private String bookName;
    private String title;
    private int numberOfPage;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int ID, String bookName, String title, int numberOfPage, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.ID = ID;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPage = numberOfPage;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }


    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
    public void getBookStatus(boolean bookStatus) {

    }

    @Override
    public void inputData(Scanner scanner , List<Book> books) {
        System.out.println("Nhập tên sách");
        this.bookName=scanner.nextLine();
        System.out.println("Nhập tiêu đề");
        this.title=scanner.nextLine();
        System.out.println("Nhập giá nhập sách");
        this.importPrice= Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá bán sách");
        this.exportPrice= Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập số trang sách");
        this.numberOfPage= Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập trạng thái sách");
        this.bookStatus= Boolean.parseBoolean(scanner.nextLine());
        this.interest=this.exportPrice-this.importPrice;
    }

    @Override
    public void displayData() {
        System.out.printf("----------------MENU------------------");
        System.out.printf("1.Mã sáhc : %d\n",this.ID);
        System.out.printf("1.Tên sách : %s\n",this.bookName);
        System.out.printf("1.Tiêu đề : %s\n",this.title);
        System.out.printf("1.Số trang sách  : %d\n",this.numberOfPage);
        System.out.printf("1.Giá  nhâp  : %.1f\n",this.importPrice);
        System.out.printf("1.Giá Bán  : %.1f\n",this.exportPrice);
        System.out.printf("1.Trạng thái sách   : %s\n",(this.bookStatus?"Bán":"Không bán"));
        System.out.printf("----------------****------------------");

    }

    @Override
    public int compareTo(Book book) {
        return (int) (book.getExportPrice()-this.exportPrice);
    }
}


