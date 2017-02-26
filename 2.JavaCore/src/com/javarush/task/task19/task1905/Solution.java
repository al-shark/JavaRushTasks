package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer=customer;
            this.contact=contact;
        }

        @Override
        public String getCountryCode() {
            String cnt = customer.getCountryName();
            String res = "UA";
            for (Map.Entry<String,String> x : countries.entrySet())
                if (cnt.equals(x.getValue())) res=x.getKey();
            return res;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String nam = contact.getName();
            return nam.substring(nam.lastIndexOf(", ")+2,nam.length());
        }

        @Override
        public String getContactLastName() {
            String nam = contact.getName();
            return nam.substring(0,nam.indexOf(", "));
        }

        @Override
        public String getDialString() {
            String str = contact.getPhoneNumber();
            String res = "callto://+";
            for (int i=1;i<=str.length();i++)
                if (Character.isDigit(str.charAt(i-1))) res=res+str.substring(i-1,i);
            return res;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}