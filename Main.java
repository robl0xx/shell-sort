import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static int shellSort(int[] array){
        int iterationCount = 0;
        for (int step = array.length / 2; step > 0; step = step / 2){
            for (int pass = step; pass < array.length; pass++){
                for (int replacemant = pass - step; replacemant >= 0 && array[replacemant] > array[replacemant + step]; replacemant-= step){
                    int temp = array[replacemant];
                    array[replacemant] = array[replacemant + step];
                    array[replacemant + step] = temp;
                    iterationCount++;
                }
            }
        }
        return iterationCount;
    }

    public static void main(String[] args) throws IOException {
//        creatFileWithCountOfIterations();
//        creatFileWithCountOfTime();
    }

    public static void creatFileWithCountOfIterations() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data_count_of_iterations.txt"));
        for (int i = 1; i < 101; i++) {
            int[] currentArray = ReadNumbersFromFile(i);
            int countOfIterations = shellSort(currentArray);
            writer.write(Integer.toString(currentArray.length) + " " +Integer.toString(countOfIterations));
            writer.newLine();
        }
        writer.close();

    }

    private static void creatFileWithCountOfTime() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data_count_of_time.txt"));
        for (int i = 1; i < 101; i++) {
            int[] currentArray = ReadNumbersFromFile(i);
            long startTime = System.nanoTime();
            shellSort(currentArray);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            writer.write(Integer.toString(currentArray.length) + " " +Long.toString(duration));
            writer.newLine();
        }
        writer.close();
    }

    public static int[] ReadNumbersFromFile(int numberOfFile) {
            String fileName = "data_set_" +numberOfFile+".txt";// Имя файла для чтения данных
            ArrayList<Integer> numbers = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    try {
                        int number = Integer.parseInt(line);
                        numbers.add(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing number: " + line);
                    }
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }

            // Преобразование списка чисел в массив int
            int[] numbersArray = new int[numbers.size()];
            for (int i = 0; i < numbers.size(); i++) {
                numbersArray[i] = numbers.get(i);
            }

            return numbersArray;
        }

//    public static class GenerateRandomDataSets {
//
//        private static final int NUM_DATA_SETS = 100; // Количество наборов данных
//        private static final int MIN_SIZE = 100; // Минимальный размер набора
//        private static final int MAX_SIZE = 10000; // Максимальный размер набора
//
//        public static void main(String[] args) {
//            for (int i = 1; i <= NUM_DATA_SETS; i++) {
//                int dataSize = generateRandomNumberInRange(MIN_SIZE, MAX_SIZE);
//                int[] data = generateRandomData(dataSize);
//
//                try {
//                    BufferedWriter writer = new BufferedWriter(new FileWriter("data_set_" + i + ".txt"));
//                    for (int num : data) {
//                        writer.write(Integer.toString(num));
//                        writer.newLine();
//                    }
//                    writer.close();
//                } catch (IOException e) {
//                    System.out.println("An error occurred while writing to the file.");
//                    e.printStackTrace();
//                }
//            }
//
//            System.out.println("Random data sets have been generated and written to files.");
//        }
//
//        private static int generateRandomNumberInRange(int min, int max) {
//            Random random = new Random();
//            return random.nextInt(max - min + 1) + min;
//        }
//
//        private static int[] generateRandomData(int size) {
//            int[] data = new int[size];
//            Random random = new Random();
//            for (int i = 0; i < size; i++) {
//                data[i] = random.nextInt(1000); // Генерация случайного числа от 0 до 999
//            }
//            return data;
//        }
//    }

}

