class Sorting {
    public static void printArray(int[] arr){
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        // return;
    }

    public static int[] insertionSort(int[] arr,int order){
        for(int i=1;i< arr.length;i++){
            int key = arr[i];
            int j = i-1;

            if(order == 0){
                while(j >= 0 && key < arr[j]){
                    arr[j+1] = arr[j];
                    --j;
                }
            }else{
                while(j >= 0 && key > arr[j]){
                    arr[j+1] = arr[j];
                    --j;
                }
            }

            arr[j+1] = key;
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr,int order){
        for(int i= 0; i < arr.length; i++){
            for(int j= 0; j < arr.length-i-1; j++){
                int crnt = arr[j];
                int front = arr[j+1];

                if(order == 1){
                    if(crnt > front){
                        arr[j] = front;
                        arr[j+1] = crnt;
                    }
                }else{
                    if(crnt < front){
                        arr[j] = front;
                        arr[j+1] = crnt;
                    }
                }
            }
        }

        return arr;
    }

    public static int[] selectionSort(int[] arr, int order){
        for(int i=0;i<arr.length;i++){
            int min_index = i;

            for(int j=i;j<arr.length;j++){
                if(order == 0){
                    if(arr[min_index] > arr[j]){
                        min_index = j;
                    }
                }else{
                    if(arr[min_index] < arr[j]){
                        min_index = j;
                    }
                }
            }

            if(min_index != i){
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
    
    public static void main(String[] args){
        int[] arr = {4,1,0,48,0,21,84,23};
        int[] sortedArr = insertionSort(arr,1);
        printArray(sortedArr);

        
    }
}
