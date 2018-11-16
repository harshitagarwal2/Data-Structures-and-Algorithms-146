package models;


import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class BucketSortModel {
	
	public static void sort(ArrayList<WebURLModel> array) {
        if (array.size() == 0) return;  // empty check

        // Determine max length
        int max = array.get(0).getURL().length();
        for (int i = 1; i < array.size(); i++) {
            // update max length
            if (max < array.get(i).getURL().length()) max = array.get(i).getURL().length();
        }


        // Initialize buckets
        int bucketCount = 26;   // alphabet
        // buckets in maps
        HashMap<Character, ArrayList<WebURLModel>> buckets = new HashMap<Character, ArrayList<WebURLModel>>(bucketCount);
        // create the buckets
        char a = 'a';
        for (int i = 0; i <= bucketCount; i++, a++){
            buckets.put(a, new ArrayList<WebURLModel>());
        }   

        // assign array values into buckets
        for (int i = 0; i < array.size(); i++) {
            // get first letter of word
            String current = array.get(i).getURL();
            char letter = current.toLowerCase().charAt(0);
            buckets.get(letter).add(array.get(i));
        }

        // Sort buckets and place back into input array
        int index = 0;  // keeps global array index
        for (char key = 'a'; key <= 'z'; key++) {
            // retrieve the bucker
            ArrayList<WebURLModel> bucket = buckets.get(key);

            // do an insertion sort on bucket
            for (int i = 1; i < bucket.size(); i++){
                // i starts as 1, as a list of size 1 is already sorted

                // save the value at the index and remove it
                WebURLModel temp = bucket.get(i);
                bucket.remove(i);

                // move all values one up, until we find the saved value's location
                int j;
                for(j = i-1; j >= 0 && 
                        bucket.get(j).getURL().compareToIgnoreCase(temp.getURL()) > 0; j--){
                    // to "insert", we need to add and remove
                    bucket.add(j+1, bucket.get(j));
                    bucket.remove(j);
                }
                // place the saved value in the proper location
                bucket.add(j+1, temp);
            }


            // pile the current bucket back into array
            for (int j = 0; j < bucket.size(); j++) {
                array.set(index++,bucket.get(j));
            }
        }
    }
	
}
