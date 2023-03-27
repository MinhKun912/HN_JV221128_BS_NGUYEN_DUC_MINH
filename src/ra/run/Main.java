package ra.run;

import ra.bussinessIMP.Book;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> listBook = new ArrayList<>();

        while (true) {
            System.out.println("1.. Nhập số sách và nhập thông tin sách \n" +
                    "2. Hiển thị thông tin các sách \n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần \n" +
                    "4. Xóa sách theo mã sách \n" +
                    "5. Tìm kiếm sách theo tên sách \n" +
                    "6. Thay đổi trạng thái của sách theo mã sách \n" +
                    "7. Thoát");
            System.out.println("Nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewBook(listBook, scanner);
                    break;
                case 2:
                    display(listBook);
                    break;
                case 3:
                    sort(listBook);
                    break;
                case 4:
                    delete(scanner,listBook);
                case 5:
                    search(listBook, scanner);
                    break;
                case 0:
                    System.exit(7);
                    break;
                case 6:
                    delete(scanner,listBook);
                    break;

                default:
                    System.out.println("ERROR");
                    break;
            }
        }

    }

    public static void addNewBook(List<Book> list, Scanner scanner) {

        System.out.printf("Nhập số lượng sách cần thêm");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập sách thứ " + (i + 1) + " :");
            Book book = new Book();
            book.inputData(scanner, list);
            if (list.size()==0){
                book.setID(1);
            }
            list.add(book);
        }
        System.out.println("thêm thành công");
        display(list);

    }

    public static void sort(List<Book> list) {
        Collections.sort(list);
        display(list);
    }

    public static void display(List<Book> list) {
        for (Book book : list
        ) {
            book.displayData();
        }
    }

    public static void search(List<Book> list, Scanner scanner) {
        System.out.println("Nhập tên sách muốn tìm");
        String searchName = scanner.nextLine();
        List<Book> listSearch = new ArrayList<>();
        for (Book book : list
        ) {
            if (book.getBookName().contains(searchName)) {
                listSearch.add(book);
            }

        }
        System.out.println("Danh sách tìm kiếm là ");
        display(listSearch);
    }
    public static void  delete(Scanner scanner,List<Book> books){
        int bookId = scanner.nextInt();
        for (Book book : books) {
            if (book.getID() == bookId) {
                books.remove(book);
            }
        }

    }
    public static void change(List<Book> books,Scanner scanner){
        if (books.isEmpty()) {
            System.out.println("Không có sách trong danh sách.");
        } else {
            System.out.println("Nhập vào mã sách cần thay đổi trạng thái : ");
            int bookIdChange = scanner.nextInt();
            boolean foundBook = false;
            for (Book book : books) {
                if (book.getID()== bookIdChange){
                    foundBook = true;
                    System.out.println("Nhập vào trạng thái mới của tình trạng sách (1. Còn sách, 2.Hết sách ");
                    int newStatus = scanner.nextInt();
                    if (newStatus == 1) {
                        System.out.println(book.isBookStatus());
                    } else if (newStatus == 2) {
                        book.setBookStatus(Boolean.parseBoolean("Hết sách"));
                    } else {
                        System.out.println("Trạng thái không hợp lệ.");
                    }
                    System.out.println("Trạng thái của sách \"" + book.getBookName() + "\" đã được thay đổi thành \"" + book.isBookStatus() + "\".");
                    break;
                }
            }

            if (!foundBook) {
                System.out.println("Không tìm thấy sách có mã \"" + bookIdChange + "\".");
            }
        }

    }

}