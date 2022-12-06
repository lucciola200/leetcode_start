public class Top100QMedium {
    public void runSolutions() {

//---------6. Zigzag Conversion
//        System.out.println(convert("PAYPALISHIRING", 3));
//        System.out.println(convert("PAYPALISHIRING", 4));
//        System.out.println(convert("ABCD", 3));

//        7. Reverse Integer
        System.out.println(reverse(1534236469));
        System.out.println(reverse(324));
    }

    //    6. Zigzag Conversion
    public String convert(String s, int numRows) {
        if (numRows == 0 || s.length() <= numRows || (numRows < 2)) {
            return s;
        }
        String res = "";
        int between = numRows - 2;
        int numColumn = (s.length() / (numRows + between)) + (s.length() % (numRows + between) > 0 ? 1 : 0);

        for (int start = 0; start < numRows; start++) {
            int curr = 0;
            for (int col = 1; col <= numColumn; col++) {

                curr += col == 1 ? start : numRows + between;
                if (curr >= s.length()) {
                    break;
                }

                res += s.substring(curr, curr + 1);

                int btw = col * (numRows + between) - start;
//                if (between !=0 && !(start == 0 || start == numRows - 1 || col == numColumn) && btw > 0 && btw < s.length() - 1) {
                if (between != 0 && !(start == 0 || start == numRows - 1) && btw > 0 && btw < s.length()) {
                    res += s.substring(btw, btw + 1);
                }
            }
        }
        return res;
    }


    //    7. Reverse Integer
    public int reverse(int x) {

        int reverse = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            reverse = reverse * 10 + pop;
        }
        return reverse;
    }
}
