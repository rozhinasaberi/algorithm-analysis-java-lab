package com.exercise2.rojina.saberi;

public class Exercise2 {

    // 301533334
    //  Rojina Saberi

    // make an array with all different numbers 
    private static int[] makeArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        return a;
    }

    private static long timeUnique1(int n) {
        int[] a = makeArray(n);
        long start = System.nanoTime();
        Uniqueness.unique1(a);
        long end = System.nanoTime();
        return end - start;
    }

    private static long timeUnique2(int n) {
        int[] a = makeArray(n);
  
        for (int i = 0; i < n / 2; i++) {
            int tmp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = tmp;
        }

        long start = System.nanoTime();
        Uniqueness.unique2(a);
        long end = System.nanoTime();
        return end - start;
    }

    // Find max n using "binary search" 
    private static int findMaxN(boolean useUnique1) {
        long limit = 60L * 1_000_000_000L; //nanoseconds

        int low = 1;
        int high = 1000;

       
        while (true) {
            long t = useUnique1 ? timeUnique1(high) : timeUnique2(high);
            System.out.println((useUnique1 ? "unique1" : "unique2") +
                    " n=" + high + " time=" + (t / 1e9) + " sec");

            if (t > limit) break;

            low = high;
            high = high * 2;

         
            if (useUnique1 && high > 200000) break;
            if (!useUnique1 && high > 50000000) break;
        }

        //binary search between low & high
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            long t = useUnique1 ? timeUnique1(mid) : timeUnique2(mid);

            System.out.println((useUnique1 ? "unique1" : "unique2") +
                    " n=" + mid + " time=" + (t / 1e9) + " sec");

            if (t <= limit) {
                low = mid;   
            } else {
                high = mid;  
            }
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println("Finding max n for unique1 (<= 60 sec)...");
        int max1 = findMaxN(true);
        System.out.println("MAX n for unique1 under 1 minute: " + max1);

        System.out.println();

        System.out.println("Finding max n for unique2 (<= 60 sec)...");
        int max2 = findMaxN(false);
        System.out.println("MAX n for unique2 under 1 minute: " + max2);
    }
}
