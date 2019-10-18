package spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class Main {

    public static void main(String[] args) {
        PrintService printService = ExtensionLoader
                .getExtensionLoader(PrintService.class)
                .getDefaultExtension();
        printService.printInfo();
    }

}
