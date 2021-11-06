package uteco;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class _3 {

    @Test
    public void main() {
        solution(
            new String[] {
                "r 10", "a 23", "t 124", "k 9"
            },
            new String[] {
                "PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45",
                "JUICE rra 55", "WATER a 20"
            },
            new String[] {
                "BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"
            }
        );

        solution(
            new String[] {
                "x 25", "y 20", "z 1000"
            },
            new String[] {
                "AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"
            },
            new String[] {
                "BBBB 3", "TTT 2"
            }
        );
    }

    public int solution(String[] ings, String[] menu, String[] sell) {
        IngPrice ingPriceMap = new IngPrice();
        ingPriceMap.addAll(ings);

        MenuInfo menuInfoMap = new MenuInfo(ingPriceMap);
        menuInfoMap.addAll(menu);

        return calculateIncome(sell, menuInfoMap);
    }

    private class MenuInfo {

        private Map<String, Price> map;
        private IngPrice IngPriceMap;

        public MenuInfo(IngPrice IngPriceMap) {
            this.IngPriceMap = IngPriceMap;
            this.map = new HashMap<>();
        }

        public void addAll(String[] menus) {
            for (String menu : menus) {
                add(menu);
            }
        }

        public void add(String menu) {
            StringTokenizer st = new StringTokenizer(menu);
            String name = st.nextToken();
            String needIngs = st.nextToken();
            int makePrice = calculateMakePrice(needIngs);
            int sellPrice = Integer.parseInt(st.nextToken());
            map.put(name, new Price(makePrice, sellPrice));
        }

        private int calculateMakePrice(String ingNames) {
            int price = 0;
            for (char ing : ingNames.toCharArray()) {
                price += this.IngPriceMap.getPrice(ing);
            }
            return price;
        }

        public int sell(String menu) {
            return map.get(menu).calculateIncome();
        }

        private class Price {

            private int makePrice;
            private int sellPrice;

            public Price(int makePrice, int sellPrice) {
                this.makePrice = makePrice;
                this.sellPrice = sellPrice;
            }

            private int calculateIncome() {
                return sellPrice - makePrice;
            }

        }
    }

    private class IngPrice {

        private Map<Character, Integer> map;

        public IngPrice() {
            map = new HashMap<>();
        }

        public void addAll(String[] ings) {
            for (String ing : ings) {
                add(ing);
            }
        }

        public void add(String ing) {
            StringTokenizer st = new StringTokenizer(ing);
            char name = st.nextToken().charAt(0);
            int price = Integer.parseInt(st.nextToken());
            map.put(name, price);
        }

        public int getPrice(Character ing) {
            return map.get(ing);
        }

    }

    private int calculateIncome(String[] soldItems, MenuInfo menuInfoMap) {
        int income = 0;
        for (String item : soldItems) {
            StringTokenizer st = new StringTokenizer(item);
            String menu2 = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            income += menuInfoMap.sell(menu2) * count;
        }
        return income;
    }
}
