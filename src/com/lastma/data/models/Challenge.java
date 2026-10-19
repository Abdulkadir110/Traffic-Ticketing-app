package com.lastma.data.models;

import java.util.Date;

public class Challenge {
    private int id;
    private int ticketId;
    private String reason;
    private String status;
    private String decisionNotes;
    private int reviewedByOfficerId;
    private Date submittedAt;
    private Date reviewedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDecisionNotes() {
        return decisionNotes;
    }

    public void setDecisionNotes(String decisionNotes) {
        this.decisionNotes = decisionNotes;
    }

    public int getReviewedByOfficerId() {
        return reviewedByOfficerId;
    }

    public void setReviewedByOfficerId(int reviewedByOfficerId) {
        this.reviewedByOfficerId = reviewedByOfficerId;
    }

    public Date getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
    }

    public Date getReviewedAt() {
        return reviewedAt;
    }

    public void setReviewedAt(Date reviewedAt) {
        this.reviewedAt = reviewedAt;
    }
}
