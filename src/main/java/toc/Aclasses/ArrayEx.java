package toc.Aclasses;

public class ArrayEx {
    public static void main(String[] args) {
        int[] aArr = {1, 2, 3, 4};

        int a = 1;
        aArr[0] = a;

        printArray(aArr);

        System.out.println();
        int[] xArr = addArray(aArr, 3);

        xArr[1]=100;

        System.out.println();
        printArray(xArr);

    }

    private static int[] addArray(int[] bArr, int num) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] += num;
        }
        printArray(bArr);
        return bArr;
    }

    private static void printArray(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            System.out.print(intArr[i] + " ");
        }
    }

    //refactoring으로 함수 생성
    //함수 생성 시 함수 명 = 동사+명사 ex) printArray, playSong
}