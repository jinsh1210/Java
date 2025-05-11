package toc.Dclasses.lambda.ex1;

public class LambdaEx1 {
    public static void main(String[] args) {

        //배열 -> 리스트 변경 방법
        //1
        /*
        int[] iArr = {9, 7, 3, 6, 1, 2, 5};
        List<Integer> iList = new ArrayList<>(List.of(9, 7, 3, 6, 1, 2, 5));*/
        //2
        /*
        Integer[] iArr = {9, 7, 3, 6, 1, 2, 5};
        List<Integer> list = Arrays.asList(iArr);*/
        //3
        /*
        int[] iArr = {9, 7, 3, 6, 1, 2, 5};
        IntStream.of(iArr).sorted().forEach(System.out::println);*/
        //4
        /*
        int[] iArr = {9, 7, 3, 6, 1, 2, 5};
        List<Integer> iList = Arrays.stream(iArr).boxed().toList();*/


        //함수로 정렬
        /*Collections.sort(iList);
        System.out.println(iList);*/

        //출력 방법
        /*
        for (Integer i : iList) {     //이 방법 잘 안 씀
            System.out.println(i);
        }
        iList.forEach(i->System.out.println(i));    //람다 표현식
        iList.forEach(System.out::println);   // 메소드 참조*/

        //뒤집는 방법
        /*Collections.reverse(iList);   //이게 더 유용
        Collections.sort(iList, Collections.reverseOrder());*/

        //정렬 방법
        /*Collections.sort(iList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        // 람다 표현식
        Collections.sort(iList, (o1, o2) -> o1.compareTo(o2));
        iList.forEach(x -> System.out.println(x));*/

        //끝판왕 한 줄
        /*iList.stream()
                .sorted()
                .map(x -> x * 2)
                .forEach(System.out::println);*/

    }
}
