public class Java2DzLesson5 extends Thread {

    @Override
    public void run(){
        mathThread();
    }

    static final int size = 10000000;
    static final int h = size / 2;

    private void mathArr(float[] arr){
        long a = System.currentTimeMillis();
        for (int k = 0; k < arr.length; k++){
            arr[k] = (float)(arr[k] * Math.sin(0.2f + k / 5) * Math.cos(0.2f + k / 5) * Math.cos(0.4f + k / 2));
            //System.out.println("1 " + arr[k]);

        }
        System.out.println("Время расчета масства одним потоком " + (System.currentTimeMillis() - a) + " мс");

    }

    public void mathThread(){
        float[] arrrr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for (int i = 0; i < arrrr.length; i++){
            arrrr[i] = 1;
        }
        long bb = System.currentTimeMillis();
        System.arraycopy(arrrr, 0, a1, 0, h);
        System.arraycopy(arrrr, h, a2, 0, h);
        for (int i = 0; i < a1.length; i++){
            a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            //System.out.println("3 " + a1[i]);
        }

        for (int j = 0; j < a2.length; j++){
            a2[j] = (float)(a2[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            //System.out.println("4 " + a2[j]);
        }

        System.arraycopy(a1, 0, arrrr, 0, h);
        System.arraycopy(a2, 0, arrrr, h, h);
        System.out.println("Время расчета масства двумя потоками " + (System.currentTimeMillis() - bb) + " мс");
//        for (int i = 0; i < arrrr.length; i++){
//            System.out.println("2 " + arrrr[i]);
//
//        }
    }

    public static void main (String[] args){
        Java2DzLesson5 aa = new Java2DzLesson5();
        long timework = 0;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        //Время вычисления в массиве одним потоком
        aa.mathArr(arr);

        //Время вычисления в массиве двумя потоками
        Java2DzLesson5 thread1 = new Java2DzLesson5();
        thread1.start();

        Java2DzLesson5 thread2 = new Java2DzLesson5();
        thread2.start();

    }
}
