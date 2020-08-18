package com.study.leet;

/**
 * @author andrii_lytvynskyi
 */
public class IntegerToEnglishWord {

    public String one(int num) {
        switch(num) {
        case 1: return "One";
        case 2: return "Two";
        case 3: return "Three";
        case 4: return "Four";
        case 5: return "Five";
        case 6: return "Six";
        case 7: return "Seven";
        case 8: return "Eight";
        case 9: return "Nine";
        }
        return "";
    }

    public String twoLessThan20(int num) {
        switch(num) {
        case 10: return "Ten";
        case 11: return "Eleven";
        case 12: return "Twelve";
        case 13: return "Thirteen";
        case 14: return "Fourteen";
        case 15: return "Fifteen";
        case 16: return "Sixteen";
        case 17: return "Seventeen";
        case 18: return "Eighteen";
        case 19: return "Nineteen";
        }
        return "";
    }

    public String ten(int num) {
        switch(num) {
        case 2: return "Twenty";
        case 3: return "Thirty";
        case 4: return "Forty";
        case 5: return "Fifty";
        case 6: return "Sixty";
        case 7: return "Seventy";
        case 8: return "Eighty";
        case 9: return "Ninety";
        }
        return "";
    }

    public String two(int num) {
        if (num == 0)
            return "";
        else if (num < 10)
            return one(num);
        else if (num < 20)
            return twoLessThan20(num);
        else {
            int tenner = num / 10;
            int rest = num - tenner * 10;
            if (rest != 0)
                return ten(tenner) + " " + one(rest);
            else
                return ten(tenner);
        }
    }

    public String three(int num) {
        int hundred = num / 100;
        int rest = num - hundred * 100;
        String res = "";
        if (hundred*rest != 0)
            res = one(hundred) + " Hundred " + two(rest);
        else if ((hundred == 0) && (rest != 0))
            res = two(rest);
        else if ((hundred != 0) && (rest == 0))
            res = one(hundred) + " Hundred";
        return res;
    }

//    public String numberToWords(int num) {
//        if (num == 0)
//            return "Zero";
//
//        int billion = num / 1000000000;
//        int million = (num - billion * 1000000000) / 1000000;
//        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
//        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;
//
//        String result = "";
//        if (billion != 0)
//            result = three(billion) + " Billion";
//        if (million != 0) {
//            if (! result.isEmpty())
//                result += " ";
//            result += three(million) + " Million";
//        }
//        if (thousand != 0) {
//            if (! result.isEmpty())
//                result += " ";
//            result += three(thousand) + " Thousand";
//        }
//        if (rest != 0) {
//            if (! result.isEmpty())
//                result += " ";
//            result += three(rest);
//        }
//        return result;
//    }


    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int num) {
        String result = new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num - 10];
        else if (num < 100) result = belowHundred[num/10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }

    public static void main(String[] args) {
        int i = 123456;
        System.out.println(i % 1000);
    }

}
