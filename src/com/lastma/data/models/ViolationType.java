package com.lastma.data.models;

public enum ViolationType {
    TRAFFIC_CONTROL_VIOLATION(2, 20_000, 30_000),
    ILLEGAL_PARKING(4, 20_000, 30_000),
    LINE_VIOLATION(4,20_000, 30_000),
    OFFSIDE_RULE_VIOLATION(3, 20_000, 30_000),
    ZEBRA_CROSSING_VIOLATION(3, 20_000, 30_000),
    ROUNDABOUT_VIOLATION(2, 20_000, 30_000),
    MIRROR_LIGHT_VIOLATION(2, 20_000, 30_000),
    TAILGATING_EMERGENCY_VIOLATION(3, 20_000, 30_000),
    ILLEGAL_U_TURN(3, 20_000, 30_000),
    DRIVING_ON_WALKWAY(4, 50_000),
    PARKING_ON_WALKWAY(3, 20_000),
    ABANDONED_VEHICLE_ON_HIGHWAY(2, 50_000),
    HIGHWAY_OBSTRUCTION(3, 25_000),
    USE_OF_PHONE_CALL(2, 20_000, 30_000),
    USE_OF_PHONE_TEXT(2, 20_000, 30_000),
    SEATBELT_VIOLATION(2, 20_000, 30_000),
    REFLECTIVE_WARNING(3, 20_000, 30_000),
    RESISTING_ARREST(2, 20_000, 30_000),
    BRT_LANE_VIOLATION(3, 20_000, 30_000),
    ROUTE_VIOLATION(3, 50_000),
    DRIVING_UNDER_INFLUENCE(3, 100_000),
    TRAFFIC_LIGHT_VIOLATION(2, 10_000),

    ;
    private int point;
    private double firsTimeOffenderAmount;
    private double secondTimeOffenderAmount;
    ViolationType(int point, double firstTimeOffenderAmount, double subsequentOffenderAmount) {
            this.point = point;
            this.firsTimeOffenderAmount = firstTimeOffenderAmount;
            this.secondTimeOffenderAmount = subsequentOffenderAmount;
    }
    ViolationType(int point, double firstTimeOffenderAmount) {
        this.point = point;
        this.firsTimeOffenderAmount = firstTimeOffenderAmount;
    }


}
