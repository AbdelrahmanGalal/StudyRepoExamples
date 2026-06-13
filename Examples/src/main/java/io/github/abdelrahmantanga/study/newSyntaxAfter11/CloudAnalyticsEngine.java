package io.github.abdelrahmantanga.study.newSyntaxAfter11;

/**
 * GOAL: Refactor the Cloud Log Engine to handle Nested Record Patterns.
 * <p>
 * CHALLENGE:
 * Unpack inner records directly inside the switch pattern matching.
 * Use the unnamed pattern (_) to ignore nested components you don't need.
 */
public class CloudAnalyticsEngine {

    // =========================================================================
    // STEP 1: INNER META RECORDS
    // =========================================================================
    // The user or system component that triggered the event
    public record Actor(String name, String type) {
    } // type could be "USER", "SYSTEM", "BOT"

    // Geographical or technical origin data
    public record Context(String ipAddress, String region) {
    }

    // =========================================================================
    // STEP 2: REFACTORED SEALED HIERARCHY
    // =========================================================================
    public sealed interface CloudEvent permits Login, DataAccess, Failure {
        String eventId();
    }

    // Notice the nested Actor and Context records below!
    public record Login(String eventId, Actor actor, Context context) implements CloudEvent {
    }

    public record DataAccess(String eventId, Actor actor, String resourceName, int bytesTransferred,
                             int securityRiskScore) implements CloudEvent {
    }

    public record Failure(String eventId, String componentName, String errorCode) implements CloudEvent {
    }


    public enum AlertLevel {NONE, LOG, PAGE_DEVOPS, BLOCK_ACCOUNT}

    // =========================================================================
    // YOUR TURN: IMPLEMENT THIS METHOD USING NESTED PATTERNS
    // =========================================================================

    /**
     * RULES TO IMPLEMENT WITH NESTED PATTERN MATCHING:
     * <p>
     * 1. Login: If the Actor's type is "BOT", return LOG.
     * Otherwise, print: "User [name] logged in from [region]" and return NONE.
     * (Extract only 'name' from Actor, and 'region' from Context using nested patterns).
     * <p>
     * 2. DataAccess: If the risk score > 8 AND the Actor's type is "USER", return BLOCK_ACCOUNT.
     * If bytesTransferred > 10_000_000, return LOG.
     * Otherwise, return NONE.
     * <p>
     * 3. Failure: Keep the same logic as before (If "FATAL" -> PAGE_DEVOPS, else LOG).
     */
    public static AlertLevel processEvent(CloudEvent event) {
        return switch (event) {
            case Login(_, Actor(_, String type), _) when type.equals("BOT") -> AlertLevel.LOG;
            case Login(_, Actor(String name, _), Context(_, String region)) -> {
                System.out.println("User " + name + " logged in from " + region);
                yield AlertLevel.NONE;
            }
            case DataAccess(_, Actor(_, String type), _, _, int riskScore) when type.equals("USER") && riskScore > 8 ->
                    AlertLevel.BLOCK_ACCOUNT;
            case DataAccess(_,_,_,int bytesTransferred,_) when bytesTransferred > 10_000_000 -> AlertLevel.LOG;
            case DataAccess(_,_,_,_,_) -> AlertLevel.NONE;
            case Failure(_,_, String errorCode) when errorCode.equals("FATAL") -> AlertLevel.PAGE_DEVOPS;
            case Failure(_,_,_) -> AlertLevel.LOG;
        };
    }

    // =========================================================================
    // VERIFICATION MECHANISM
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("--- Cloud Nested Analytics Test Sandbox ---");

        Actor userActor = new Actor("admin", "USER");
        Actor botActor = new Actor("scraper-9000", "BOT");
        Context ctx = new Context("192.168.1.50", "US-East");

        CloudEvent botLogin = new Login("EVT-001", botActor, ctx);
        CloudEvent userLogin = new Login("EVT-002", userActor, ctx);
        CloudEvent riskyAccess = new DataAccess("EVT-003", userActor, "db_prod", 500, 9);
        CloudEvent heavyAccess = new DataAccess("EVT-004", botActor, "assets_public", 25_000_000, 2);
        CloudEvent criticalFail = new Failure("EVT-005", "AuthService", "FATAL");

        System.out.println("Bot Login: " + processEvent(botLogin));       // Expected: LOG
        System.out.println("User Login: " + processEvent(userLogin));     // Expected: Print message + NONE
        System.out.println("Risky Access: " + processEvent(riskyAccess)); // Expected: BLOCK_ACCOUNT
        System.out.println("Heavy Access: " + processEvent(heavyAccess)); // Expected: LOG
        System.out.println("Critical Fail: " + processEvent(criticalFail)); // Expected: PAGE_DEVOPS
    }
}
