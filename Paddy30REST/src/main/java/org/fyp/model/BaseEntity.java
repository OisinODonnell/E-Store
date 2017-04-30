package org.fyp.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by oisin on 30/03/2017.
 */
public abstract class BaseEntity {

    /**
     * Conversion methods used when taking data in from a csv file.
     */

    public Integer toInteger(String value)
    {
        Integer valueToInteger = null;

        try {
            valueToInteger = Integer.parseInt(value);
        } catch(NumberFormatException e) {
            System.out.println(e);
        }
        return valueToInteger;
    }

    public BigDecimal toBigDecimal(String value)
    {
        BigDecimal valueToBigDecimal = null;

        try {
            valueToBigDecimal = new BigDecimal(value.replaceAll(",", ""));
        } catch (NumberFormatException e)  {
            System.out.println(e);
        }

        return valueToBigDecimal;
    }

    public byte[] toByteArray(String value) {       return  value.getBytes(); }

    public Byte toByte(String value) {              return value.getBytes()[0]; }

    public Timestamp toTimestamp(String value) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date parsedDate = dateFormat.parse(value);
        return  new Timestamp(parsedDate.getTime());
    }
}
