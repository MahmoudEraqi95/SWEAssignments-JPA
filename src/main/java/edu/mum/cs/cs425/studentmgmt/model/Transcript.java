package edu.mum.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transcripts")
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;

    @Column(name = "degree_title", nullable = false)
    private String degreeTitle;

    // Default constructor (required by JPA)
    public Transcript() {}

    // Constructor with fields
    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    // Getters and Setters
    public Long getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(Long transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    @Override
    public String toString() {
        return "Transcript [transcriptId=" + transcriptId + ", degreeTitle=" + degreeTitle + "]";
    }
}

