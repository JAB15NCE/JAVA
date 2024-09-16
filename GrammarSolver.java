import java.util.*;


/**
 * 
 */
public class GrammarSolver {

    private SortedMap<String, List<String>> symbols;
    private Random random;

    /**
     * 
     * @param grammars
     */
    public GrammarSolver(List<String> grammars) {
        if (grammars.isEmpty()) {
            throw new IllegalArgumentException();
        }

        symbols = new TreeMap<>();
        for (String grammar : grammars) {
            String[] grammarChunks = grammar.split(":");
            String symbol = grammarChunks[0];
            symbol.replaceAll("<", "");
            symbol.replaceAll(">", "");

            if (symbols.containsKey(symbol))
                throw new IllegalArgumentException();

            List<String> rules = new ArrayList<>();
            for (String rule : grammarChunks[1].split("[|]")) {
                rules.add(rule);
                // System.out.println(rule);
            }

            symbols.put(symbol, rules);
        }

        random = new Random();

    }

    /**
     * 
     * @param symbol
     * @return
     */
    public boolean grammarContains(String symbol) {
        return symbols.containsKey(symbol);
    }

    /**
     * 
     * @param symbol
     * @param requestedNumberOfResults
     * @return
     */
    public String[] generate(String symbol, int requestedNumberOfResults) {
        if (!grammarContains(symbol) || requestedNumberOfResults < 0)
            throw new IllegalArgumentException();

        String[] grammarString = new String[requestedNumberOfResults];

        for (int i = 0; i < requestedNumberOfResults; i++)
            grammarString[i] = generate(symbol);

        return grammarString;
    }

    /**
     * 
     * @param symbol
     * @return
     */
    private String generate(String symbol) {
        if (!grammarContains(symbol))
            throw new IllegalArgumentException();

        String res = "";
        List<String> rules = symbols.get(symbol);
        String randomRule = rules.get(random.nextInt(rules.size()));
        // System.out.println(randomRule);
        String[] ruleElements = randomRule.split("[ \t]+");

        for (String element : ruleElements) {
            // System.out.println(element);
            if (!res.isEmpty())
                res += " ";
            if (grammarContains(element))
                res += generate(element);
            else
                res += element;
        }

        return res;

    }

    /**
     * 
     * @return
     */
    public String getSymbols() {
        String res = "";
        
        for (String symbol : symbols.keySet()) {
            if (res.isEmpty())
                res = "[";
            else
                res += ", ";
            res += symbol;
        }

        res += "]";

        return res;

    }

}