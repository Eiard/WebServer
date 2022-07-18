package com.ytz.web.utils;

/**
 * @projectName: web
 * @package: com.ytz.web.utils
 * @className: PriceUtils
 * @author: Delmore
 * @description: TODO :
 * @date: 2022/7/15 16:10
 * @version: 1.0
 */
public class PriceUtils {
    final static Double generalCargoBasePrice = 12.0;
    final static Double sensitiveCargoBasePrice = 14.0;
    final static Double foodStuffBasePrice = 14.0;
    final static Double medicinalBasePrice = 14.0;
    final static Double batteryCargoBasePrice = 12.0;
    final static Double documentCargoBasePrice = 15.0;

    public static Double getFinalPrice(Double weight, Integer goodType) {
        Double finalPrice = 0.0;
        if (weight <= 1) {
            if (goodType == 1) finalPrice = generalCargoBasePrice * weight;
            if (goodType == 2) finalPrice = sensitiveCargoBasePrice * weight;
            if (goodType == 3) finalPrice = foodStuffBasePrice * weight;
            if (goodType == 4) finalPrice = medicinalBasePrice * weight;
            if (goodType == 5) finalPrice = batteryCargoBasePrice * weight;
            if (goodType == 6) finalPrice = documentCargoBasePrice * weight;
        }else{
            if (goodType == 1) finalPrice = generalCargoBasePrice + 2*(weight-1);
            if (goodType == 2) finalPrice = sensitiveCargoBasePrice +3* (weight-1);
            if (goodType == 3) finalPrice = foodStuffBasePrice + 3*(weight-1);
            if (goodType == 4) finalPrice = medicinalBasePrice + 3*(weight-1);
            if (goodType == 5) finalPrice = batteryCargoBasePrice + 2*(weight-1);
            if (goodType == 6) finalPrice = documentCargoBasePrice + 5*(weight-1);
        }
        return finalPrice;
    }
}
