package com.pineone.code.study.stringutil.hextointstring;

import org.springframework.stereotype.Service;

/**
 * Created by pahnj on 2015-12-13.
 * 헥사를 Int형 String으로 변환하는 API
 */
@Service
public class HexToIntStringParsing implements IHexToIntStringParsing {


    public static final String PREFIX = "0x";
    public static final int HEX = 16;
    public static final int HEX_10 = 10;
    public static final int HEX_11 = 11;
    public static final int HEX_12 = 12;
    public static final int HEX_13 = 13;
    public static final int HEX_14 = 14;
    public static final int HEX_15 = 15;
    public static final String HEX_A = "A";
    public static final String HEX_B = "B";
    public static final String HEX_C = "C";
    public static final String HEX_D = "D";
    public static final String HEX_E = "E";
    public static final String HEX_F = "F";
    public static final int ZERO = 0;

    @Override
    public int HextoString(String hex) {

        int hexInt = 0;

        if (hex.startsWith(PREFIX) && hex.length() > 2) {
            String hexNum = hex.substring(PREFIX.length());
            for (int i = 0; i < hexNum.length(); i++) {
                hexInt += hexSubstitution(hexDataConversion(hexNum.substring(hexNum.length() - i - 1, hexNum.length() - i)), i);
            }
        }
        return hexInt;
    }

    public int hexSubstitution(int hex, int places) {

        if (places != ZERO) {
            return hex * HexFactory(HEX, places);
        } else {
            return hex;
        }
    }

    public int HexFactory(int value, int count) {
        int factoryValue = 1;
        for (int i = 0; i < count; i++) {
            factoryValue *= value;
        }
        return factoryValue;
    }

    public int hexDataConversion(String hex) {
        if (HEX_A.equals(hex)) {
            return HEX_10;
        } else if (HEX_B.equalsIgnoreCase(hex)) {
            return HEX_11;
        } else if (HEX_C.equalsIgnoreCase(hex)) {
            return HEX_12;
        } else if (HEX_D.equalsIgnoreCase(hex)) {
            return HEX_13;
        } else if (HEX_E.equalsIgnoreCase(hex)) {
            return HEX_14;
        } else if (HEX_F.equalsIgnoreCase(hex)) {
            return HEX_15;
        }
        return Integer.parseInt(hex);
    }


}
