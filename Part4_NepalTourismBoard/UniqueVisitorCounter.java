import java.util.*;

class EmptyDataException extends DataProcessingException {
    public EmptyDataException(String message) {
        super(message);
    }
}

class UniqueVisitorCounter implements DataProcessor {

    @Override
    public List<String> process(List<String> rawData) throws DataProcessingException {

        if (rawData.isEmpty()) {
            throw new EmptyDataException("No raw data to process! Did all tourists go missing?");
        }

        // Set automatically ignores duplicate names
        Set<String> uniqueNames = new HashSet<>();

        for (String entry : rawData) {
            // Entries look like "Visitor: Name, Country" or
            // "Hotel: X, Guest: Name, Country" - so we search
            // for "Visitor:" or "Guest:" specifically rather than
            // just splitting on the first colon.
            String name = null;

            if (entry.contains("Visitor:")) {
                String afterVisitor = entry.substring(entry.indexOf("Visitor:") + "Visitor:".length()).trim();
                name = afterVisitor.split(",", 2)[0].trim();

            } else if (entry.contains("Guest:")) {
                String afterGuest = entry.substring(entry.indexOf("Guest:") + "Guest:".length()).trim();
                name = afterGuest.split(",", 2)[0].trim();
            }

            if (name != null && !name.isEmpty()) {
                uniqueNames.add(name);
            }
        }

        List<String> result = new ArrayList<>();
        result.add("Unique Visitors: " + uniqueNames.size());
        return result;
    }

    public static void main(String[] args) {

        UniqueVisitorCounter counter = new UniqueVisitorCounter();

        List<String> emptyData = new ArrayList<>();

        System.out.println("Test 1: Processing empty data...");
        try {
            List<String> result = counter.process(emptyData);
            System.out.println("Result: " + result);
        } catch (DataProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("------------------------------------------");

        List<String> sampleData = new ArrayList<>();
        sampleData.add("Visitor: John Doe, USA");
        sampleData.add("Visitor: Emily White, UK");
        sampleData.add("Visitor: John Doe, USA");
        sampleData.add("Hotel: Yak & Yeti, Guest: Ram Thapa, NP");
        sampleData.add("Hotel: Annapurna, Guest: Ram Thapa, NP");

        System.out.println("Test 2: Processing sample data...");
        try {
            List<String> result = counter.process(sampleData);
            System.out.println("Result: " + result);
        } catch (DataProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("------------------------------------------");
    }
}
