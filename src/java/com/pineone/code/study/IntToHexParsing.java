package com.pineone.code.study;

import org.springframework.stereotype.Service;

/**
 * Created by pahnj on 2015-12-13.
 */
@Service
public class IntToHexParsing implements IIntToHexParsing {
    public String hexString = "";//HexToIntStringParsing.PREFIX
    public int proportion = 0;
    public int remainder = 0;

    @Override
    public String IntToHexString(int dex) {
        int intData = dex;
        hexString = "";

        while (intData / HexToIntStringParsing.HEX > 0) {
            intData = intSubstitution(intData);
        }

        hexString = intDataConversion(remainder).concat(hexString);

        hexString = HexToIntStringParsing.PREFIX.concat(hexString);

        return hexString;
    }

    public int intSubstitution(int data) {
        remainder = data / HexToIntStringParsing.HEX;
        proportion = data % HexToIntStringParsing.HEX;
        hexString = intDataConversion(proportion).concat(hexString);
        return remainder;
    }


    public String intDataConversion(int value) {
        if (value == HexToIntStringParsing.HEX_10) {
            return HexToIntStringParsing.HEX_A;
        } else if (value == HexToIntStringParsing.HEX_11) {
            return HexToIntStringParsing.HEX_B;
        } else if (value == HexToIntStringParsing.HEX_12) {
            return HexToIntStringParsing.HEX_C;
        } else if (value == HexToIntStringParsing.HEX_13) {
            return HexToIntStringParsing.HEX_D;
        } else if (value == HexToIntStringParsing.HEX_14) {
            return HexToIntStringParsing.HEX_E;
        } else if (value == HexToIntStringParsing.HEX_15) {
            return HexToIntStringParsing.HEX_F;
        }

        return Integer.toString(value);
    }

}
