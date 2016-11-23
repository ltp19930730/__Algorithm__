*/
public int[] intersection(int[] nums1, int[] nums2) {
   // Write your code here
   // if (nums1 == null || nums2 == null ||
   //     nums1.length == 0 || nums2.length == 0){
   //   return null;
   // }
   // Arrays.sort(nums1);
   // Arrays.sort(nums2);

   // int i = 0;
   // int j = 0;
   // HashSet<Integer> set = new HashSet<>();
   // while (i < nums1.length && j < nums2.length){
   //     if (nums1[i] < nums2[j]){
   //         i++;
   //     }else if (nums1[i] > nums2[j]){
   //         j++;
   //     }else{
   //         set.add(nums1[i]);
   //         i++;
   //         j++;
   //     }
   // }
   // int[] result = new int[set.size()];
   // Iterator it = set.iterator();
   // int k = 0;
   // while (it.hasNext()){
   //     result[k] = Integer.parseInt(it.next().toString());
   //     k++;
   // }
   // return result;
   // two hashset 
   if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
       return new int[0];
   }
   HashSet<Integer> set1 = new HashSet<>();
   for (int i = 0; i < nums1.length; i++){
       set1.add(nums1[i]);
   }

   HashSet<Integer> set2 = new HashSet<>();
   for (int i = 0; i < nums2.length; i++){
       if (set1.contains(nums2[i])){
           set2.add(nums2[i]);
       }
   }
   int[] result = new int[set2.size()];
   int index = 0;
   for (Integer num : set2){
       result[index++] = num;
   }
   return result;
}
}
