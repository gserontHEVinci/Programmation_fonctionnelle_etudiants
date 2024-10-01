package main;

import domaine.Employe;
import domaine.Genre;

import java.util.*;
import java.util.stream.Collectors;

public class ExempleCoursTh {
    public static void main(String[] args) {


        List<Employe> employes = new ArrayList<Employe>();
        employes.add( new Employe(Genre.FEMME, 157, "Sarah"));
        employes.add(new Employe(Genre.FEMME, 168, "Sophia"));
        employes.add(new Employe(Genre.HOMME, 169, "James"));
        employes.add(new Employe(Genre.HOMME, 190, "Jack"));
        employes.add(new Employe(Genre.FEMME, 171, "Jane"));
        employes.add(new Employe(Genre.HOMME, 172, "Jill"));
        employes.add(new Employe(Genre.FEMME, 173, "Jilly"));


        double tailleMoyenneDesHommes = employes
                .stream()
                .filter(e -> e.getGenre() == Genre.HOMME)
                .peek(e -> System.out.println("Après filtre" + e.getGenre()))
                .mapToInt(e -> e.getTaille())
                .peek(System.out::println)
                .average()
                .orElse(0.0);

        System.out.println("Taille moyenne = " + tailleMoyenneDesHommes);


        // Reduce
        List<Integer> numbers = Arrays.asList(3,4,5,1,2,-5);
        Optional<Integer> sum = numbers.stream().reduce( Integer::sum);
        if (sum.isPresent()) {
            System.out.println(sum.get());
        }

        // Group by
        Map<Genre, List<Employe>> genreToListMap = new HashMap<>();
        for (Employe employee : employes) {
            if (!genreToListMap.containsKey(employee.getGenre())) {
                genreToListMap.put(employee.getGenre(), new ArrayList<>());
            }
            genreToListMap.get( employee.getGenre() ).add(employee);
        }
        // Inférence de type à la compilation
        var map2 = employes.stream().collect(Collectors.groupingBy(employee -> employee.getGenre( )));


        // Itérer et référence de méthode
        var s = employes
                .stream()
                .filter(e -> {
                    if (e.getGenre() == Genre.FEMME)
                        return true;
                    else
                        return false;
                } );

        s.forEach(e -> System.out.println(e));
        s.forEach(System.out::println);

        // Lambda avec un corps plus complexe











    }


}
