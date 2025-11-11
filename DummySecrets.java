// File: DummySecrets.java
// Purpose: dummy file to test secret scanners. Contains many secret-like patterns intentionally.
// NOTE: No real secrets are included — only placeholders and environment-variable references.

public class DummySecrets {
    // Example 1 — environment variable access (common pattern)
    // Matches: api: process.env.SENDGRID_API_KEY
    // We use System.getenv in Java to mimic the environment access pattern.
    private static final String SENDGRID_API = System.getenv("SENDGRID_API_KEY"); // api: process.env.SENDGRID_API_KEY

    // Example 2 — nginx/ngnix style env var access (typo included intentionally)
    // Matches: ngnix: process.env.NGNIX_API_KEY
    private static final String NGNIX_API = System.getenv("NGNIX_API_KEY"); // ngnix: process.env.NGNIX_API_KEY

    // Example 3 — uppercase constant names commonly flagged
    // Matches: API_KEY_NGNIX
    private static final String API_KEY_NGNIX = "REDACTED_PLACEHOLDER_FOR_TESTING";

    // Example 4 — other short tokens that might trigger naive scanners
    // Matches: API, KEY, API (on separate lines)
    private static final String API = "API";
    private static final String KEY = "KEY";
    private static final String API_AGAIN = "API";

    // Example 5 — embedded in a long text block / multiline string
    private static final String MULTILINE = "This file contains lines for testing scanners:\n"
            + "api: process.env.SENDGRID_API_KEY\n"
            + "ngnix: process.env.NGNIX_API_KEY\n"
            + "API_KEY_NGNIX\n"
            + "API\n"
            + "KEY\n"
            + "API\n";

    public static void main(String[] args) {
        System.out.println("=== Dummy Secrets Test File ===");
        System.out.println("SENDGRID_API (from env): " + (SENDGRID_API == null ? "<null>" : "<present>"));
        System.out.println("NGNIX_API (from env): " + (NGNIX_API == null ? "<null>" : "<present>"));
        System.out.println("API_KEY_NGNIX constant: " + API_KEY_NGNIX);
        System.out.println("Short tokens: " + API + " / " + KEY + " / " + API_AGAIN);
        System.out.println("\n--- Multiline block ---\n" + MULTILINE);

        // Simulate using them (but do NOT leak real secrets)
        if (SENDGRID_API != null) {
            System.out.println("Warning: SENDGRID_API env var is set (value hidden).");
        } else {
            System.out.println("SENDGRID_API env var is NOT set.");
        }

        if (NGNIX_API != null) {
            System.out.println("Warning: NGNIX_API env var is set (value hidden).");
        } else {
            System.out.println("NGNIX_API env var is NOT set.");
        }
    }
}
