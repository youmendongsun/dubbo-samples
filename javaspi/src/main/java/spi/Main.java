package spi;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        ServiceLoader<PrintService> loader = ServiceLoader.load(PrintService.class);
        for (PrintService ps : loader) {
            ps.printInfo();
        }
    }

}
