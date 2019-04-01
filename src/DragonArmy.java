import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Set<String>> typesAndNames = new LinkedHashMap<>();
        Map<String, Integer> namesAndHealth = new TreeMap<>();
        Map<String, Integer> namesAndDamage = new TreeMap<>();
        Map<String, Integer> namesAndArmor = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] dragon = scan.nextLine().split("\\s");

            String type = dragon[0];
            String name = dragon[1];
            String damage = dragon[2];
            String health = dragon[3];
            String armor = dragon[4];

            int numDamage;
            if (damage.equals("null")) {
                numDamage = 45;
            } else {
                numDamage = Integer.parseInt(damage);
            }

            int numHealth;
            if (health.equals("null")) {
                numHealth = 250;
            } else {
                numHealth = Integer.parseInt(health);
            }

            int numArmor;
            if (armor.equals("null")) {
                numArmor = 10;
            } else {
                numArmor = Integer.parseInt(armor);
            }

            if (!typesAndNames.containsKey(type)) {
                typesAndNames.put(type, new TreeSet<>());
                typesAndNames.get(type).add(name);
                namesAndHealth.put(name, numHealth);
                namesAndDamage.put(name, numDamage);
                namesAndArmor.put(name, numArmor);
            } else {
                if (typesAndNames.get(type).contains(name)) {
                    namesAndHealth.remove(name);
                    namesAndDamage.remove(name);
                    namesAndArmor.remove(name);
                    namesAndHealth.put(name, numHealth);
                    namesAndDamage.put(name, numDamage);
                    namesAndArmor.put(name, numArmor);
                } else {
                    typesAndNames.get(type).add(name);
                    namesAndHealth.put(name, numHealth);
                    namesAndDamage.put(name, numDamage);
                    namesAndArmor.put(name, numArmor);
                }
            }
        }

        for (var type : typesAndNames.entrySet()) {
            double avgHealth = 0d;
            int healthCount = 0;
            for (var health : namesAndHealth.entrySet()) {
                if (type.getValue().contains(health.getKey())) {
                    avgHealth += health.getValue();
                    healthCount++;
                }
            }

            double avgDamage = 0d;
            int damageCount = 0;
            for (var damage : namesAndDamage.entrySet()) {
                if (type.getValue().contains(damage.getKey())) {
                    avgDamage += damage.getValue();
                    damageCount++;
                }
            }

            double avgArmor = 0d;
            int armorCount = 0;
            for (var armor : namesAndArmor.entrySet()) {
                if (type.getValue().contains(armor.getKey())) {
                    avgArmor += armor.getValue();
                    armorCount++;
                }
            }

            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",
                    type.getKey(),
                    avgDamage / damageCount,
                    avgHealth / healthCount,
                    avgArmor / armorCount));

            for (String value : type.getValue()) {
                System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d",
                        value,
                        namesAndDamage.get(value),
                        namesAndHealth.get(value),
                        namesAndArmor.get(value)));

            }
        }
    }
}
