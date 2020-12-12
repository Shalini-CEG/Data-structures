package hashing;

import java.util.Set;

public class HashSet {
    public static void main(String[] args) {
        Set<Integer> rateOfFruits = new java.util.HashSet<Integer>();
        Set<Integer> rateOfSweets = new java.util.HashSet<Integer>();
        Set<Integer> rate = new java.util.HashSet<Integer>();

        rateOfFruits.add(5);
        rateOfFruits.add(50);
        rateOfFruits.add(55);

        rateOfSweets.add(55);

//        1. Union
        rate.addAll(rateOfFruits);
        rate.addAll(rateOfSweets);
        System.out.println("Union of two sets: "+ rate);

//        2. Subset
        System.out.println( "A contains B: " + rateOfFruits.containsAll(rateOfSweets) );

//        3. Length of HashSet
        System.out.println("Length of the set is: " + rateOfFruits.size());

//        4. Intersection
        rateOfFruits.retainAll(rateOfSweets);
        System.out.println( "Intersection of two sets: " +  rateOfFruits);
        
    }
}
