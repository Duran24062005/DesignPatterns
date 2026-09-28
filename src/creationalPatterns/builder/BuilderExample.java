public class BuilderExample {

    static class Report {
        private final String title;
        private final String author;
        private final boolean includeCharts;
        private final boolean includeSummary;

        private Report(Builder builder) {
            this.title = builder.title;
            this.author = builder.author;
            this.includeCharts = builder.includeCharts;
            this.includeSummary = builder.includeSummary;
        }

        @Override
        public String toString() {
            return "Report{" + "title='" + title + '\''
                    + ", author='" + author + '\''
                    + ", includeCharts=" + includeCharts
                    + ", includeSummary=" + includeSummary + '}';
        }
    }

    static class Builder {
        private String title;
        private String author;
        private boolean includeCharts;
        private boolean includeSummary;

        Builder withTitle(String title) { this.title = title; return this; }
        Builder withAuthor(String author) { this.author = author; return this; }
        Builder withCharts() { this.includeCharts = true; return this; }
        Builder withSummary() { this.includeSummary = true; return this; }

        Report build() {
            if (title == null || title.isBlank()) {
                throw new IllegalStateException("A report must have a title");
            }
            if (author == null || author.isBlank()) {
                throw new IllegalStateException("A report must have an author");
            }
            return new Report(this);
        }
    }

    public static void main(String[] args) {
        Report report = new Builder()
                .withTitle("Monthly sales")
                .withAuthor("Analytics team")
                .withCharts()
                .withSummary()
                .build();

        System.out.println(report);
    }
}
