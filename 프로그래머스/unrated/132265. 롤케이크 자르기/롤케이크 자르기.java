class Solution {
    public int solution(int[] topping) {
        int answer = 0; // 방법 개수

        int[] arr1 = new int[topping.length + 1]; // 철수
        int[] arr2 = new int[topping.length + 1]; // 동생

        int cnt1 = 0; // 철수 토핑 개수
        int cnt2 = 0; // 동생 토핑 개수

        // 철수에게 전체 케이크 주기 + 케이크의 토핑 개수 파악
        for(int i=0; i<topping.length; i++) {
            if(arr1[topping[i]] == 0) {
                cnt1++;
            }
            arr1[topping[i]]++;
        }

        // 동생에게 토핑 나눠주기
        for(int i=0; i<topping.length; i++) {
            if(arr2[topping[i]] == 0) { // 기존에 없던 토핑이면
                cnt2++; // 동생 토핑 종류 개수 + 1
            }
            arr1[topping[i]]--; // 철수 토핑 개수 - 1
            arr2[topping[i]]++; // 동생 토핑 개수 - 1

            if(arr1[topping[i]] == 0) { // 철수의 해당 토핑 개수 0개면
                cnt1--; // 철수 토핑 종류 개수 - 1
            }

            if(cnt1 == cnt2) {
                answer++;
            }
        }
        return answer;
    }
}