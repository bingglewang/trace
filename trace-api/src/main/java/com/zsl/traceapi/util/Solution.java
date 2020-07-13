package com.zsl.traceapi.util;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static long[][] intervalIntersection(long[][] A, long[][] B) {
        List<long[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            long lo = Math.max(A[i][0], B[j][0]);
            long hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi){
                ans.add(new long[]{lo, hi});
            }

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1]){
                i++;
            }
            else{
                j++;
            }

        }

        return ans.toArray(new long[ans.size()][]);
    }
}
