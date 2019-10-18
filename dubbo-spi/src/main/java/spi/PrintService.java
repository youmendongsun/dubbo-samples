package spi;

import com.alibaba.dubbo.common.extension.SPI;

@SPI("impl")
public interface PrintService {

    String printInfo();

}
