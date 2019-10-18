package spi;

public class PrintServiceImpl2 implements PrintService {
    public String printInfo() {
        System.out.println("Impl 2");
        return "Impl 2";
    }
}
