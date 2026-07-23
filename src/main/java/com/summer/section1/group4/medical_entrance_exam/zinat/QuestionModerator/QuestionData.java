package com.summer.section1.group4.medical_entrance_exam.zinat.QuestionModerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * QuestionData is a simple shared "in-memory database" for the Question
 * Moderator module. Every time a new FXML view is loaded, JavaFX creates a
 * brand-new controller instance, so any normal (non-static) fields would be
 * lost as soon as the moderator switches goals/screens. To keep the data
 * alive across all 8 goals, we store everything here as static members that
 * every controller can read from / write to.
 *
 * This is intentionally simple (no real database, no file persistence)
 * since the project only needs to simulate the workflow for the duration
 * that the application is running.
 */
public class QuestionData {

    // ----- Goal 1: Set Code -> Examination Title -----
    public static Map<String, String> questionSets = new LinkedHashMap<>();

    // ----- Goal 2: Set Code -> list of MCQ questions belonging to that set -----
    public static Map<String, List<MCQQuestion>> questionBank = new LinkedHashMap<>();

    // ----- Goal 8: history log of every set that has been created -----
    public static List<String> setCreationHistoryLogs = new ArrayList<>();

    // ----- Goal 7: scoring weights (used later by Goal 4 analysis) -----
    public static double marksPerQuestion = 1.0;      // awarded mark for a correct answer
    public static double negativeMarksPerQuestion = -0.25; // deducted mark for a wrong answer

    // ----- Goal 3: pass mark threshold -----
    public static double passMarkPercentage = 40.0;

    private static final DateTimeFormatter TIMESTAMP_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");

    /**
     * Registers a brand-new question set and records a timestamped entry
     * in the history log (used by Goal 1 and later displayed in Goal 8).
     */
    public static void addSet(String setCode, String examTitle) {
        questionSets.put(setCode, examTitle);
        questionBank.put(setCode, new ArrayList<>());

        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
        setCreationHistoryLogs.add(setCode + " was successfully created on: " + timestamp);
    }

    /** Simple inline model for one multiple-choice question. */
    public static class MCQQuestion {
        public String questionText;
        public String optionA;
        public String optionB;
        public String optionC;
        public String optionD;

        public MCQQuestion(String questionText, String optionA, String optionB,
                           String optionC, String optionD) {
            this.questionText = questionText;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
        }
    }
}