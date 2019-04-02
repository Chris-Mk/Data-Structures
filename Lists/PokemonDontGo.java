package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Integer> pokemons = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = 0;

        while (pokemons.size() > 0) {
            int index = Integer.parseInt(scan.nextLine());
            int currentNumber;

            if (index < 0) {
                currentNumber = pokemons.get(0);
                pokemons.set(0, pokemons.get(pokemons.size() - 1));
            } else if (index >= pokemons.size()) {
                currentNumber = pokemons.get(pokemons.size() - 1);
                pokemons.set(pokemons.size() - 1, pokemons.get(0));
            } else {
                currentNumber = pokemons.get(index);
                pokemons.remove(index);
            }

            sum += currentNumber;
            manipulatePokemons(pokemons, currentNumber);
        }

        System.out.println(sum);
    }

    private static void manipulatePokemons(List<Integer> pokemons, int currentNumber) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i) <= currentNumber) {
                pokemons.set(i, pokemons.get(i) + currentNumber);
            } else {
                pokemons.set(i, pokemons.get(i) - currentNumber);
            }
        }
    }
}
