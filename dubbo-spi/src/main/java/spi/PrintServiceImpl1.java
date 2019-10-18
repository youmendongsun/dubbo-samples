package spi;

public class PrintServiceImpl1 implements PrintService {
    public String printInfo() {
        System.out.println("Impl 1");
        return "Impl 1";
    }
}
