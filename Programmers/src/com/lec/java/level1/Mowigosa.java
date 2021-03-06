package com.lec.java.level1;

import java.util.ArrayList;

//완전탐색 - 모의고사
public class Mowigosa {

	public static void main(String[] args) {
		int[] answer = { 1,3,3,2,3,6 };
		int[] answers = {};
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[] cnt = { 0, 0, 0 };

		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == a[i % 5]) {
				cnt[0]++;
			}
			if (answer[i] == b[i % 8]) {
				cnt[1]++;
			}
			if (answer[i] == c[i % 10]) {
				cnt[2]++;
			}
		}
		ArrayList<Integer> set = new ArrayList<Integer>();

			int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

			if (max > 0) {
				if (max == cnt[0]) {
					set.add(1);
					cnt[0] = 0;
				}
				if (max == cnt[1]) {
					set.add(2);
					cnt[1] = 0;
				}
				if (max == cnt[2]) {
					set.add(3);
					cnt[2] = 0;
				}
			}

			
		answers = new int[set.size()];

		for (int i = 0; i < set.size(); i++) {
			answers[i] = set.get(i);
		}

	}// end main

}// end class
