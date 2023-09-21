import java.util.*;
class Sol1 {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
//        Map<Character,Integer> temp = new HashMap<>();
//        for(int i = 0;i<n;i++)
//            temp.put((char)(i+65),i+1);
////        System.out.println("-----------------");
////        temp.forEach((k,v)->System.out.println("key : "+k+" value : "+v));
////        System.out.println("-----------------");
//
//        for (int i = 0; i < ladder.length; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < ladder[i].length; k++) {
//                    if(ladder[i][k]==temp.get((char)(j+65)))
//                        temp.put((char)(j+65),temp.get((char)(j+65))+1);
//                    else if(ladder[i][k]+1==temp.get((char)(j+65)))
//                        temp.put((char)(j+65),temp.get((char)(j+65))-1);
//                }
//
//            }
//        }
//        int[] i = {0};
////        temp.forEach((k,v)->System.out.println("key : "+k+" value : "+v));
//        temp.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .forEach((k)-> {
//                            answer[i[0]] = k.getKey();
//                            i[0]++;
//                        }
//                );

        /**
         * 기존 풀이는 너무 시간이 걸리고 비효율적인 부분이 많다.
         * 단순하게 문자를 swap하는 방식으로 풀어보자
         */

        for (int i = 0; i < answer.length; i++)
            answer[i] = (char)(i+65);


        for (int[] ints : ladder)
            for (int j:ints){
                char temp = answer[j-1];
                answer[j-1] = answer[j];
                answer[j] = temp;
            }

        return answer;

        /**
         * 트러블 슈팅
         * Map에 넣는데 까지는 성공 근데 어떻게 정렬해서 로드하지?
         * 값을 기준으로 어떻게 정렬할까?
         * int i는 왜 람다 표현식 안에서 사용불가능하지?
         */
    }

    public static void main(String[] args){
        Sol1 T = new Sol1();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}